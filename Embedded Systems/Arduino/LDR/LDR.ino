//Program:Reading LDR values
//LDR pull down connection at pin A4

int ldr;
void setup() {
  //initialise serial baud rate at 9600
  Serial.begin(9600);
  //initialise analog pin A4 as input
  pinMode(A4, INPUT);
}

void loop() {
  //Read the analog value at pin A4 and store in a variable
  ldr = analogRead(A4);
  //send value to the serial port
  Serial.print("LDR value is ");
  Serial.println(ldr);
  //delay of 200 ms
  delay(200);
}
