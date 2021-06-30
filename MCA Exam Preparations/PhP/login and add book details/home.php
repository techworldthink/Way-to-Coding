
<?php
    include "connect.php";
 
?>
<html>
<head>
    <title>Book Add</title>
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
        input[type="text"],input[type="password"],input[type="number"],select{
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
            <h3>Book Add</h3>
            <br><br>
            <table>
                <tr> <td colspan=2><input type="number" name="bid" placeholder="Book ID" required></td></tr>
                <tr> <td colspan=2><input type="text" name="bname" placeholder="Book Name" required></td></tr>
                <tr> <td colspan=2><input type="text" name="bauthor" placeholder="Book Author" required></td></tr>
                <tr> <td colspan=2><select name="c"><?php for($i=0;$i<=100;$i++){echo "<option>".$i."</option>";} ?></select></td></tr>
                <tr> <td class="right"><input  type="submit" name="submit"></td><td class="left"><input type="reset" name="reset"></td></tr>
            </table>
        </form>
    </div>
    <?php
        if(isset($_POST['submit'])){
            $id = $_POST['bid'];
            $bname = $_POST['bname'];
            $bauthor = $_POST['bauthor']; 
            $copy = $_POST['c'];

                mysqli_query($conn,"INSERT INTO book VALUES('$id','$bname','$bauthor','$copy')");
                echo "<script>alert(\"Successfully added\");</script>";
          
        }
    ?>
   
</body>
</html