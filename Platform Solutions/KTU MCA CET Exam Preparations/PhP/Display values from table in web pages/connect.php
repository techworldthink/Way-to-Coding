<?php
    $con = mysqli_connect("localhost","root","","library_management");
    if(!$con){
       echo "<script>alert(\"Connection Error!\");</script>";
    }
?>