<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>Registration Page</title>
  <style>
    @charset "UTF-8";
    body {
      background:#87CEEB; /* Gradient background */
      font-family: Arial, sans-serif;
      height: 100vh;
      margin: 0;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .div1 {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
      width: 100%;
    }

    form {
      background: rgba(255, 255, 255, 0.1); /* Transparent background */
      border: solid #fff 1px;
      border-radius: 15px;
      width: 500px; /* Increased width */
      padding: 20px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      backdrop-filter: blur(10px); /* Glassmorphism effect */
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      height: 600px; /* Adjusted height to accommodate all input fields */
    }

    input[type="text"], input[type="password"], input[type="email"], input[type="submit"] {
      height: 45px;
      width: 100%;
      margin-bottom: 20px;
      border-radius: 8px;
      border: 1px solid #fff;
      background: rgba(255, 255, 255, 0.3); /* Slightly transparent input background */
      font-size: 18px;
      color: #fff;
      padding-left: 10px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      border: none;
      background-color:  #4CAF50;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #FF5722; /* Change color to green on hover */
    }

    form h1 {
      color: white;
      text-align: center;
      margin-bottom: 20px;
    }

    .anim {
      color: #FFCCBC;
      font-size: 16px;
      margin-bottom: 20px;
      display: flex;
      align-items: center;
    }

    .checkbox {
      margin-right: 10px;
      transform: scale(1.3); /* Increased checkbox size */
    }

    form a {
      color:  #4CAF50;
      text-decoration: none;
      font-size: 16px;
    }

    form a:hover {
      text-decoration: underline;
    }

    form p {
      text-align: center;
      margin-top: auto;
      color: white;
    }
  </style>
</head>
<body>
  <div class="div1">
    <form action="register">
      <h1>Registration</h1>
      <input type="text" name="userName" required="required" placeholder="UserName">
      <input type="password" name="password" required="required" placeholder="Password">
      <input type="password" name="cpassword" required="required" placeholder="Confirm Password">
      <input type="email" name="email" required="required" placeholder="Email">
      <input type="text" name="phoneNumber" required="required" placeholder="PhoneNumber">
      <input type="text" name="address" required="required" placeholder="Address">
      <label class="anim">
        <input type="checkbox" class="checkbox" required="required">
        <span>I Agree To The <a href="">Terms & Conditions</a></span>
      </label>
      <input type="submit" value="SignUp">
      <p>Already Have an Account? <a href="login.jsp">Login</a></p>
    </form>
  </div>
</body>
</html>

