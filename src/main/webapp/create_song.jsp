<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Song</title>
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
    <input type="file" id="imageFile" name="imageFile" ><br>
    <input type="submit" value="Add Song">
</form>
<script>

</script>
</body>
</html>