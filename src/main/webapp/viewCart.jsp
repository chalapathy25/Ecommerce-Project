<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Dao.*,Modules.*,DaoImpl.*,java.util.*,java.util.List" %>
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
            margin-bottom: 100px; /* Prevents content overlap with the footer */
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
            padding: 100px 20px 20px; /* Adjust padding to account for fixed navbar */
        }

        .cart-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        .cart-container h1 {
            font-size: 28px;
            margin-bottom: 20px;
        }

        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .cart-table th, .cart-table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        .cart-table th {
            background-color: #87CEEB; /* Skyblue color */
            color: #fff;
        }

        .cart-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .cart-table img {
            width: 80px;
            height: auto;
            border-radius: 4px;
        }

        .cart-table .total-price {
            font-weight: bold;
            font-size: 20px;
            text-align: right;
        }

        .cart-table button, .checkout-btn {
            padding: 10px 15px;
            background-color: #ff6f61;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s, transform 0.3s;
        }

        .cart-table button:hover, .checkout-btn:hover {
            background-color: #ff3b30;
            transform: scale(1.05);
        }

        .checkout-btn, .add-more, .edit-btn {
            display: inline-block;
            text-decoration: none;
            text-align: center;
            padding: 10px 20px;
            background-color: #ff6f61;
            color: #fff;
            border-radius: 4px;
            font-size: 18px;
            transition: background-color 0.3s, transform 0.3s;
            margin-right: 10px; /* Space between buttons */
        }

        .cart-summary, .cart-summary1 {
            margin-top: 20px;
            font-size: 18px;
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

        /* Aligning the first paragraph to the center */
        .p {
            text-align: center;
            margin-bottom: 20px;
            font-size: 20px;
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
            <a href="viewCarrt.jsp">View Cart</a>
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

    <main>
        <p class="p">Review and manage your cart items.</p>
        
        <% Cart cart = (Cart) session.getAttribute("cart"); 
        float total;
        if (cart != null && user != null) { %>
        <section class="cart-container">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    Map<Integer,CartItem> map = cart.getItems();
                    Set<Map.Entry<Integer,CartItem>> set = map.entrySet();
                    float sum = 0;
                    if (set != null) {
                        for (Map.Entry<Integer,CartItem> cartMap : set) { %>
                    <tr>
                        <td><%= cartMap.getValue().getpName() %></td>
                        <td class="quantity-cell">
                            <form action="viewCart" method="get">
                                <input type="hidden" name="itemId" value="<%= cartMap.getValue().getItemId() %>">
                                <input type="hidden" name="action" value="update">
                                <input type="number" min="1" name="quantity" value="<%= cartMap.getValue().getQuantity() %>">
                                <input type="submit" value="Update" class="edit-btn">
                            </form>
                        </td>
                        <td><%= cartMap.getValue().getPrice() %></td>
                        <td><%= cartMap.getValue().getPrice() * cartMap.getValue().getQuantity() %></td>
                        <td>
                            <form action="viewCart" method="get">
                                <input type="hidden" name="itemId" value="<%= cartMap.getValue().getItemId() %>">
                                <input type="hidden" name="action" value="delete">
                                <input type="submit" value="Remove" class="edit-btn">
                            </form>
                        </td>
                    </tr>
                    <% 
                    sum += cartMap.getValue().getPrice() * cartMap.getValue().getQuantity(); 
                        }
                    } 
                    session.setAttribute("sum",sum);
                    %>
                    <tr>
                        <td colspan="3" class="total-price">Grand Total</td>
                        <td colspan="2" class="total-price"><%=sum%></td>
                    </tr>
                </tbody>
            </table>
            <div class="cart-summary">
                <a href="checkout.jsp" class="checkout-btn">Proceed to Pay</a>
                <a href="home.jsp" class="add-more">Add More</a>
                <a href="clear" class="edit-btn">Clear Cart</a>
            </div>
        </section>
        <% } else { %>
        <section class="cart-summary1">
            <h3>Your Cart is empty! Please select items to purchase</h3>
             <div class="cart-summary">
                <a href="home.jsp" class="add-more">Add Items</a>
            </div>
            
        </section>
        <% } %>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 E-Commerce Website. All rights reserved.</p>
    </footer>
</body>
</html>
