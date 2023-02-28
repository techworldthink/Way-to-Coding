#include <ESP32Servo.h>

Servo myservo;
const int servo_pin = 18;
int crnt_pos = 0;
int pos;

void setup() {
  Serial.begin(115200);
  myservo.attach(servo_pin);
}

void loop() {
  servo_balance();
  delay(2000);s
  servo_left();
  delay(2000);
  servo_right();
  delay(2000);
}

void servo_balance() {
  if (crnt_pos >= 90 ) {
    for (pos = crnt_pos; pos >= 90; pos -= 1) {
      myservo.write(pos);
      delay(15);
    }
  } else {
    for (pos = crnt_pos; pos <= 90; pos += 1) {
      myservo.write(pos);
      delay(15);
    }
  }
  crnt_pos = pos - 1;
}

void servo_left() {
  for (pos = crnt_pos; pos >= 0; pos -= 1) {
    myservo.write(pos);
    delay(15);
  }
  crnt_pos = pos - 1;
}

void servo_right() {
  for (pos = crnt_pos; pos <= 180; pos += 1) {
    myservo.write(pos);
    delay(15);
  }
  crnt_pos = pos - 1;
}
