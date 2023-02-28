
// 11 to RELAY INPUT / LED PIN
int led = 11;

int input;
void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
}

void loop() {
  input = analogRead(A0);
  //By changing the denomintor the sensitivity can be changed
  input = input / 33;
  Serial.println(input);
  if (input > 2) {
    if (input == 0) {
      digitalWrite(led, HIGH);
    }
    else if (input == 1) {
      digitalWrite(led, HIGH);
    }
    else {
      digitalWrite(led, LOW);
      delay(5);
      digitalWrite(led, HIGH);

    }
  }
}
