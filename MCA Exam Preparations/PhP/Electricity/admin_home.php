<html>

<head>
    <title>Document</title>
    <style>
    html,
    body {
        padding: 0;
        margin: 0;
    }

    div {}

    .left-div {
        width: 20%;
        background-color: black;
        color: white;
        padding: 5px;
        float: left;
        height: 100vh;
    }

    .right-div {
        width: 70%;
        float: left;
        height: 100%;
    }

    iframe {
        border: 0;
        width: 100%;
        margin-top: 3em;
        height: 100%;

    }

    a {
        color: white;
        text-decoration: none;
        margin: .2em;
        text-transform: uppercase;
        font-family: monospace;
        font-size: 12px;
        padding-left: 2em;
    }
    </style>
</head>

<body>
    <div class="left-div">
        <br><br>
        <table>
            <tr>
                <td><a href="c_register.php" target="content">Consumer Registration</a> </td>
            </tr>
            <tr>
                <td><a href="b_add.php" target="content">Bill entry</a> </td>
            </tr>

        </table>
    </div>

    <div class="right-div">
        <iframe src="c_register.php" name="content"></iframe>
    </div>
</body>

</html>