<?php
    include "connect.php";
?>

<html>
<head>
    <title>Billing</title>
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
        select,input[type="text"],input[type="password"],input[type="number"]{
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
            <h3>Billing</h3>
            <br><br>
            <table>
            <tr>
            <label>Consumer no*</label>
            <td colspan=2><select name="cno">
            <?php
                $query = "select * from consumer";
                $res = mysqli_query($con,$query);
                while($row = mysqli_fetch_row($res)){
                    echo '<option>';
                    echo "$row[0]";
                    echo '</option>';
                }
      ?>
             </select></td></tr>
                <tr> <td colspan=2><input type="number" name="month" min=1 max=12 placeholder="Month" required></td></tr>
                <tr> <td colspan=2><input type="number" name="cost" placeholder="Amount" required></td></tr>
                <tr> <td class="right"><input  type="submit" name="submit"></td><td class="left"><input type="reset" name="reset"></td></tr>
            </table>
        </form>
    </div>
    <?php
        if(isset($_POST['submit'])){
            $cno = $_POST['cno'];
            $month = $_POST['month'];
            $amount = $_POST['cost'];
            
            $rows = mysqli_num_rows(mysqli_query($con,"SELECT * FROM bill WHERE cno='$cno' and month_='$month'"));
            if($rows<=0){
                mysqli_query($con,"INSERT INTO bill(cno,month_,amount) VALUES('$cno','$month','$amount')");
                echo "<script>alert(\"Successfully added\");</script>";
            }else{
                echo "<script>alert(\"Already Added\");</script>";
            }
        }
    ?>
   
</body>
</html