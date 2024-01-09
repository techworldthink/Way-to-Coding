//Program:LDR night lamp
//LED connected to pin 5
//LDR pull down connection at pin A4

int var;
//max value of LDR
int ldrmax = 700;
//min value of LDR
int ldrmin = 300;
//variable for pin of LED
int rled = 5;

void setup() {
  //initialise serial baud rate at 9600
  Serial.begin(9600);
  //initialise analog pin A4 as input
  pinMode(A4, INPUT);
}

void loop() {
  //read the analog value at pin A4 and store in a variable
  var = analogRead(A4);
  // if value > ldrmax, turn OFF the LED
  if (var > ldrmax)
    digitalWrite(rled, LOW);
  //if value < ldrmin, turn ON the LED
  else if (var < ldrmin)
    digitalWrite(rled, HIGH);
  //delay of 200ms
  delay(200);
}
