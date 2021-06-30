<?php
    include "connect.php";
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
        table{
            text-align: center;
            width:100%;
            overflow-x: scroll;
            
        }
        tr,td,th{
            padding:10px;
        }
        input[type="text"],input[type="password"],input[type="number"]{
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
        <form name="register" action="" method="POST">
            <h3>User Registration</h3>
            <br><br>
            <table>
                <tr> <td colspan=2><input type="text" name="fname" placeholder="Your Name" required></td></tr>
                <tr> <td colspan=2><input type="number" name="age" placeholder="Your Age" required></td></tr>
                <tr> <td colspan=2><input type="text" name="gender" placeholder="Your Gender" required></td></tr>
                <tr> <td colspan=2><input type="text" name="q" placeholder="Your Qualification" required></td></tr>
                <tr> <td colspan=2><input type="text" name="uname" placeholder="User Name" required></td></tr>
                <tr> <td colspan=2><input type="password" name="pass" id="pass" placeholder="Password" required></td></tr>
                <tr> <td class="right"><input  type="submit" name="submit"></td><td class="left"><input type="reset" name="reset"></td></tr>
            </table>
        </form>
    </div>
    <?php
        if(isset($_POST['submit'])){
            $name = $_POST['fname'];
            $age = $_POST['age'];
            $gender = $_POST['gender'];
            $q = $_POST['q'];
            $user = $_POST['uname'];
            $pass = $_POST['pass'];
            $rows = mysqli_num_rows(mysqli_query($conn,"SELECT * FROM reg WHERE user='$user' and pass='$pass'"));
            if($rows<=0){
                mysqli_query($conn,"INSERT INTO reg VALUES('$name','$age','$gender','$q','$user','$pass')");
                echo "<script>alert(\"Successfully Registered\");</script>";
            }else{
                echo "<script>alert(\"Already Registered\");</script>";
            }
        }
    ?>
   
</body>
</html