void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop() {
  digitalWrite(LED_BUILTIN, HIGH);
  // 2 s
  delay(2000);                     
  digitalWrite(LED_BUILTIN, LOW);   
  delay(1000); 
}
