/*
 *  ESP32 to SD MMC card
 *  SDIO Communications
 *
 *  SD_MMC | ESP32
 *  D2       GPIO12
 *  D3       GPIO13
 *  CMD      GPIO15
 *  VSS      GND
 *  VDD      3.3V
 *  CLK      GPIO14
 *  VSS      GND
 *  D0       GPIO2
 *  D1       GPIO4
 */


#include "FS.h"
#include "SD_MMC.h"

// Functions
void listDir(fs::FS &fs, const char * dirname, uint8_t levels);
void createDir(fs::FS &fs, const char * path);
void removeDir(fs::FS &fs, const char * path);
void readFile(fs::FS &fs, const char * path);
void writeFile(fs::FS &fs, const char * path, const char * message);
void appendFile(fs::FS &fs, const char * path, const char * message);
void renameFile(fs::FS &fs, const char * path1, const char * path2);
void deleteFile(fs::FS &fs, const char * path);
void testFileIO(fs::FS &fs, const char * path);


void setup() {
  Serial.begin(115200);

  if (!SD_MMC.begin("/sdcard", true)) {
    Serial.println("Card Mount Failed");
    return;
  }
  uint8_t cardType = SD_MMC.cardType();

  if (cardType == CARD_NONE) {
    Serial.println("No SD_MMC card attached");
    return;
  }

  Serial.print("SD_MMC Card Type: ");
  if (cardType == CARD_MMC) {
    Serial.println("MMC");
  } else if (cardType == CARD_SD) {
    Serial.println("SDSC");
  } else if (cardType == CARD_SDHC) {
    Serial.println("SDHC");
  } else {
    Serial.println("UNKNOWN");
  }

  uint64_t cardSize = SD_MMC.cardSize() / (1024 * 1024);
  Serial.printf("SD_MMC Card Size: %lluMB\n", cardSize);

  listDir(SD_MMC, "/", 0);
  createDir(SD_MMC, "/mydir");
  listDir(SD_MMC, "/", 0);
  removeDir(SD_MMC, "/mydir");
  listDir(SD_MMC, "/", 2);
  writeFile(SD_MMC, "/hello.txt", "Hello ");
  appendFile(SD_MMC, "/hello.txt", "World!\n");
  readFile(SD_MMC, "/hello.txt");
  deleteFile(SD_MMC, "/foo.txt");
  renameFile(SD_MMC, "/hello.txt", "/foo.txt");
  readFile(SD_MMC, "/foo.txt");
  testFileIO(SD_MMC, "/test.txt");
  Serial.printf("Total space: %lluMB\n", SD_MMC.totalBytes() / (1024 * 1024));
  Serial.printf("Used space: %lluMB\n", SD_MMC.usedBytes() / (1024 * 1024));
}

void loop() {
}
