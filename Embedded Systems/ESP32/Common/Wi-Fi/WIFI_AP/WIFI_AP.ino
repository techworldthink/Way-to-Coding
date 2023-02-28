#include <WiFi.h>

// Replace with your network credentials
const char* ssid = "ESP32-Access-Point";
const char* password =  "password";

void setup() {
  Serial.begin(115200);

  Serial.print("Setting AP (Access Point)…");
  WiFi.softAP(ssid, password);
  IPAddress IP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(IP);

}

void loop() {
}


/*
  .softAP(const char* ssid, const char* password, int channel, int ssid_hidden, int max_connection)

  SSID (defined earlier): maximum of 63 characters;
  password(defined earlier): minimum of 8 characters; set to NULL if you want the access point to be open
  channel: Wi-Fi channel number (1-13)
  ssid_hidden: (0 = broadcast SSID, 1 = hide SSID)
  max_connection: maximum simultaneous connected clients (1-4)

*/
