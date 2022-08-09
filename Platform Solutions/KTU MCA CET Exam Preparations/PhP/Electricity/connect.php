<?php
    $con = mysqli_connect("localhost","root","","electricity");
    if(!$con){
       echo "<script>alert(\"Connection Error!\");</script>";
    }
?>