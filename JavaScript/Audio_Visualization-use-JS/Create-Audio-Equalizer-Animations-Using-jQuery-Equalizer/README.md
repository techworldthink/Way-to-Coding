# jQuery Audio Equalizer Animation
jQuery Audio Equalizer Animation is simple jQuery based equalizer for ```<audio></audio>``` tags.

# Usage
All you have to do is to add an id attribute on ```<audio id="song1"></audio>```, add an empty div ```<div></div>``` anywhere on the HTML page. Now take the value of the audio's id attribute and add it as class with another class "equalizer" on that empty div as ```<div class="song1 equalizer"></div>```

## HTML
```html
<p>
    <div class="song1 equalizer"></div>
    <audio controls loop id="song1">
        <source src="music/file.mp3" type='audio/mp3'>
    </audio>
<p>

<p>
    <div class="song2 equalizer"></div>
    <audio controls loop id="song2">
        <source src="music/file.mp3" type='audio/mp3'>
    </audio>
</p>
```

## JavaScript
```javascript
<script>
$(document).ready(function(){
    $('#song1').equalizer({
        color: "#f2b400",
        color1: '#a94442',
        color2: '#f2b400'
    });
    $('#song2').equalizer();
});
</script>
```

## Simple Usage
```html
<p>
    <div class="song equalizer"></div>
    <audio controls loop id="song">
        <source src="music/file.mp3" type='audio/mp3'>
    </audio>
<p>
```
```javascript
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.reverseorder.js"></script>
<script type="text/javascript" src="js/jquery.equalizer.js"></script>
<script>
$(document).ready(function(){
    $('#song').equalizer();
});
</script>
```

# Options
```javascript
width: 400 // in pixels - default is 600 pixels
height: 150 // in pixels - default is 150 pixels
color: "#0f1957" // in hexadecimal - default is #800080
color1: "#a94442" // in hexadecimal - default is #B837F2
color2: "#f2b400" // in hexadecimal - default is #009AD9
bars: 15 // no. of bars - default is 20
barMargin: 0.5 // margin between vertical bars - default is 1
components: 10 // no. components in one bar - default is 8
componentMargin: 0.5 // margin between horizontal components - default is 1
frequency: 10 // rate of equalizer frequency - default is 9 (from 0 to 20)
refreshTime: 100 // refresh time of animation - default is 100
```

# Colors
Either provide "color" when you want to use single color or provide "color1" and "color2" when you want to use double colors.

Developed by Ali Nawaz - [Cooperative Computing](http://www.cooperativecomputing.com)
ali.nawaz@cooperativecomputing.com