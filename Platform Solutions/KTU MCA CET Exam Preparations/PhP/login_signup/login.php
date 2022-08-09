<?php 
    $conn = mysqli_connect("localhost","root","","registration");
?>
<html>
<head>
    <title>Login</title>
    <style>
    div{text-align: center;margin-top: 3em;margin-left:auto;margin-right:auto;width:50%;}
    table{margin-left:auto;margin-right:auto;}
    td{text-align: center;padding:5px;}
    input[type="text"],input[type="password"]{border:1px solid gray;border-radius: 3px;padding:5px;}
    a{text-decoration: none;}
    </style>
</head>
<body>
    <div>
        <form action="" method="POST">
            <h3>Login</h3>
            <table>
                <tr><td><input type="text" name="uname" placeholder="User name"></td></tr>
                <tr><td><input type="password" name="pass" placeholder="password"></td></tr>
                <tr><td><input type="submit" name="submit" value="Login"></td></tr>
            </table>
            <a href="sign_up.php">Not a member? Sign Up</a>
        </form>
    </div>
    <?php 
    if(isset($_POST['submit'])){
        $user = $_POST['uname'];
        $pass = $_POST['pass'];
        $rows = mysqli_num_rows(mysqli_query($conn,"SELECT * FROM user WHERE user='$user' and pass='$pass'"));
        if($rows>0){header("location:home.php");}
        else{echo "<script>alert(\"invalid Login!\");</script>";}
    }
    ?>
</body>
</html>