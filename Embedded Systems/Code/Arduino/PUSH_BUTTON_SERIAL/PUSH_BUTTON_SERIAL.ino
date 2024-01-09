/*
 *Push button + Arduino
 *
 * Identify a digital pin on the Arduino board to which you want to connect the push button (e.g., pin 2).
 * Connect the one leg of the push button to the 5V pin on the Arduino.
 * Connect the other leg of the push button to the chosen digital pin on the Arduino.
 * Connect the same leg of the push button to one end of a 10k ohm resistor.
 * Connect the other end of the resistor to the ground (GND) pin on the Arduino.
 */

// pushbutton pin
const int buttonPin = 2;


// variable for reading the pushbutton status
int buttonState = 0;

void setup() {
  Serial.begin(9600);
  // initialize the pushbutton pin as an input
  pinMode(buttonPin, INPUT);
}

void loop() {
  // read the state of the pushbutton value:
  buttonState = digitalRead(buttonPin);

  if (buttonState == HIGH) {
    Serial.println("ON");
  } else {
    Serial.println("OFF");
  }
  delay(1000);
}
