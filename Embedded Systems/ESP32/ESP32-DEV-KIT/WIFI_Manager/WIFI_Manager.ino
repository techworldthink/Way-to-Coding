#include <WiFiManager.h>

void setup(){
  Serial.begin(115200);
  WiFiManager wifiManager;
  //wifiManager.resetSettings();
  wifiManager.autoConnect("AutoConnectAP");
}


void loop(){
}
