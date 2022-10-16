#include <WiFi.h>
#include <AsyncTCP.h>
#include <ESPAsyncWebServer.h>

// Replace with your network credentials
const char* ssid = "DEN;BB JOBIN";
const char* password =  "jobin@1421";


// Create AsyncWebServer object on port 80
AsyncWebServer server(80);

const char index_html[] PROGMEM = R"rawliteral(
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        button{border:none;background-color: cadetblue;padding: 10px;}
    </style>

</head>
<body>
<h3>GPIO Controller</h3>
%BUTTONPLACEHOLDER%
<script>
function func() {
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function () {
       if (this.readyState == 4 && this.status == 200) {
          console.log(this.responseText);
       }
    };
    xhttp.open("GET", "/update?state=0", true);
    xhttp.send();
}        
</script>
</body>
</html>
)rawliteral";


String processor(const String& var){
  if(var == "BUTTONPLACEHOLDER"){
    String buttons = "<input type=\"checkbox\" onchange=\"func()\"></input>";
    return buttons;
  }
  return String();
}


void setup(){
  
  pinMode(2, OUTPUT);
  digitalWrite(2, LOW);
  
  // Serial port for debugging purposes
  Serial.begin(115200);
  
  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi..");
  }

  // Print ESP Local IP Address
  Serial.println(WiFi.localIP());

  // Route for root / web page
  server.on("/", HTTP_GET, [](AsyncWebServerRequest *request){
    request->send_P(200, "text/html", index_html, processor);
  });

server.on("/update", HTTP_GET, [] (AsyncWebServerRequest *request) {
  String inputMessage1;
  if (request->hasParam("state")) {
    inputMessage1 = request->getParam("state")->value();
    digitalWrite(2, inputMessage1.toInt());
    Serial.println("toggle..");
  }else{
    inputMessage1 = "No message sent";
  }
  request->send(200, "text/plain", "OK");
  
});


  // Start server
  server.begin();
}

void loop() {

}
