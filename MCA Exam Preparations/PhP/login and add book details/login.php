<html>
<head>
<style>
table{
    margin-left:auto;
    margin-right:auto;
    margin-top:3em;
}
tr,td,th{
    padding:6px;
}
input[type="text"],input[type="password"]{
padding:6px;
border-radius:3px;
border:1px solid gray;
}
input[type="submit"]{
    background-color:green;
    color:white;
    border:none;
    width:100px;
    padding:7px;
}
</style>
</head>
<body>
    <form action="#" method="POST">
        <table>
        <tbody>
            <tr>
                <td><input type="text" name="uname" placeholder="Username"></td>
            </tr>
            <tr>
                <td><input type="password" name="passcode" placeholder="Password"></td>
            </tr>
            <tr>
                <td style="text-align:center;"><input type="submit" name="login" value="login"></td>
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
        $pass = $_POST['passcode'];
        $login_result = mysqli_query($conn,"select * from login where user='$user'and pass='$pass'");
        $login_vlaues = mysqli_fetch_array($login_result);
        $login_rows = mysqli_num_rows($login_result);
        if($login_rows == 1){
            header("location:home.php");
        }
        else{
            echo "there is no user";
        }
    }
     
?>