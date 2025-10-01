<!DOCTYPE html>
<html>
<head>
</head>
<body>

    <form action=account/login method=POST>
    
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Name" name="name" id="name" required> </br></br>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required> </br></br>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required></br></br>
    
        <input type="submit" value="Register"/>

    </form>
</body>
</html>
