<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Modules.*, java.util.List, DaoImpl.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="orderHistory.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
                    <a href="updateProfile.jsp">update Profile</a>
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

<div class="container">
    <header>
        <h1>Order History</h1>
    </header>
    <main>
        <div class="order-history">
            <% 
            List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderHistory");
            if (orderHistoryList != null) {
                for (OrderHistory his : orderHistoryList) {
                	  %>
                    <div class="order-card">
                    
                        <div class="order-details">
                            <h2>Order #<%= his.getOrderTable().getOrderId() %></h2>
                            <p><strong>Status:</strong> <%= his.getStatus() %></p>
                            <p><strong>Amount:</strong> ₹<%= his.getTotalAmount() %></p>
                            <p><strong>Date:</strong> <%= his.getOrderDate() %></p>
                            <a href="historyDetail?orderId=<%= his.getOrderTable().getOrderId() %>" class="view-button">View</a>
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

<style>
@charset "UTF-8";
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
/* Header styling */
header {
    text-align: center;
    margin-bottom: 30px;
}

header h1 {
    color: #007bff;
    font-size: 2.5em;
}

/* Body and container styling */
body {
    font-family: Arial, sans-serif;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    margin: 0;
}

/* Container styling */
.container {
    width: 90%; /* Adjusted for better centering and responsiveness */
    max-width: 1000px; /* Set a max-width for better control on large screens */
    margin: 80px auto; /* Center horizontally */
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden; /* Prevent any child elements from overflowing */
    box-sizing: border-box; /* Ensure padding is included in the element's width */
}

/* Order card styling */
.order-card {
    display: flex;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    width: 100%;
    position: relative;
    margin-bottom: 20px; /* Add space between each order card */
    padding: 15px; /* Add padding for better spacing inside the card */
    box-sizing: border-box; /* Ensure padding is included in the element's width */
}

/* Order image styling */
.order-image {
    width: 300px;
    height: 200px;
    object-fit: cover;
    margin-right: 20px; /* Add space between the image and the order details */
}

/* Order details styling */
.order-details {
    flex-grow: 1; /* Ensure it takes up the remaining space */
    padding: 10px; /* Add padding inside the order details */
    box-sizing: border-box; /* Ensure padding is included in the element's width */
}

/* View button styling */
.order-card .view-button {
    position: absolute;
    right: 20px;
    top: 50%; /* Move the button to the middle of the right corner */
    transform: translateY(-50%); /* Center the button vertically */
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease, box-shadow 0.3s ease;
}

/* Responsive design adjustments */
@media (max-width: 768px) {
    .order-card {
        flex-direction: column;
        max-width: 100%;
    }

    .order-image {
        width: 100%;
        height: auto;
        margin-right: 0; /* Remove margin in mobile view */
    }

    .order-details {
        margin-left: 0;
        margin-top: 15px;
    }

    .order-card .view-button {
        right: 50%;
        transform: translate(50%, -50%);
    }
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
</body>
</html>
