<?php
    $con = mysqli_connect("localhost","root","","jobin");
    #$d = "sssds";
    if(!$con){
       # echo "<script>alert(\"hai \"+\"$d\");</script>";
       echo "<script>alert(\"Connection Error!\");</script>";
    }
?>