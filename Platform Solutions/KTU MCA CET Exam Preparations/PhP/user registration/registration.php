<?php
    $conn = mysqli_connect("localhost","root","","registration");
?>

<html>
<head>
    <title>user registration</title>
    <style>
        div{
            box-shadow: teal;
            text-align: center;
            margin-top:3em;
            width:50%;
            margin-left:auto;
            margin-right:auto;
            
        }
        form{
            padding:1em;
            
        }
        marquee{
            background-color: blue;
            color: white;
            padding:2px;
            
        }
        table{
            text-align: center;
            width:100%;
            overflow-x: scroll;
            
        }
        tr,td,th{
            padding:10px;
        }
        input[type="text"],input[type="password"]{
            width:80%;
            padding:6px;
            border:1px solid gray;
            border-radius: 6px;
            outline:none;
        }
        input[type="submit"]{
            background-color: green;
            padding:5px;
            border-radius: 3px;
            border:none;
            color:white;
            width:100px;
        }
        input[type="reset"]{
            background-color: red;
            padding:5px;
            border-radius: 3px;
            border:none;
            color:white;
            width:100px;
        }
        .left{
            text-align: left;
        }
        .right{text-align: right;}
        h3{
            background-color: black;
            padding-top: 1em;
            padding-bottom: 1em;
            color:white;
            text-transform: uppercase;
            margin-bottom: 0;
        }
    </style>
</head>

<body>
    <div>
        <form name="register" action="" method="POST" onsubmit="return validate()">
            <h3>User Registration</h3>
            <marquee>Details provided in this registration must be correct</marquee>
            <br><br>
            <table>
                <tr> <td colspan=2><input type="text" name="fname" placeholder="Your Name" required></td></tr>
                <tr> <td colspan=2><input type="text" name="uname" placeholder="User Name" required></td></tr>
                <tr> <td colspan=2><input type="password" name="pass" id="pass" placeholder="Password" required></td></tr>
                <tr> <td colspan=2><input type="password" name="rpass" id="rpass" placeholder="Retype Password" required></td></tr>
                <tr> <td class="right"><input  type="submit" name="submit"></td><td class="left"><input type="reset" name="reset"></td></tr>
            </table>
        </form>
    </div>
    <?php
        if(isset($_POST['submit'])){
            $name = $_POST['fname'];
            $user = $_POST['uname'];
            $pass = $_POST['pass'];
            mysqli_query($conn,"INSERT INTO user VALUES('$user','$name','$pass')");
        }
    ?>
    <script>
        function validate(){
            if(document.getElementById("pass").value != document.getElementById("rpass").value){alert("retype same password!"); return false;}
        }
    </script>
</body>
</html