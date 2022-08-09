<?php
    session_start();
?>
<html>
<head>
</head>
<body>
    <form action="#" method="POST">
        <table>
        <tbody>
            <tr>
                <td>User : <td>
                <td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>Password : <td>
                <td><input type="password" name="passcode"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="login" value="login"></td>
            </tr>
        </tbody>
        </table>
    </form>
</body>
</html>

<?php
    require "connect.php";
    if(isset($_POST['login'])){
        $user = $_POST['uname'];
        $passcode = $_POST['passcode'];
        $login_query = "select * from user_login where user='$user'and pass='$passcode'";
        $login_result = mysqli_query($con,$login_query);
        $login_vlaues = mysqli_fetch_array($login_result);
        if(!$login_result){
            echo "login error";
        }
        $login_rows = mysqli_num_rows($login_result);
        if($login_rows == 1){
            $_SESSION['username'] = $login_vlaues[0];
            header("location:home.php");
        }
        else{
            echo "there is no user";
        }
    }
     
?>