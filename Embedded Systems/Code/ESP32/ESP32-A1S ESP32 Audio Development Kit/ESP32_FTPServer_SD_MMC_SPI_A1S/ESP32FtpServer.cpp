/*
   FTP Serveur for ESP8266
   based on FTP Serveur for Arduino Due and Ethernet shield (W5100) or WIZ820io (W5200)
   based on Jean-Michel Gallego's work
   modified to work with esp8266 SPIFFS by David Paiva david@nailbuster.com

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
    2017: modified by @robo8080
    2019: modified by @HenrikSte
    2023: modified by @techworldthink
*/

/*
   cmdStatus
   0 - disconnect client (check client.connected())
   1 - Ftp server waiting for connection
   2 - Ftp server idle
   3 - Ftp server waiting for user identity
   4 - Ftp server waiting for user registration
   5 - Ftp server waiting for user command

   transferStatus
   0 - data store / retrieve failed
   1 - Retrieve data
   2 - Store data

   command
   CDUP - Change to Parent Directory
   CWD  - Change Working Directory
   PWD  - Print Directory
   QUIT - disconnect client
   MODE - Transfer Mode
   PASV - Passive Connection management
   PORT - Data Port
   STRU - File Structure
   TYPE - Data Type
   ABOR - Abort transfer
   DELE - Delete a File
   LIST - List
   MLSD - Listing for Machine Processing (see RFC 3659)
   NLST - Name List
   NOOP
   RETR - Retrieve
   STOR - Store
   MKD  - Make Directory
   RMD  - Remove a Directory
   RNFR - Rename From
   RNTO - Rename To
   FEAT - New Features
   MDTM - File Modification Time (see RFC 3659)
   SIZE - Size of the file
   SITE - System command
*/


#include "ESP32FtpServer.h"
#include <WiFi.h>
#include <WiFiClient.h>
#include <FS.h>
#include "SD.h"
#include "SPI.h"

WiFiServer ftpServer( FTP_CTRL_PORT );
WiFiServer dataServer( FTP_DATA_PORT_PASV );

FtpServer::FtpServer() {
}

void FtpServer::begin(String uname, String pword) {
  // Tells the ftp server to begin listening for incoming connection
  _FTP_USER = uname;
  _FTP_PASS = pword;

  if (!SD.begin()) {
    Serial.println("Card Mount Failed");
    return;
  }

  uint8_t cardType = SD.cardType();

  if (cardType == CARD_NONE) {
    Serial.println("No SD card attached");
    return;
  }

  Serial.print("SD Card Type: ");
  if (cardType == CARD_MMC) {
    Serial.println("MMC");
  } else if (cardType == CARD_SD) {
    Serial.println("SDSC");
  } else if (cardType == CARD_SDHC) {
    Serial.println("SDHC");
  } else {
    Serial.println("UNKNOWN");
  }

  ftpServer.begin();
  delay(10);
  dataServer.begin();
  delay(10);
  millisTimeOut = (uint32_t)FTP_TIME_OUT * 60 * 1000;
  millisDelay = 0;
  cmdStatus = 0;
  iniVariables();
}

void FtpServer::iniVariables() {
  // Default for data port
  dataPort = FTP_DATA_PORT_PASV;

  // Default Data connection is Active
  dataPassiveConn = true;

  // Set the root directory
  strcpy( cwdName, "/" );

  rnfrCmd = false;
  transferStatus = 0;

}


int FtpServer::handleFTP() {
  if ((int32_t) ( millisDelay - millis() ) > 0 )
    return 0;

  if (ftpServer.hasClient()) {
    client.stop();
    client = ftpServer.available();
  }

  if ( cmdStatus == 0 ) {
    if ( client.connected())
      disconnectClient();
    cmdStatus = 1;
  } else if ( cmdStatus == 1 ) {
    // Ftp server waiting for connection
    abortTransfer();
    iniVariables();
#ifdef FTP_DEBUG
    Serial.println("Ftp server waiting for connection on port " + String(FTP_CTRL_PORT));
#endif
    cmdStatus = 2;
  } else if ( cmdStatus == 2 )  {
    // Ftp server idle
    if ( client.connected() ) {
      clientConnected();
      // wait client id during 10 s.
      millisEndConnection = millis() + 10 * 1000 ;
      cmdStatus = 3;
    }
  } else if ( readChar() > 0 ) {
    // got response
    // Ftp server waiting for user identity
    if ( cmdStatus == 3 )
      if ( userIdentity() )
        cmdStatus = 4;
      else
        cmdStatus = 0;
    // Ftp server waiting for user registration
    else if ( cmdStatus == 4 )
      if ( userPassword() ) {
        cmdStatus = 5;
        millisEndConnection = millis() + millisTimeOut;
      }
      else
        cmdStatus = 0;
    // Ftp server waiting for user command
    else if ( cmdStatus == 5 ) {
      if ( ! processCommand())
        cmdStatus = 0;
      else
        millisEndConnection = millis() + millisTimeOut;
    }
  } else if (!client.connected() || !client) {
    cmdStatus = 1;
#ifdef FTP_DEBUG
    Serial.println("client disconnected");
#endif
  }

  if ( transferStatus == 1 ) {
    // Retrieve data
    if ( ! doRetrieve())
      transferStatus = 0;
  } else if ( transferStatus == 2 ) {
    // Store data
    if ( ! doStore())
      transferStatus = 0;
  } else if ( cmdStatus > 2 && ! ((int32_t) ( millisEndConnection - millis() ) > 0 )) {
    client.println("530 Timeout");
    // delay of 200 ms
    millisDelay = millis() + 200;
    cmdStatus = 0;
  }
  return    transferStatus != 0 || cmdStatus     != 0;
}

void FtpServer::clientConnected() {
#ifdef FTP_DEBUG
  Serial.println("Client connected!");
#endif
  client.println( "220--- Welcome to FTP for ESP32 ---");
  client.println( "220---   By David Paiva   ---");
  client.println( "220 --   Version " + String(FTP_SERVER_VERSION) + "   --");
  iCL = 0;
}

void FtpServer::disconnectClient() {
#ifdef FTP_DEBUG
  Serial.println(" Disconnecting client");
#endif
  abortTransfer();
  client.println("221 Goodbye");
  client.stop();
}

boolean FtpServer::userIdentity() {
  if ( strcmp( command, "USER" ))
    client.println( "500 Syntax error");
  if ( strcmp( parameters, _FTP_USER.c_str() ))
    client.println( "530 user not found");
  else {
    client.println( "331 OK. Password required");
    strcpy( cwdName, "/" );
    return true;
  }
  // delay of 100 ms
  millisDelay = millis() + 100;
  return false;
}

boolean FtpServer::userPassword() {
  if ( strcmp( command, "PASS" ))
    client.println( "500 Syntax error");
  else if ( strcmp( parameters, _FTP_PASS.c_str() ))
    client.println( "530 ");
  else {
#ifdef FTP_DEBUG
    Serial.println( "OK. Waiting for commands.");
#endif
    client.println( "230 OK.");
    return true;
  }
  // delay of 100 ms
  millisDelay = millis() + 100;
  return false;
}



//------------------------ ACCESS CONTROL COMMANDS ------------------------//

boolean FtpServer::processCommand() {
  // Change to Parent Directory.
  if ( ! strcmp( command, "CDUP" )) {
    int todo;
    client.println("250 Ok. Current directory is \"" + String(cwdName) + "\"");
  }
  //  CWD - Change Working Directory
  else if ( ! strcmp( command, "CWD" )) {
    // 'CWD .' is the same as PWD command
    if ( strcmp( parameters, "." ) == 0 )
      client.println( "257 \"" + String(cwdName) + "\" is your current directory");
    else {
#ifdef FTP_DEBUG
      Serial.print("CWD P=");
      Serial.print(parameters);
      Serial.print(" CWD=");
      Serial.println(cwdName);
#endif
      String dir;

      if (parameters[0] == '/') {
        int length_ = strlen(parameters);
        // root directory
        if (length_ == 1) {
          dir = "/";
        } else {
          if (parameters[length_ - 1] == '/') {
            // remove "/" from the right side of uri
            dir = String(parameters).substring(0, length_ - 1);
          } else {
            dir = parameters;
          }
        }
      } else if (!strcmp(cwdName, "/")) {
        dir = String("/") + parameters;
      } else {
        dir = String(cwdName) + "/" + parameters;
      }

      if (SD.exists(dir)) {
        strcpy(cwdName, dir.c_str());
        client.println( "250 CWD Ok. Current directory is \"" + String(dir) + "\"");
        Serial.println( "250 CWD Ok. Current directory is \"" + String(dir) + "\"");
      } else {
        client.println( "550 directory or file does not exist \"" + String(parameters) + "\"");
        Serial.println( "550 directory or file does not exist \"" + String(parameters) + "\"");
      }
    }
  } else if ( ! strcmp( command, "PWD" )) {
    //  PWD - Print Directory
    client.println( "257 \"" + String(cwdName) + "\" is your current directory");
  } else if ( ! strcmp( command, "QUIT" )) {
    //  QUIT
    disconnectClient();
    return false;
  }



  //------------------------ TRANSFER PARAMETER COMMANDS ------------------------//

  //  MODE - Transfer Mode
  else if ( ! strcmp( command, "MODE" )) {
    if ( ! strcmp( parameters, "S" ))
      client.println( "200 S Ok");
    else
      client.println( "504 Only S(tream) is suported");
  }

  //  PASV - Passive Connection management
  else if ( ! strcmp( command, "PASV" )) {
    if (data.connected()) data.stop();
    dataIp = WiFi.localIP();
    dataPort = FTP_DATA_PORT_PASV;
#ifdef FTP_DEBUG
    Serial.println("Connection management set to passive");
    Serial.println( "Data port set to " + String(dataPort));
#endif
    client.println( "227 Entering Passive Mode (" + String(dataIp[0]) + "," + String(dataIp[1]) + "," + String(dataIp[2]) + "," + String(dataIp[3]) + "," + String( dataPort >> 8 ) + "," + String ( dataPort & 255 ) + ").");
    dataPassiveConn = true;
  }

  //  PORT - Data Port
  else if ( ! strcmp( command, "PORT" )) {
    if (data) data.stop();
    // get IP of data client
    dataIp[ 0 ] = atoi( parameters );
    char * p = strchr( parameters, ',' );
    for ( uint8_t i = 1; i < 4; i ++ ) {
      dataIp[ i ] = atoi( ++ p );
      p = strchr( p, ',' );
    }
    // get port of data client
    dataPort = 256 * atoi( ++ p );
    p = strchr( p, ',' );
    dataPort += atoi( ++ p );
    if ( p == NULL )
      client.println( "501 Can't interpret parameters");
    else {
      client.println("200 PORT command successful");
      dataPassiveConn = false;
    }
  }

  //  STRU - File Structure
  else if ( ! strcmp( command, "STRU" )) {
    if ( ! strcmp( parameters, "F" ))
      client.println( "200 F Ok");
    // else if( ! strcmp( parameters, "R" ))
    //  client.println( "200 B Ok\r\n";
    else
      client.println( "504 Only F(ile) is suported");
  }

  //  TYPE - Data Type
  else if ( ! strcmp( command, "TYPE" )) {
    if ( ! strcmp( parameters, "A" ))
      client.println( "200 TYPE is now ASII");
    else if ( ! strcmp( parameters, "I" ))
      client.println( "200 TYPE is now 8-bit binary");
    else
      client.println( "504 Unknow TYPE");
  }



  //------------------------ FTP SERVICE COMMANDS ------------------------//


  //  ABOR - Abort
  else if ( ! strcmp( command, "ABOR" )) {
    abortTransfer();
    client.println( "226 Data connection closed");
  }

  //  DELE - Delete a File
  else if ( ! strcmp( command, "DELE" )) {
    char path[ FTP_CWD_SIZE ];
    if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( path )) {
      if ( ! SD.exists( path ))
        client.println( "550 File " + String(parameters) + " not found");
      else {
        if ( SD.remove( path ))
          client.println( "250 Deleted " + String(parameters) );
        else
          client.println( "450 Can't delete " + String(parameters));
      }
    }
  }

  //  LIST - List
  else if ( ! strcmp( command, "LIST" )) {
    if ( ! dataConnect())
      client.println( "425 No data connection");
    else {
      client.println( "150 Accepted data connection");
      uint16_t nm = 0;
      File dir = SD.open(cwdName);
      if ((!dir) || (!dir.isDirectory()))
        client.println( "550 Can't open directory " + String(cwdName) );
      else {
        File file = dir.openNextFile();
        while ( file) {
          String fn, fs;
          fn = file.name();
#ifdef FTP_DEBUG
          Serial.println("File Name = " + fn);
#endif
          fs = String(file.size());
          if (file.isDirectory()) {
            data.println( "01-01-2000  00:00AM <DIR> " + fn);
          } else {
            data.println( "01-01-2000  00:00AM " + fs + " " + fn);
          }
          nm ++;
          file = dir.openNextFile();
        }
        client.println( "226 " + String(nm) + " matches total");
      }
      data.stop();
    }
  }

  //  MLSD - Listing for Machine Processing (see RFC 3659)
  else if ( ! strcmp( command, "MLSD" )) {
    if ( ! dataConnect()) {
      client.println( "425 No data connection MLSD");
    }
    else {
      client.println( "150 Accepted data connection");
      uint16_t nm = 0;
      File dir = SD.open(cwdName);
      if ((!dir) || (!dir.isDirectory()))
        client.println( "550 Can't open directory " + String(cwdName) );
      else {
        File file = dir.openNextFile();
        while ( file) {
          String fn, fs;
          fn = file.name();
          Serial.println(fn);

          if (fn[0] == '/') {
            fn.remove(0, strlen(cwdName));
          }

          fs = String(file.size());
          if (file.isDirectory()) {
            data.println( "Type=dir;Size=" + fs + ";" + "modify=20000101000000;" + " " + fn);
          } else {
            data.println( "Type=file;Size=" + fs + ";" + "modify=20000101000000;" + " " + fn);
          }
          nm ++;
          file = dir.openNextFile();
        }
        client.println( "226-options: -a -l");
        client.println( "226 " + String(nm) + " matches total");
      }
      data.stop();
    }
  }

  //  NLST - Name List
  else if ( ! strcmp( command, "NLST" )) {
    if ( ! dataConnect())
      client.println( "425 No data connection");
    else {
      client.println( "150 Accepted data connection");
      uint16_t nm = 0;
      File dir = SD.open(cwdName);
      if ( !SD.exists( cwdName ))
        client.println( "550 Can't open directory " + String(parameters));
      else {
        File file = dir.openNextFile();
        while ( file) {
          data.println( file.name());
          nm ++;
          file = dir.openNextFile();
        }
        client.println( "226 " + String(nm) + " matches total");
      }
      data.stop();
    }
  }

  //  NOOP
  else if ( ! strcmp( command, "NOOP" )) {
    client.println( "200 Zzz...");
  }

  //  RETR - Retrieve
  else if ( ! strcmp( command, "RETR" )) {
    char path[ FTP_CWD_SIZE ];
    if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( path )) {
      file = SD.open(path, "rb");
      if ( !file)
        client.println( "550 File " + String(parameters) + " not found");
      else if ( !file )
        client.println( "450 Can't open " + String(parameters));
      else if ( ! dataConnect())
        client.println( "425 No data connection");
      else {
#ifdef FTP_DEBUG
        Serial.println("Sending " + String(parameters));
#endif
        client.println( "150-Connected to port " + String(dataPort));
        client.println( "150 " + String(file.size()) + " bytes to download");
        millisBeginTrans = millis();
        bytesTransfered = 0;
        transferStatus = 1;
      }
    }
  }

  //  STOR - Store
  else if ( ! strcmp( command, "STOR" )) {
    char path[ FTP_CWD_SIZE ];
    if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( path )) {
      file = SD.open(path, "w");
      if ( !file)
        client.println( "451 Can't open/create " + String(parameters) );
      else if ( ! dataConnect()) {
        client.println( "425 No data connection");
        file.close();
      } else {
#ifdef FTP_DEBUG
        Serial.println( "Receiving " + String(parameters));
#endif
        client.println( "150 Connected to port " + String(dataPort));
        millisBeginTrans = millis();
        bytesTransfered = 0;
        transferStatus = 2;
      }
    }
  }

  //  MKD - Make Directory
  else if ( ! strcmp( command, "MKD" )) {
#ifdef FTP_DEBUG
    Serial.print("MKD P=");
    Serial.print(parameters);
    Serial.print(" CWD=");
    Serial.println(cwdName);
#endif
    String dir;

    if (!strcmp(cwdName, "/")) {
      dir = String("/") + parameters;
    } else {
      dir = String(cwdName) + "/" + parameters;
    }

#ifdef FTP_DEBUG
    Serial.print("try to create  ");
    Serial.println(dir);
#endif

    fs::FS &fs = SD;
    if (fs.mkdir(dir.c_str())) {
      client.println( "257 \"" + String(parameters) + "\" - Directory successfully created");
    } else {
      client.println( "502 Can't create \"" + String(parameters));
    }
  }

  //  RMD - Remove a Directory
  else if ( ! strcmp( command, "RMD" )) {
#ifdef FTP_DEBUG
    Serial.print("RMD ");
    Serial.print(parameters);
    Serial.print(" CWD=");
    Serial.println(cwdName);
#endif
    String dir;

    if (!strcmp(cwdName, "/")) {
      dir = String("/") + parameters;
    } else {
      dir = String(cwdName) + "/" + parameters;
    }
    fs::FS &fs = SD;
    if (fs.rmdir(dir.c_str())) {
      client.println( "250 RMD command successful");
    } else {
      client.println( "502 Can't delete \"" + String(parameters));
    }
  }

  //  RNFR - Rename From
  else if ( ! strcmp( command, "RNFR" )) {
    buf[ 0 ] = 0;
    if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( buf )) {
      if ( ! SD.exists( buf ))
        client.println( "550 File " + String(parameters) + " not found");
      else {
#ifdef FTP_DEBUG
        Serial.println("Renaming " + String(buf));
#endif
        client.println( "350 RNFR accepted - file exists, ready for destination");
        rnfrCmd = true;
      }
    }
  }

  //  RNTO - Rename To
  else if ( ! strcmp( command, "RNTO" )) {
    char path[ FTP_CWD_SIZE ];
    if ( strlen( buf ) == 0 || ! rnfrCmd )
      client.println( "503 Need RNFR before RNTO");
    else if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( path )) {
      if ( SD.exists( path ))
        client.println( "553 " + String(parameters) + " already exists");
      else {
#ifdef FTP_DEBUG
        Serial.println("Renaming " + String(buf) + " to " + String(path));
#endif
        if ( SD.rename( buf, path ))
          client.println( "250 File successfully renamed or moved");
        else
          client.println( "451 Rename/move failure");
      }
    }
    rnfrCmd = false;
  }


  //------------------------ EXTENSIONS COMMANDS (RFC 3659) ------------------------//


  //  FEAT - New Features
  else if ( ! strcmp( command, "FEAT" )) {
    client.println( "211-Extensions suported:");
    client.println( " MLSD");
    client.println( "211 End.");
  }

  //  MDTM - File Modification Time (see RFC 3659)
  else if (!strcmp(command, "MDTM")) {
    client.println("550 Unable to retrieve time");
  }

  //  SIZE - Size of the file
  else if ( ! strcmp( command, "SIZE" )) {
    char path[ FTP_CWD_SIZE ];
    if ( strlen( parameters ) == 0 )
      client.println( "501 No file name");
    else if ( makePath( path )) {
      file = SD.open(path, "r");
      if (!file)
        client.println( "450 Can't open " + String(parameters) );
      else {
        client.println( "213 " + String(file.size()));
        file.close();
      }
    }
  }

  //  SITE - System command
  else if ( ! strcmp( command, "SITE" )) {
    client.println( "500 Unknow SITE command " + String(parameters) );
  }

  //  Unrecognized commands
  else
    client.println( "500 Unknow command");

  return true;
}

boolean FtpServer::dataConnect() {
  unsigned long startTime = millis();
  if (!data.connected()) {
    while (!dataServer.hasClient() && millis() - startTime < 10000) {
      yield();
    }
    if (dataServer.hasClient()) {
      data.stop();
      data = dataServer.available();
#ifdef FTP_DEBUG
      Serial.println("ftpdataserver client....");
#endif
    }
  }
  return data.connected();
}

boolean FtpServer::doRetrieve() {
  int16_t nb = file.readBytes(buf, FTP_BUF_SIZE);
  if ( nb > 0 ) {
    data.write((uint8_t*) buf, nb );
    bytesTransfered += nb;
    return true;
  }
  closeTransfer();
  return false;
}

unsigned long count = 0;

boolean FtpServer::doStore() {
  if ( data.connected()) {
    unsigned long ms0 = millis();
    int16_t nb = data.readBytes((uint8_t*) buf, FTP_BUF_SIZE );
    if ( nb > 0 ) {
      size_t written = file.write((uint8_t*) buf, nb );
      bytesTransfered += nb;
    } else {
      Serial.println(".");
    }
    return true;
  }
  closeTransfer();
  return false;
}

void FtpServer::closeTransfer() {
  uint32_t deltaT = (int32_t) ( millis() - millisBeginTrans );
  if ( deltaT > 0 && bytesTransfered > 0 ) {
    client.println( "226-File successfully transferred");
    client.println( "226 " + String(deltaT) + " ms, " + String(bytesTransfered / deltaT) + " kbytes/s");
  } else
    client.println( "226 File successfully transferred");
  file.close();
  data.stop();
}

void FtpServer::abortTransfer() {
  if ( transferStatus > 0 ) {
    file.close();
    data.stop();
    client.println( "426 Transfer aborted"  );
#ifdef FTP_DEBUG
    Serial.println( "Transfer aborted!") ;
#endif
  }
  transferStatus = 0;
}

/*  Read a char from client connected to ftp server
    Update cmdLine and command buffers, iCL and parameters pointers

    return:
      -2 if buffer cmdLine is full
      -1 if line not completed
       0 if empty line received
      length of cmdLine (positive) if no empty line received
*/

int8_t FtpServer::readChar() {
  int8_t rc = -1;
  if ( client.available()) {
    char c = client.read();
#ifdef FTP_DEBUG
    Serial.print( c);
#endif
    if ( c == '\\' ) {
      c = '/';
    }
    if ( c != '\r' ) {
      if ( c != '\n' ) {
        if ( iCL < FTP_CMD_SIZE )
          cmdLine[ iCL ++ ] = c;
        else
          rc = -2; //  Line too long
      } else {
        cmdLine[ iCL ] = 0;
        command[ 0 ] = 0;
        parameters = NULL;
        // empty line?
        if ( iCL == 0 )
          rc = 0;
        else {
          rc = iCL;
          // search for space between command and parameters
          parameters = strchr( cmdLine, ' ' );
          if ( parameters != NULL ) {
            if ( parameters - cmdLine > 4 ) {
              rc = -2; // Syntax error
            } else {
              strncpy( command, cmdLine, parameters - cmdLine );
              command[ parameters - cmdLine ] = 0;
              while ( * ( ++ parameters ) == ' ' );
            }
          }
          else if ( strlen( cmdLine ) > 4 )
            rc = -2; // Syntax error.
          else
            strcpy( command, cmdLine );
          iCL = 0;
        }
      }
    }
    if ( rc > 0 ) {
      for ( uint8_t i = 0 ; i < strlen( command ); i ++ ) {
        command[ i ] = toupper( command[ i ] );
      }
    }
    if ( rc == -2 ) {
      iCL = 0;
      client.println( "500 Syntax error");
    }
  }
  return rc;
}

/* Make complete path/name from cwdName and parameters
   3 possible cases: parameters can be absolute path, relative path or only the name

   parameters:
     fullName : where to store the path/name

   return:
      true, if done
*/

boolean FtpServer::makePath( char * fullName ) {
  return makePath( fullName, parameters );
}

boolean FtpServer::makePath( char * fullName, char * param ) {
  if ( param == NULL )
    param = parameters;

  // Root or empty?
  if ( strcmp( param, "/" ) == 0 || strlen( param ) == 0 ) {
    strcpy( fullName, "/" );
    return true;
  }
  // If relative path, concatenate with current dir
  if ( param[0] != '/' ) {
    strcpy( fullName, cwdName );
    if ( fullName[ strlen( fullName ) - 1 ] != '/' )
      strncat( fullName, "/", FTP_CWD_SIZE );
    strncat( fullName, param, FTP_CWD_SIZE );
  }
  else
    strcpy( fullName, param );
  // If ends with '/', remove it
  uint16_t strl = strlen( fullName ) - 1;
  if ( fullName[ strl ] == '/' && strl > 1 )
    fullName[ strl ] = 0;
  if ( strlen( fullName ) < FTP_CWD_SIZE )
    return true;

  client.println( "500 Command line too long");
  return false;
}

/* Calculate year, month, day, hour, minute and second
   From first parameter sent by MDTM command (YYYYMMDDHHMMSS)

   parameters:
     pyear, pmonth, pday, phour, pminute and psecond: pointer of
       variables where to store data

   return:
      0 if parameter is not YYYYMMDDHHMMSS
      length of parameter + space
*/

uint8_t FtpServer::getDateTime( uint16_t * pyear, uint8_t * pmonth, uint8_t * pday,
                                uint8_t * phour, uint8_t * pminute, uint8_t * psecond ) {
  char dt[ 15 ];

  // Date/time are expressed as a 14 digits long string
  // terminated by a space and followed by name of file
  if ( strlen( parameters ) < 15 || parameters[ 14 ] != ' ' )
    return 0;
  for ( uint8_t i = 0; i < 14; i++ )
    if ( ! isdigit( parameters[ i ]))
      return 0;

  strncpy( dt, parameters, 14 );
  dt[ 14 ] = 0;
  * psecond = atoi( dt + 12 );
  dt[ 12 ] = 0;
  * pminute = atoi( dt + 10 );
  dt[ 10 ] = 0;
  * phour = atoi( dt + 8 );
  dt[ 8 ] = 0;
  * pday = atoi( dt + 6 );
  dt[ 6 ] = 0 ;
  * pmonth = atoi( dt + 4 );
  dt[ 4 ] = 0 ;
  * pyear = atoi( dt );
  return 15;
}

/* Create string YYYYMMDDHHMMSS from date and time

   parameters:
      date, time
      tstr: where to store the string. Must be at least 15 characters long

   return:
      pointer to tstr
*/

char * FtpServer::makeDateTimeStr( char * tstr, uint16_t date, uint16_t time ) {
  sprintf( tstr, "%04u%02u%02u%02u%02u%02u",
           (( date & 0xFE00 ) >> 9 ) + 1980, ( date & 0x01E0 ) >> 5, date & 0x001F,
           ( time & 0xF800 ) >> 11, ( time & 0x07E0 ) >> 5, ( time & 0x001F ) << 1 );
  return tstr;
}
