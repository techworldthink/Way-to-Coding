$(document).ready(function () {
    var imageFile = ["b.png","c.png","a.png"];
    var currentIndex = 0;

    setInterval(function () {
        if (currentIndex == imageFile.length) {
            currentIndex = 0;
        }
        $(".trans-image").css('background-image', 'url("assets/img/background/' + imageFile[currentIndex++] + '")')
            .css('background-position','top right')
            .css('background-size','cover');
       }, 6000);

});
