<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Song</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("https://bloghocpiano.com/wp-content/uploads/2021/03/573012.jpg");
            background-size: cover;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            color: #fff;
            text-align: center;
            margin-top: 0;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            width: 400px;
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="file"] {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Add Song</h1>
<form action="CreateSongServlet?action=addSong" method="post" enctype="multipart/form-data">
    <label for="songName">Song Name:</label>
    <input type="text" id="songName" name="songName" required><br><br>
    <label for="singer">Singer:</label>
    <input type="text" id="singer" name="singer" required><br><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>
    <label for="mp3File">MP3 File:</label>
    <input type="file" id="mp3File" name="mp3File" required><br><br>
    <label for="imageFile">Image File:</label>
    <input type="file" id="imageFile" name="imageFile"><br><br>
    <input type="submit" value="Add Song">
</form>
<script>

</script>
</body>
</html>