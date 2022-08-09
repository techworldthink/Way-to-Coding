<?php 
    include "connect.php";
?>
<html>
<head>
    <title>Home</title>
    <style>
    div{float:left; text-align: center;margin-top: 3em;margin-left:auto;margin-right:auto;width:45%;border:1px solid black;margin-left:1%;}
    table{margin-left:auto;margin-right:auto;}
    td{text-align: center;padding:5px;}
    input[type="number"],input[type="text"],input[type="password"]{border:1px solid gray;border-radius: 3px;padding:5px;width:90%;}
    a{text-decoration: none;}
    .search-btn{background-color:green;padding:6px;width:100px;border:none;color:white;}
    .s-btn{background-color:red;padding:6px;width:100px;border:none;color:white;}
    .result{margin-top:17em;border:1px solid gray;position:absolute;width:100%;border-collapse:collapse;}
    .result td,.result th{padding:1em;background-color:#d6d6d6;}
    </style>
</head>
<body>
<div>
        <form action="" method="POST">
            <h3>Search Bill</h3>
            <table>
                <tr><td><input type="text" name="cno" placeholder="Consumer Number"></td></tr>
                <tr><td><input type="number" name="month" placeholder="Month" min=1 max=12></td></tr>
                <tr><td><input class="search-btn" type="submit" name="search" value="Search"></td></tr>
            </table>
        </form>
    </div>
    <div>
        <form action="" method="POST">
            <h3>Admin Login</h3>
            <table>
                <tr><td><input type="text" name="uname" placeholder="User name"></td></tr>
                <tr><td><input type="password" name="pass" placeholder="password"></td></tr>
                <tr><td><input class="s-btn" type="submit" name="submit" value="Login"></td></tr>
            </table>
        </form>
    </div>
    <br><bR>
    <?php 
    if(isset($_POST['submit'])){
        $user = $_POST['uname'];
        $pass = $_POST['pass'];
        $rows = mysqli_num_rows(mysqli_query($con,"SELECT * FROM login_ WHERE user='$user' and pass='$pass'"));
        if($rows>0){header("location:admin_home.php");}
        else{echo "<script>alert(\"invalid Login!\");</script>";}
    }
    if(isset($_POST['search'])){
        $cno = $_POST['cno'];
        $m = $_POST['month'];

        if($res = mysqli_fetch_array(mysqli_query($con,"SELECT * FROM bill WHERE cno='$cno' and month_='$m'"))){
        ?>
        <table class="result">
        <tr> 
        <th> CNO </th>
        <td><?php echo $res[1]; ?> </td>
        </tr>
        <tr> 
        <th> Month </th>
        <td><?php echo $res[2]; ?>  </td>
        </tr>
        <tr> 
        <th> Amount </th>
        <td><?php echo $res[3]; ?>  </td>
        </tr>
        </table>
        <?php
            
        }
        
        
    }
    ?>
</body>
</html>