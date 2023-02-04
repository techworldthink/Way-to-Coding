/*
 * ESP32-A1S ESP32 Audio Development Kit
 * SD CARD - SPIO Communication
 * FTP SERVER
 * 
 * Switch ON/OFF
 * 1-OFF
 * 2-ON
 * 3-ON
 * 4-OFF
 * 5-OFF
*/

#include <WiFi.h>
#include "ESP32FtpServer.h"

// SPI GPIOs
#define SD_CS         13
#define SPI_MOSI      15
#define SPI_MISO       2
#define SPI_SCK       14

const char* ssid = "*****";
const char* password = "*****";

FtpServer ftpSrv;

void setup(void) {
  Serial.begin(115200);

  WiFi.begin(ssid, password);

  pinMode(SD_CS, OUTPUT);
  digitalWrite(SD_CS, HIGH);
  
  SPI.begin(SPI_SCK, SPI_MISO, SPI_MOSI);
  SPI.setFrequency(1000000);

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

  //FTP Setup, ensure SD is started before ftp;
  if (SD.begin(SD_CS)) {
    Serial.println("SD opened!");
    //username, password for ftp.  set ports in ESP32FtpServer.h  (default 21, 50009 for PASV)
    ftpSrv.begin("esp32", "esp32");
  } else {
    Serial.println("SD open failed!");
  }
}

void loop(void) {
  ftpSrv.handleFTP();
}
