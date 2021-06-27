<html>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AUTHOR</th>
        <th>EDITION</th>
        <th>PUBLISHER</th>
    </tr>
    <?php
      require "connect.php";
      $query = "select * from book_details";
      $res = mysqli_query($con,$query);
      while($row = mysqli_fetch_row($res)){
        echo '<tr>';
        echo "<td>$row[0]</td>";
        echo "<td>$row[1]</td>";
        echo "<td>$row[2]</td>";
        echo "<td>$row[3]</td>";
        echo "<td>$row[4]</td>";
        echo '</tr>';
      }
    ?>
</table>
</body>
</html>