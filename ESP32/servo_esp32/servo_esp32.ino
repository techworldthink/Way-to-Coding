#include <ESP32Servo.h>

Servo myservo;
const int servo_pin = 18;
int pos = 0;

void setup() {
  myservo.attach(servo_pin);
}

void loop() {
  for (pos = 0; pos <= 180; pos += 1) {
    myservo.write(pos);
    delay(15);
  }
  for (pos = 180; pos >= 0; pos -= 1) {
    myservo.write(pos);
    delay(15);
  }
}
