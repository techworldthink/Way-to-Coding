<?php
    session_start();
    if(isset($_SESSION['username'])){
        echo "hai".$_SESSION['username'];
    }
    else{
        echo "H NO";
    }
?>