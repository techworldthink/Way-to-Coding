<?php
    require "connect.php";
?>
<html>
<head>
    <title>Document</title>
</head>
<body>
    <select id="opt" onChange =tochange()>
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
    <p id="para"></p>
     
      <script>

      function tochange(){
            var get_option = document.getElementById("opt").value;
            var to_upper = get_option.toUpperCase();
            document.getElementById("para").innerHTML = to_upper;
            //object.addEventListener("change", myScript);
        }
      </script>
</body>
</html>
