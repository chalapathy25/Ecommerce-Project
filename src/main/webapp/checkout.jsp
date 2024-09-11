<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Dao.*,Modules.*,DaoImpl.*,java.util.ArrayList,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .checkout-container {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px; /* Adjusted to fit various screen sizes */
            box-sizing: border-box;
        }
        h1 {
            font-family: 'Roboto', sans-serif;
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 2em; /* Larger font size for emphasis */
            font-weight: bold;
        }
        p {
            margin: 15px 0;
            font-size: 18px;
            color: #555;
            text-align: center; /* Centered text for better presentation */
        }
        .address-container {
            margin-bottom: 30px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .address-container h2 {
            font-size: 20px;
            color: #333;
            margin-bottom: 10px;
            font-weight: bold;
        }
        .address-container p {
            margin: 5px 0;
            font-size: 16px;
            color: #666;
        }
        .edit-button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .edit-button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
        label {
            display: block;
            margin: 20px 0 10px;
            font-weight: bold;
            color: #333;
        }
        select {
            width: 100%;
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
            background-color: #f9f9f9; /* Slightly off-white background */
        }
        input[type="submit"] {
            width: 100%;
            padding: 15px;
            background-color: #28a745; /* Green color */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        input[type="submit"]:hover {
            background-color: #218838; /* Darker green on hover */
            transform: translateY(-2px); /* Subtle lift effect */
        }
        input[type="submit"]:active {
            background-color: #1e7e34; /* Even darker green when clicked */
            transform: translateY(0); /* Reset transform on click */
        }
    </style>
</head>
<body>
<%  float total = (float) session.getAttribute("sum");
  User u= (User)session.getAttribute("loginUser");
session.setAttribute("total", total); %>
    <div class="checkout-container">
        <h1>Checkout</h1>
        
        <div class="address-container">
            <h2>Shipping Address</h2>
            <p><%= u.getAddress()%></p>
            <a href="updateAddress.jsp" class="edit-button">Edit</a> <!-- Link to the address edit page -->
        </div>

        <form action="confirm">
            <p><strong>Total Amount:</strong> ₹<%= total %></p>
            <label for="payment-method">Payment Method:</label>
            <select id="payment-method" name="paymentMethod">
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="UPI">UPI</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
            </select>
            <input type="submit" value="Place Order">
        </form>
    </div>
</body>
</html>