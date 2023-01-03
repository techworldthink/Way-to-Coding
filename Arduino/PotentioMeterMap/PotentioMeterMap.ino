//Program: Reading Potentiometer values
//potentiometer connected to pin A1

int pot;

void setup() {
  //initialise serial baud rate at 9600
  Serial.begin(9600);
  //initialise analog pin A1 as input
  pinMode(A1, INPUT);
}

void loop() {
  //Read the analog value at A1 and store in a variable
  pot = analogRead(A1);
  pot = map(pot, 0, 1023, 0, 5);
  //send the value to the serial port
  Serial.print("The Potentiometer value is ");
  Serial.println(pot);
  //delay of 200ms
  delay(200);
}
