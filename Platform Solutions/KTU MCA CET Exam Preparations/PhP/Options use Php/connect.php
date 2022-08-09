<?php
    $con = mysqli_connect("localhost","root","","library_management");
    #$d = "sssds";
    if(!$con){
       # echo "<script>alert(\"hai \"+\"$d\");</script>";
       echo "<script>alert(\"Connection Error!\");</script>";
    }
?>