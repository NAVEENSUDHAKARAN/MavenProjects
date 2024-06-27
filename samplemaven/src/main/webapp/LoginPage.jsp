<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
        }
        .container {
            position: absolute;
            left: 19%;
            top: 5%;
            width: 300px;
            margin: 100px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px 5px #3c445c;
        }
        .container h2 {
            text-align: center;
        }
        .container input[type="text"],
        .container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #3c445c;
            color: #fff;
            cursor: pointer;
        }
        .container input[type="submit"]:hover {
            background-color: black;
        }
        
        #logo {
            position: relative;
            left: 41%;
            top: 10%;
        }
        
        #bgDiv {
            width: 30%;
            height: 50vh;
            position: relative;
            left: 60%;
            top: 120px;
        }
        
       #createAccountTag {
            position: relative;
            left: 30%;
            text-decoration: none;
            color: #3c445c;
       }
       
       #createAccountTag:hover {
            color: black;
            cursor: pointer;
       }
       
       /* Custom error message style */
       .alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
            padding: 5px 10px;
            margin-top: 5px;
            border-radius: 3px;
       }
    </style>
</head>
<body>
    <div class="container">
        <img id="logo" alt="logo not working" src="images/DigiPayLogo.png" width="40px" height="40px" >
        <h2>Login</h2>
        <form id="loginForm" action="CheckLogin" method="post">
            <input type="text" id="email" name="email" placeholder="Email" required><br>
            <input type="password" name="loginPassword" placeholder="Password" required><br>
            <input type="submit" value="Login">
        </form>
        <br>
        <a id="createAccountTag" href="Register.jsp" >Create Account</a>

    </div>
    
    <div id="bgDiv">
        <img src="images/loginpagebg.png" alt="bg not working" width="100%" height="100%" > 
    </div>
</body>
</html>
