/*
 * US100 - Arduino UNO
 * serial mode
 * 
 * VCC  - 5V
 * GND  - GND
 * Trig/TX  - 3 
 * echo/RX  - 2
 * 
 */

 /*
  * 0x55: distance measurement request
  * 0x50: temperature measurement request
  * 
  */


#include <SoftwareSerial.h>

// Create a SoftwareSerial object named us100_serial with RX on pin 2 and TX on pin 3
SoftwareSerial us100_serial(2, 3);

// Variables to store high and low bytes of distance measurement
unsigned int HighByte = 0;
unsigned int LowByte  = 0;

// Variable to store the calculated distance
unsigned int distance  = 0;

void setup() {
  // Start communication with the hardware serial port (for debugging)
  Serial.begin(9600);
  
  // Start communication with the software serial port (us100_serial)
  us100_serial.begin(9600);
}

void loop() {
  // Clear the input buffer of us100_serial
  us100_serial.flush();
  
  // Send the command (0x55) to trigger the US-100 sensor to begin distance measurement
  us100_serial.write(0X55);
  
  // Wait for the sensor to process the measurement
  delay(500);
  
  // Check if at least 2 bytes are available to read from us100_serial
  if (us100_serial.available() >= 2) {
    // Read the high and low bytes of the distance measurement
    HighByte = us100_serial.read();
    LowByte  = us100_serial.read();
    
    // Calculate the distance using the high and low bytes
    distance  = HighByte * 256 + LowByte;
    
    // Check if the calculated distance is within a reasonable range
    if ((distance > 1) && (distance < 10000)) {
      // Print the calculated distance in millimeters
      Serial.print("Distance: ");
      Serial.print(distance, DEC);
      Serial.println(" mm");
    }
  }
  
  // Delay before taking another measurement
  delay(1000);
}
