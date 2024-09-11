<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Dao.*,Modules.*,DaoImpl.*,java.util.ArrayList,java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce Website</title>
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

    .container {
        padding: 80px 20px 20px; /* Adjust padding to account for fixed navbar */
    }

    .order-history {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
    }

    .order-card {
        background: white;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        width: 300px;
        margin: 10px;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 10px;
    }

    .order-image {
        width: 100%; /* Fixed width */
        height: 200px; /* Fixed height */
        object-fit: cover; /* Maintain aspect ratio and cover the area */
        border-radius: 4px;
    }

    .order-details {
        padding: 10px;
        text-align: center;
    }

    .order-details h2 {
        font-size: 18px;
        margin: 10px 0;
        color: #FF5722;
    }

    .order-details p {
        font-size: 16px;
        margin: 5px 0;
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

    h1 {
        padding-left: 600px;
        padding-bottom: 20px;
        color: red;
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
            <a href="home.jsp">Home</a>
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
        </div>
        <% } %>
    </div>

    <!-- Main Content -->
    <div class="container">
        <header>
            <h1>Ordered Items List</h1>
        </header>
        <main>
            <div class="order-history">
                <% List<OrderItem> orderList = (List<OrderItem>) session.getAttribute("orderList");
                if (orderList != null) {
                    for (OrderItem his : orderList) {
                %>
                <div class="order-card">
                    <img src="<%=request.getContextPath() %>/images/<%= his.getProduct().getImagPath() %>"  alt="Item Image" class="order-image">
                    <div class="order-details">
                        <h2>ItemId: <%= his.getProduct().getpId() %></h2>
                        <p><strong>Quantity:</strong> <%= his.getQuantity() %></p>
                        <p><strong>productName:</strong> <%= his.getProduct().getpName() %></p>
                        <p><strong>Amount:</strong> $<%= his.getSubTotal() %></p>
                    </div>
                </div>
                <% }} %>
            </div>
        </main>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 ShopEasy. All rights reserved.</p>
    </footer>

</body>
</html>
