<?php include "connect.php"; ?>
<html>
<style>
.first {
    width: 30%;
}

table {
    width: 100%;
}

input[type="number"],
select {
    width: 80%;
    padding: 7px;
}

input[type="submit"] {
    background-color: green;
    padding: 6px;
    width: 100px;
    color: white;
    border: none;
    outline: none;
}
td,th{
    text-align:center;
}
th{
    background-color:#1c350cfc;
    padding:3px;
    color:white;
}
td{
    background-color:#00d6ae;
    padding:3px;
}
</style>

<body>
    <div class="main">
        <form method="POST" action="">
            <table>
                <tr>
                    <th class="first">Reg NO</th>
                    <th>mark</th>
                </tr>

                <?php
                    $r = mysqli_query($conn,"SELECT * FROM mark");
                    while($res = mysqli_fetch_array($r)){
                        echo "<tr>";
                        echo "<td>".$res[0]."</td>";
                        echo "<td>".$res[1]."</td>";
                        echo "<tr>";
                     }
                ?>

            </table>
        </form>
    </div>
</body>

</html>