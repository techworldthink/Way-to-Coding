/*
 * ESP32-A1S ESP32 Audio Development Kit
 * SD CARD - SDIO Communication
 * 
 * Switch ON/OFF
 * 1-OFF
 * 2-ON
 * 3-ON
 * 4-OFF
 * 5-OFF
*/

#include "SD_MMC.h"

void setup() {
  Serial.begin(115200);
  
  if (!SD_MMC.begin("/sdcard", true)) {
    Serial.println("Card Mount Failed");
    return;
  } else {
    Serial.println("Card Mount Success");
  }
}

void loop() {
}
