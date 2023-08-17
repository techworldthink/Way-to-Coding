/*
 * HC-SR04 - Arduino UNO
 * 
 * VCC  - 5V
 * GND  - GND
 * Trig/TX  - 3 
 * echo/RX  - 2
 * 
 */


// Define the pins for triggering and receiving the ultrasonic sensor
const int trigPin = 3;  // Pin connected to the trigger pin of the sensor
const int echoPin = 2;  // Pin connected to the echo pin of the sensor

// Variables to store the duration of the pulse and calculated distance
float duration, distance;

void setup() {
  // Set the trigger pin as an output and the echo pin as an input
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  // Initialize serial communication for debugging
  Serial.begin(9600);
}

void loop() {
  // Send a short LOW pulse to the trigger pin to ensure a clean trigger
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  
  // Send a HIGH pulse to the trigger pin for 10 microseconds to start the measurement
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Measure the duration of the pulse on the echo pin
  duration = pulseIn(echoPin, HIGH);
  
  // Calculate the distance using the speed of sound and the duration of the pulse
  // Speed of sound = 343 meters/second = 0.0343 cm/microsecond
  // Divide by 2 since the sound travels to the object and back
  distance = (duration * 0.0343) / 2;
  
  // Print the calculated distance to the serial monitor
  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");
  
  // Delay before taking another measurement
  delay(1000);
}
