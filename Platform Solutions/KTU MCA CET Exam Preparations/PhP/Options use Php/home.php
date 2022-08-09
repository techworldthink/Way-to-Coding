<?php
    require "connect.php";
?>
<html>
<head>
    <title>Document</title>
</head>
<body>

<select>
    <option>1</option>
    <option>2</option>
</select>

    <select>
    <?php
    $query = "select * from book_details";
      $res = mysqli_query($con,$query);
      while($row = mysqli_fetch_row($res)){
        echo '<option>';
        echo "$row[1]";
        echo '</option>';
      }
      ?>
      </select>
</body>
</html>