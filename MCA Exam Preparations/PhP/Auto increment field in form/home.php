<?php
    require "connect.php";
?>
<html>
<head>
    <title>Document</title>
</head>
<body>
    <?php
    $query = "select * from book_details";
    $res = mysqli_query($con,$query);
      while($row = mysqli_fetch_row($res)){
        $id = $row[0];
      }
      $id++;
      ?>
       <form action="#" method="POST">
        <table>
        <tbody>
            <tr>
                <td>Book NO : <td>
                <td><input readonly type="text" name="uname" value="<?php echo $id;?>"></td>
            </tr>
            <tr>
                <td>Title : <td>
                <td><input type="password" name="passcode"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="login" value="ADD"></td>
            </tr>
        </tbody>
        </table>
    </form>
</body>
</html>
