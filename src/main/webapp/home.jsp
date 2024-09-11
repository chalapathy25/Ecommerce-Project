<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    main {
        padding: 80px 20px 20px; /* Adjust padding to account for fixed navbar */
    }

    .product-grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
        gap: 20px;
    }

    .product {
        background-color: #fff;
        padding: 20px;
        text-align: center;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .product img {
        width: 200px; /* Fixed width */
        height: 200px; /* Fixed height */
        object-fit: cover; /* Maintain aspect ratio and cover the area */
        border-radius: 4px;
    }

    .product h2 {
        font-size: 22px;
        margin: 10px 0;
    }

    .product p {
        font-size: 18px;
        color: #333;
    }

    .add-to-cart-btn{
        padding: 10px 15px;
        background-color: #ff6f61;
        color: #fff;
        border: none;
        cursor: pointer;
        margin-top: 10px;
        transition: background-color 0.3s, transform 0.3s;
        border-radius: 4px;
    }

    .product:hover {
        transform: scale(1.05);
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }

    .add-to-cart-btn:hover {
        background-color: #ff3b30;
        transform: scale(1.1);
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

    <!-- Main Content -->
    <main>
        <section class="product-grid">
            <% ProductDaoImpl pro = new ProductDaoImpl(); 
               List<Product> list = pro.getAllProducts();
               for (Product p : list) {
            	   //System.out.println(p.getpId());%>
            <div class="product">
                <img src="<%=request.getContextPath() %>/images/<%= p.getImagPath() %>" alt="<%= p.getpName() %>">
                <h2><%= p.getpName() %></h2>
                <p><%= p.getDecription() %></p>
                <p>$<%= p.getPrice() %></p>
                <form action="viewCart" method="get">
                    <input type="hidden" name="pId"  value="<%= p.getpId()%>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add to Cart" class="add-to-cart-btn"> 
                    </form>
            </div>
            <% } %>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 ShopEasy. All rights reserved.</p>
    </footer>

</body>
</html>
