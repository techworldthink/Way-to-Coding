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
</style>

<body>
    <div class="main">
        <form method="POST" action="">
            <table>
                <tr>
                    <td class="first">Reg NO</td>
                    <td>
                        <select name="no">
                            <?php
                            $r = mysqli_query($conn,"SELECT * FROM student");
                            while($res = mysqli_fetch_array($r)){
                                echo "<option>".$res[0]."</option>";
                            }
                            ?>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="first">Mark</td>
                    <td><input type='number' name="mark"></td>
                </tr>
                <tr>
                    <td colspan=2 style="text-align:center;"><input type="submit" name="submit"></td>
                </tr>
            </table>
        </form>
    </div>
    <?php
    if(isset($_POST['submit'])){
        $no = $_POST['no'];
        $mark = $_POST['mark'];
        if(mysqli_query($conn,"INSERT INTO mark VALUES('$no','$mark')")){echo "<script>alert(\"Success\");</script>";}
        else{echo "<script>alert(\"Failed\");</script>";}
    }
    ?>
</body>

</html>