//Program: Control of LED using potentiometer
//potentiometer connected to pin A1
//LED connected to pin 3

int pot;
int rled = 3;

void setup() {
  //initialise the analog pin A1 as input
  pinMode(A1, INPUT);
  //initialise pin 3 as output
  pinMode(rled, OUTPUT);
}

void loop() {
  //Read the analog value and store in a varible
  pot = analogRead(A1);
  //map the variable from 0-1023 to 0-255
  pot = map(pot, 0, 1023, 0, 255);
  //control the brightness of the LED
  analogWrite(rled, pot);
  //delay of 200ms
  delay(200);
}
