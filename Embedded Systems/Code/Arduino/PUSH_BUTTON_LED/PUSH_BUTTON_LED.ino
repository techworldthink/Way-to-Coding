/*
  Push button + LED + Arduino

   Identify a digital pin on the Arduino board to which you want to connect the push button (e.g., pin 2).
   Connect the one leg of the push button to the 5V pin on the Arduino.
   Connect the other leg of the push button to the chosen digital pin on the Arduino.
   Connect the same leg of the push button to one end of a 10k ohm resistor.
   Connect the other end of the resistor to the ground (GND) pin on the Arduino.

   Identify a digital pin on the Arduino board to which you want to connect the LED (e.g., pin 13).
   Connect the longer leg (anode) of the LED to the chosen digital pin on the Arduino. This is the leg that connects to the positive voltage.
   Connect the shorter leg (cathode) of the LED to a current-limiting resistor (e.g., 220 ohms).
   Connect the other end of the resistor to the ground (GND) pin on the Arduino. This completes the circuit.
*/

// pushbutton pin
const int buttonPin = 2;
// LED PIN
const int ledPin = 13;


// variable for reading the pushbutton status
int buttonState = 0;

void setup() {
  // initialize the LED pin as an output
  pinMode(ledPin, OUTPUT);
  // initialize the pushbutton pin as an input
  pinMode(buttonPin, INPUT);
}

void loop() {
  // read the state of the pushbutton value
  buttonState = digitalRead(buttonPin);

  if (buttonState == HIGH) {
    // turn LED on:
    digitalWrite(ledPin, HIGH);
  } else {
    // turn LED off:
    digitalWrite(ledPin, LOW);
  }
}
