
const int touch_sensor_pin = 2;

int touch_sensor_value = 0;

void setup() {
  Serial.begin(115200); 
  pinMode(touch_sensor_pin, INPUT);
}

void loop() {
  touch_sensor_value = digitalRead(touch_sensor_pin);
  Serial.println(touch_sensor_value);
  if(touch_sensor_value == HIGH){
    Serial.println("HIGH");
  }else{
    Serial.println("LOW");
  }
  delay(1000);
}
