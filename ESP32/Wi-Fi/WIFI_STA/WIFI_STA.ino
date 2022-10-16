#include <WiFi.h>

// Replace with your network credentials
const char* ssid = "DEN;BB JOBIN";
const char* password =  "jobin@1421";

void setup() {
  Serial.begin(115200);

  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi..");
  }
  // Print ESP Local IP Address
  Serial.println(WiFi.localIP());

}

void loop() {
}
