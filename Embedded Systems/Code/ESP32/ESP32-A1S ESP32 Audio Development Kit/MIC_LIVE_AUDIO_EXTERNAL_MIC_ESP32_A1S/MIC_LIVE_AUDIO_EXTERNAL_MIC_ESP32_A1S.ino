#include "AudioKitHAL.h"

AudioKit kit;
const int BUFFER_SIZE = 1024;
uint8_t buffer[BUFFER_SIZE];

void setup() {
  LOGLEVEL_AUDIOKIT = AudioKitInfo; 
  Serial.begin(115200);
  auto cfg = kit.defaultConfig(AudioInputOutput);
  cfg.adc_input = AUDIO_HAL_ADC_INPUT_LINE1;
  cfg.sample_rate = AUDIO_HAL_16K_SAMPLES;
  kit.begin(cfg);
}

void loop() {
  size_t sound = kit.read(buffer, BUFFER_SIZE);
  kit.write(buffer, sound);
}
