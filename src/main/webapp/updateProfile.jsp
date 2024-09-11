<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="Modules.*,java.util.List,DaoImpl.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin-bottom: 80px; /* To prevent content overlap with the footer */
        }

           /* Navbar styling */
    .navbar {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        display: flex;
        justify-content: flex-start; /* Align items to the left */
        align-items: center;
        background-color: #87CEEB; /* Skyblue color */
        padding: 10px 20px;
        z-index: 1000;
        box-sizing: border-box;
    }

    .navbar .logo {
        font-size: 24px;
        color: #fff;
        text-decoration: none;
        margin-right: auto; /* Pushes menu and search bar to the right */
    }

    .navbar .search-bar {
        display: flex;
        align-items: center;
        flex: 1;
        justify-content: center;
        margin-left: 20px; /* Adjust this if needed */
    }

    .navbar .search-bar input[type="text"] {
        padding: 5px;
        font-size: 16px;
        width: 50%;
        border-radius: 4px;
        border: 1px solid #ccc;
    }

    .navbar .search-bar button {
        padding: 6px 10px;
        margin-left: 10px;
        background-color: #ff6f61;
        color: #fff;
        border: none;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .navbar .search-bar button:hover {
        background-color: #ff3b30;
    }

    .navbar .menu {
        display: flex;
        align-items: center;
        gap: 15px;
        margin-left: auto; /* Align menu items to the right */
    }

    .navbar .menu a {
        color: #fff;
        text-decoration: none;
        font-size: 18px;
        position: relative;
        padding: 5px 10px;
        border-radius: 4px;
        transition: background-color 0.3s, color 0.3s;
    }

    .navbar .menu a:hover {
        background-color: #ff6f61;
        color: #fff;
    }

    .navbar .profile {
        position: relative;
    }

    .navbar .profile-options {
        display: none;
        position: absolute;
        top: 100%;
        right: 0;
        max-width: 200px; /* Limit dropdown width */
        background-color: #fff;
        color: #000;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        border-radius: 4px;
        overflow: auto; /* Add scroll if content overflows */
        z-index: 1001; /* Ensure it appears above other content */
        white-space: nowrap; /* Prevent text wrapping */
    }

    .navbar .profile-options a {
        display: block;
        padding: 10px;
        text-decoration: none;
        color: #000;
        font-size: 16px;
        white-space: nowrap; /* Prevent text wrapping */
    }

    .navbar .profile-options a:hover {
        background-color: #87CEEB;
        color: #fff;
    }

    .navbar .profile:hover .profile-options {
        display: block;
    }

        main {
            padding: 80px 20px 20px; /* Adjust padding to account for fixed navbar */
        }

        .div1 {
            background-color: white;
            padding: 40px 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 500px;
            margin: 50px auto;
        }

        .div1 h1 {
            text-align: center;
            color: #d35400; /* Dark Orange */
        }

        .div1 input[type="text"],
        .div1 input[type="email"] {
            width: 100%;
            padding: 12px 15px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        .div1 input[type="submit"] {
            width: 100%;
            padding: 15px;
            background-color: #28a745; /* Green color */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        .div1 input[type="submit"]:hover {
            background-color: #e64a19; /* Dark orange on hover */
        }

        footer {
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: #87CEEB; /* Skyblue color */
            color: #fff;
            text-align: center;
            padding: 10px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <div class="navbar">
        <a href="#" class="logo">ShopEasy</a>
        <div class="search-bar">
            <input type="text" placeholder="Search for products...">
            <button>Search</button>
        </div>
        <% User user=(User)session.getAttribute("loginUser");
            if(user!=null){ %>
        <div class="menu">
            <a href="home.jsp">Home</a>
            <a href="viewCart.jsp">View Cart</a>
            <a href="history">Order History</a>
            <div class="profile">
                <a href="#">Profile</a>
                <div class="profile-options">
                    <a href="viewProfile.jsp">View Profile</a>
                    <a href="updateProfile.jsp">Update Profile</a>
                    <a href="logout">Logout</a>
                </div>
            </div>
        </div>
        <% } else { %>
        <div class="menu">
            <a href="#">Home</a>
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
        </div>
        <% } %>
    </div>

    <!-- Main Content -->
    <div class="div1">
        <form action="profile">
            <h1>Update Profile</h1>
            <input type="text" value="<%=user.getUserId() %>" readonly><br><br>
            <input type="text" name="userName" placeholder="Username: <%=user.getUserName() %>"><br><br>
            <input type="email" name="email" placeholder="Email: <%=user.getEmail() %>"><br><br>
            <input type="text" name="phoneNumber" placeholder="Phone Number: <%=user.getPhoneNumber() %>"><br><br>
            <input type="text" name="address" placeholder="Address: <%=user.getAddress() %>"><br><br>
            <input type="submit" value="Update">
        </form>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 ShopEasy. All rights reserved.</p>
    </footer>
</body>
</html>
