#include "SPIFFS.h"
#include <WiFi.h>

// Credential file
String fileName = "/credentials.txt";

// Demo credentials
String ssid = "test";
String pass = "12345678";

void setup() {

  File file;
  Serial.begin(115200);

  // Mount SPIFFS
  if (!SPIFFS.begin(true)) {
    Serial.println("An Error has occurred while mounting SPIFFS");
    return;
  }

  // Open file for writing -  SSID
  file = SPIFFS.open(fileName, FILE_WRITE);
  if (!file) {
    Serial.println("There was an error opening the file for writing");
    return;
  }
  // Write SSID
  if (file.println(ssid)) {
    Serial.println("SSID Written");
  }

  // Open file for appending -  SSID
  file = SPIFFS.open(fileName, FILE_APPEND);
  if (!file) {
    Serial.println("There was an error opening the file for appending");
    return;
  }
  // Write PASS
  if (file.println(pass)) {
    Serial.println("Password Was Written");
  }

  file.close();

  // Open file for reading - SSID & PASS
  file = SPIFFS.open(fileName);
  if (!file) {
    Serial.println("There was an error opening the file for reading");
    return;
  } else {
    Serial.println("Opening the file for reading");
  }
  Serial.println("File Content : ");

  int i = 0;
  String s, p;
  while (file.available()) {
    if (i == 0)
      s = file.readStringUntil('\n');
    else
      p = file.readStringUntil('\n');
    i++;
  }
  file.close();
  
  # remove unwanted whitespaces
  s.trim();
  p.trim();

  // Print credentials
  Serial.println(s.c_str());
  Serial.println(p.c_str());

  WiFi.softAP(s.c_str(), p.c_str());
  Serial.print("Connecting to WiFi..");

}

void loop() {
  }
