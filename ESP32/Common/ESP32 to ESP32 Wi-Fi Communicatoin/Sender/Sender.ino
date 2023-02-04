#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid     = "receiver_user";
const char* password = "receiver_pass";

const char* hostName = "192.168.1.160";
String post_request;
const char* resource_path = "/";


void turn_ON_WIFI() {
  WiFi.begin();
  Serial.println("WIFI ON");
  WiFi.begin(ssid, password);
  WiFi.setSleep(false);
  delay(2000);
}


void setup() {
  Serial.begin(115200);

  post_request = String("http://");
  post_request += hostName;

  turn_ON_WIFI();
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    String serverPath = post_request + resource_path + "?tmp_value=" + String(12345);
    http.begin(serverPath.c_str());
    int httpResponseCode = http.GET();

    if (httpResponseCode > 0) {
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
      String payload = http.getString();
      Serial.println(payload);
    }
    else {
      Serial.print("Error code: ");
      Serial.println(httpResponseCode);
    }

    http.end();
  }

  delay(3000);
}
