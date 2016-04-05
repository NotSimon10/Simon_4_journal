int sensorPin = 0;                   
int piezzoPin = 13;
int ledPins[] = {2,3,4,5,6,7,8,9};
void setup() 
{
  int index;
  pinMode(piezzoPin, OUTPUT);
  for(index = 0; index <= 7; index++) {
   pinMode(ledPins[index], OUTPUT);
  }
  Serial.begin(9600); 
}
void loop() 
{
  ledloop();
  int sensorValue;
  sensorValue = analogRead(sensorPin);    
  digitalWrite(piezzoPin, HIGH);
  Serial.print(sensorValue);
  Serial.print('\n');
  
  int i;
  
  int duration = 99999999999;
  int piezzoValue = sensorValue + 300;
  tone(piezzoPin, piezzoValue, duration);
  if(sensorValue <= 5) {
    tone(piezzoPin, 0, duration);
}
}

void ledloop()
{
  int sensorValue = analogRead(sensorPin);
  
  if(sensorValue < 127) {
    digitalWrite(ledPins[0], HIGH);
}
  if(sensorValue < 5) {
    digitalWrite(ledPins[0], LOW);
}
  if(sensorValue < 254 && sensorValue > 127) {
    digitalWrite(ledPins[1], HIGH);
}
  if(sensorValue < 127 ) {
    digitalWrite(ledPins[1], LOW);
}
if(sensorValue < 381 && sensorValue > 254) {
    digitalWrite(ledPins[2], HIGH);
}
if(sensorValue < 254) {
    digitalWrite(ledPins[2], LOW);
}
if(sensorValue < 508 && sensorValue > 381) {
    digitalWrite(ledPins[3], HIGH);
}
if(sensorValue < 381) {
    digitalWrite(ledPins[3], LOW);
}
if(sensorValue < 635 && sensorValue > 508) {
    digitalWrite(ledPins[4], HIGH);
}
if(sensorValue < 508) {
    digitalWrite(ledPins[4], LOW);
}
}




