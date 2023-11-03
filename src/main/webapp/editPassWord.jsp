<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <style>
        body {
            background-image: url("https://w0.peakpx.com/wallpaper/982/58/HD-wallpaper-microphone-ultra-music-dark-black-professional-studio-microphone-record-instrument-songs-voice.jpg");
        }
        .container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 180px auto;
        }

        .container h2 {
            text-align: center;
        }

        .container label {
            display: block;
            margin-bottom: 10px;
        }

        .container input[type="text"],
        .container input[type="password"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .container .message {
            margin-top: 10px;
            color: red;
            text-align: center;

        }
        h2 {
            font-family: Arial, sans-serif;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Change Password</h2>
    <form action="editPassWord?action=updatePassword" method="post">
        <input type="hidden" name="action" value="updatePassword">
        <label style="color: white" for="id">ID:</label>
        <input type="text" id="id" name="id"  required>
        <label style="color: white" for="password">Current Password:</label>
        <input type="password" id="password" name="password" required>
        <label style="color: white" for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
        <label style="color: white" for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        <input type="submit" value="Change Password">
        <p class="message">
            <%-- Display error message here --%>
            ${message}
        </p>
    </form>
</div>
</body>
</html>