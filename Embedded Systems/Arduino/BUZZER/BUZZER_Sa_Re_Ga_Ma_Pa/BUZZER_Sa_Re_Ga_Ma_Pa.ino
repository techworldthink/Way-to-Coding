const int speaker_pin = 9;
 
// Twinkle Twinkle Little Star
const int song_length = 15;
int song_freqs[] =    {240,0,270,0,288,0,320,0,360,0,405,0,432,0,480,0};
float song_beats[] =  {  2,0.1,2,0.1,2,0.1,2,0.1,2,0.1,2,0.1,2,0.1,2,0.1};
int song_tempo = 300;
 
void setup() {
  pinMode(speaker_pin, OUTPUT);
}
 
void loop() {
  
  // Play each note
  for (int i = 0; i < song_length; i++) {
    int duration = song_beats[i] * song_tempo;  // Rounded down to nearest integer
      tone(speaker_pin, song_freqs[i], duration);
      delay(duration);
  }
  
  // Play silence
  tone(speaker_pin, 0, 100);
  
  delay(1000);
}
