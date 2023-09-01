#include <WiFiManager.h>

void setup() {
  Serial.begin(115200);
  WiFiManager wifiManager;
  //wifiManager.resetSettings();

  IPAddress _ip = IPAddress(10, 0, 1, 78);
  IPAddress _gw = IPAddress(10, 0, 1, 1);
  IPAddress _sn = IPAddress(255, 255, 255, 0);
  wifiManager.setSTAStaticIPConfig(_ip, _gw, _sn);

  wifiManager.autoConnect("AutoConnectAP");

  Serial.println("local ip");
  Serial.println(WiFi.localIP());

}


void loop() {
}
