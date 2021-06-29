<html>
<head>
    <title>Document</title>
    <style>
        html,body{
            padding: 0;
            margin: 0;
        }
        div{
            
        }
        .left-div{
            width:20%;
            background-color: black;
            color: white;
            padding:5px;
            float:left;
            height: 100vh;
        }
        .right-div{
            width:70%;
            float:left;
            height: 100vh;
        }
        iframe{
            border: 0;
            width:100%;
            margin-top:3em;
        }
        a{
            color: white;
            text-decoration: none;
            margin:1em;
            text-transform: uppercase;
            font-family: monospace;
            font-size: 17px;
            padding-left:2em;
        }
    </style>
</head>
<body>
    <div class="left-div">
        <br><br>
        <table>
            <tr><td><a href="mark_entry.php" target="content">mark entry</a> </td></tr>
            <tr><td><a href="mark_view.php" target="content">mark view</a>  </td></tr>
            
        </table>
    </div>

    <div class="right-div">
        <iframe src="mark_entry.php" name="content"></iframe>
    </div>
</body>
</html>