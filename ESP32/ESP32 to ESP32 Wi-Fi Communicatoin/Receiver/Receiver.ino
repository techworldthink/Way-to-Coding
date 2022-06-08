#include <WiFi.h>
// SSID and passcode  of your Router OR mobile hotspot
const char*Wifi_ssid = "MyGalaxy";
const char*Wifi_password = "galaxy@123";
//give Accesspoint SSID and passcode, your esp's hotspot name
const char *Apssid = "receiver_user";
const char *Appassword = "receiver_pass";



#include <AsyncTCP.h>
#include <ESPAsyncWebServer.h>
AsyncWebServer server(80);

const char index_html[] PROGMEM = R"rawliteral(
<html>
  <body>
    ok
  </body>
</html>
)rawliteral";

String processor(const String& var){
  return String();
}

void setup() {
  Serial.begin(115200);
  delay(500);
  WiFi.mode(WIFI_AP_STA);

  WiFi.softAP(Apssid, Appassword);
  WiFi.setSleep(false);
  // Set static IP
  IPAddress AP_LOCAL_IP(192, 168, 1, 160);
  IPAddress AP_GATEWAY_IP(192, 168, 1, 4);
  IPAddress AP_NETWORK_MASK(255, 255, 255, 0);
  if (!WiFi.softAPConfig(AP_LOCAL_IP, AP_GATEWAY_IP, AP_NETWORK_MASK)) {
    Serial.println("AP Config Failed");
    return;
  }
  IPAddress myIP = WiFi.softAPIP();
  Serial.print("Access Point IP address: ");
  Serial.println(myIP);
  
  Serial.println("");

  delay(1500);
  Serial.println("connecting to Wifi:");
  Serial.println(Wifi_ssid);

  WiFi.begin(Wifi_ssid, Wifi_password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());

  Serial.println("");

  server.on("/", HTTP_GET, [](AsyncWebServerRequest *request){
      String temperature_value;
      if (request->hasParam("tmp_value")) {
        temperature_value = request->getParam("tmp_value")->value();
        Serial.print("Received temperature value is : ");
        Serial.println(temperature_value);
      }
    request->send_P(200, "text/html", index_html, processor);
  });

  server.begin();
  
}

void loop() {


}
