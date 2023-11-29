<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url("https://img.freepik.com/free-vector/realistic-vector-background-music-notes-wave-background_134830-1438.jpg?size=626&ext=jpg&ga=GA1.1.1413502914.1697328000&semt=ais");
            background-size: cover;
        }

        .container {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        h2 {
            text-align: center;
            margin-top: 0;
            color: white;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add User</h2>
    <form action="addUser" method="post">
        <input type="hidden" value="${user.getEmail()}" name="emailOld" />
        <input type="hidden" value="${user.getPassWord()}" name="passwordOld" />
        <label for="name" style="color: white">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email" style="color: white">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="phoneNumber" style="color: white">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br>
        <label for="password" style="color: white">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Add User">
    </form>
</div>
</body>
</html>