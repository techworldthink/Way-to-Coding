/*
 * ESP32-A1S ESP32 Audio Development Kit
 * SD CARD - SDIO
 * FTP Server
 * 
 * Switch ON/OFF
 * 1-OFF
 * 2-ON
 * 3-ON
 * 4-OFF
 * 5-OFF
*/

#include <WiFi.h>
#include <WiFiClient.h>
#include "ESP32FtpServer.h"

const char* ssid = "******";
const char* password = "******";

FtpServer ftpSrv;

void setup(void){
  Serial.begin(115200);


  WiFi.begin(ssid, password);
  Serial.println("");
  pinMode(19, INPUT_PULLUP);

  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());

  if (SD_MMC.begin("/sdcard", true)) {
      Serial.println("SD opened!");
      ftpSrv.begin("esp32","esp32");    //username, password for ftp.  set ports in ESP32FtpServer.h  (default 21, 50009 for PASV)
  }    
}

void loop(void){
  ftpSrv.handleFTP();

}
