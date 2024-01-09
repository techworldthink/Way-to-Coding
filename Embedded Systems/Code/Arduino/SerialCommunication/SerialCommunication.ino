//Program to control LED through Serial comm
//LED connected to Pin 5
int led = 5;
//initialise character for storing data from computer
char data;

void setup() {
  //intialise Serial comm at 9600 baud rate
  Serial.begin(9600);
  //initialise pin 5 as output
  pinMode(led, OUTPUT);
}

void loop() {
  //check if data has been received in the serial buffer
  if (Serial.available() > 0)
  {
    // then read the serial buffer and store in a variable
    data = Serial.read();
    //if the character received is 1, then turn ON the LED
    //else if the character received in 0, the tirn OFF the LED
    if (data == '1')
    {
      digitalWrite(led, HIGH);
      Serial.println("LED is ON");
    }
    else if (data == '0')
    {
      digitalWrite(led, LOW);
      Serial.println("LED is OFF");
    }
  }
}
