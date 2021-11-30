from gtts import gTTS 
from IPython.display import Audio 
tts = gTTS('I am Google') 
tts.save('1.wav')
sound_file = '1.wav'
Audio(sound_file, autoplay=True) 
