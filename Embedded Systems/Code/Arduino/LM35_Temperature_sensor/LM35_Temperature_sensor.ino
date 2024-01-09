//Program: Temperature measurement using LM35

float val;
void setup() {
  //initialise serial baud rate to 9600
  Serial.begin(9600);
  //initialise the analog pin A4 as input
  pinMode(A4, INPUT);
}

void loop() {
  //read the temperature at Pin A4 and store in variable
  val = analogRead(A4);
  //convert the ADC value to degree celsius
  val = val * 500 / 1023;
  //print the variable value in serial
  Serial.print("Temperature is");
  Serial.println(val);
  //delay of 200ms
  delay(200);
}
