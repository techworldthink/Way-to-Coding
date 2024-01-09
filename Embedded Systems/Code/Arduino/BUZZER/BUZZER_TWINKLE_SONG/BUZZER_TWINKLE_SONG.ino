const int speaker_pin = 9;
 
// Twinkle Twinkle Little Star
const int song_length = 28;
int song_freqs[] =    {262,   0, 262,   0, 392,   0, 392,   0, 
                       440,   0, 440,   0, 392,   0, 
                       349,   0, 349,   0, 329,   0, 329,   0, 
                       294,   0, 294,   0, 262,   0};
                         
float song_beats[] =  {  1, 0.1,   1, 0.1,   1, 0.1,   1, 0.1, 
                           1, 0.1,   1, 0.1,   2, 0.1,
                           1, 0.1,   1, 0.1,   1, 0.1,   1,   0.1,
                           1, 0.1,   1, 0.1,   2};
int song_tempo = 200;
 
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
