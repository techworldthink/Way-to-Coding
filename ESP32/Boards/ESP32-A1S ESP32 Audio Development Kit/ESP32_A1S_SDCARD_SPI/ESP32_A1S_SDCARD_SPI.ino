/*
 * ESP32-A1S ESP32 Audio Development Kit
 * SD CARD - SPIO Communication
 * 
 * Switch ON/OFF
 * 1-OFF
 * 2-ON
 * 3-ON
 * 4-OFF
 * 5-OFF
*/

#include "Arduino.h"
#include "WiFi.h"
#include "SPI.h"
#include "SD.h"
#include "FS.h"
#include "Wire.h"

// SPI GPIOs
#define SD_CS         13
#define SPI_MOSI      15
#define SPI_MISO       2
#define SPI_SCK       14


void setup() {
  Serial.begin(115200);
  Serial.printf_P(PSTR("Free mem=%d\n"), ESP.getFreeHeap());

  pinMode(SD_CS, OUTPUT);
  digitalWrite(SD_CS, HIGH);
  
  SPI.begin(SPI_SCK, SPI_MISO, SPI_MOSI);
  SPI.setFrequency(1000000);

  if (!SD.begin(SD_CS)) {
    Serial.println("\n Mounting failed!");
  }else{
    Serial.println("\n Mounting sucsess");
  }
}


void loop() {
}
