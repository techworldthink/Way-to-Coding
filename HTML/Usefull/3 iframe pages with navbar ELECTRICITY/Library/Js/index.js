setCount = 1
function toggleMenu() {
    let toggle = document.querySelector('.toggle');
    let navigation = document.querySelector('.navigation');
    let main = document.querySelector('.main');
    toggle.classList.toggle('active');
    navigation.classList.toggle('active')
    main.classList.toggle('active')
}

function closeNav(){
    if(window.innerWidth <= 726 & setCount!=1){        
        toggleMenu();
    }
    setCount = 0;
}

document.getElementById("navigation").addEventListener("click", closeNav);