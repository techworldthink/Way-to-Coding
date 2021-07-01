<?php
    include "connect.php";
?>

<html>
<head>
    <title>admin home</title>
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
        textarea,input[type="text"],input[type="password"],input[type="number"]{
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
            <h3>Consumer Registration</h3>
            <br><br>
            <table>
                <tr> <td colspan=2><input type="text" name="cno" placeholder="Consumer Number" required></td></tr>
                <tr> <td colspan=2><input type="text" name="cname" placeholder="Consumer Name" required></td></tr>
                <tr> <td colspan=2><textarea  name="addr" placeholder="Consumer Address" required></textarea></td></tr>
                <tr> <td colspan=2><input type="number" name="no" placeholder="Mob NO" required></td></tr>
                
                <tr> <td class="right"><input  type="submit" name="submit"></td><td class="left"><input type="reset" name="reset"></td></tr>
            </table>
        </form>
    </div>
    <?php
        if(isset($_POST['submit'])){
            $cno = $_POST['cno'];
            $cname = $_POST['cname'];
            $addr = $_POST['addr'];
            $no = $_POST['no'];
            
           
            $rows = mysqli_num_rows(mysqli_query($con,"SELECT * FROM consumer WHERE cno='$cno'"));
            if($rows<=0){
                mysqli_query($con,"INSERT INTO consumer VALUES('$cno','$cname','$addr','$no')");
                echo "<script>alert(\"Successfully Registered\");</script>";
            }else{
                echo "<script>alert(\"Already Registered\");</script>";
            }
        }
    ?>
   
</body>
</html