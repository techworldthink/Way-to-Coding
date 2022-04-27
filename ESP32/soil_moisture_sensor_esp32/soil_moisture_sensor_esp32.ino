
const int moisture_sensor_pin = 34;

int moisture_sensor_value = 0;

void setup() {
  Serial.begin(115200); 
}

void loop() {
  moisture_sensor_value = analogRead(moisture_sensor_pin);
  Serial.println(moisture_sensor_value);
  delay(1000);
}
