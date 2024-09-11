package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import DaoImpl.Cart;
import DaoImpl.OrderHistoryDaoImpl;
import DaoImpl.OrderItemDaoImpl;
import DaoImpl.OrderTableDaoImpl;
import DaoImpl.ProductDaoImpl;
import Modules.CartItem;
import Modules.OrderHistory;
import Modules.OrderItem;
import Modules.OrderTable;
import Modules.Product;
import Modules.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/confirm")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	Set<OrderItem>arr=new HashSet<OrderItem>();
   	
   	 LocalDate currentDate = LocalDate.now();
     Date sqlDate = Date.valueOf(currentDate);
     HttpSession session = request.getSession();
     Cart cart=(Cart) session.getAttribute("cart");
	 Map<Integer,CartItem>map= cart.getItems();
	 Set<Map.Entry<Integer,CartItem>>set=map.entrySet();
   		
		String paymentMode = request.getParameter("paymentMethod");
		User user=(User)session.getAttribute("loginUser");
		
		int userId=user.getUserId();
        float totalAmount=(float) session.getAttribute("sum");
        int status=0;
        //insert data into ordertable
        OrderTableDaoImpl orderTableDaoImpl = new OrderTableDaoImpl();
		//String OrderTableQuery="insert into ordertable(userId,restaurantId,paymentMode,totalAmount,orderDate)values(?,?,?,?,?)";
	OrderTable	orderTable=new OrderTable(sqlDate+"", totalAmount, "pending", paymentMode, user);
	orderTableDaoImpl.addOrderTable(orderTable);
		int orderId=0;
		//to retrieve the order id from the ordertable to insert data into orderItem  table
		/*try {
			String query = "SELECT MAX(orderId) FROM ordertable";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			 rs.next();
			 orderId = rs.getInt(1);

		}catch(Exception e) {
			e.printStackTrace();
		}
		 orderId=new OrderTableDaoImpl().getMaxOrder();
		 OrderTable orderTable2 = new OrderTableDaoImpl().getOrderTable(orderId);*/
		 
		//get cartItem to get some data to insert into orderItem table
		
		  
		  for(Map.Entry<Integer,CartItem>cartMap:set){ 
			 // int itemId=cartMap.getKey();
			    Product product = new ProductDaoImpl().getProduct(cartMap.getValue().getItemId());
			  int quantity=cartMap.getValue().getQuantity();
			  float subTotal=cartMap.getValue().getSubTotal();
			  String menuName=cartMap.getValue().getpName();
			 OrderItem orderItem = new OrderItem(quantity, subTotal,product, orderTable);
			 arr.add(orderItem);
			new OrderItemDaoImpl().addOrderItem(orderItem);
			 			  
		
		   }
		 
		  orderTable.setOrderItems(arr);
		  orderTableDaoImpl.updateUser(orderTable);
		  //insert data into OrderHistory table
		  OrderHistory orderHistory = new OrderHistory(totalAmount, "success", sqlDate+"", orderTable, user);
		  new OrderHistoryDaoImpl().addOrderHistory(orderHistory);
		  
		  status=1;
		 /* String orderHistoryQuery="insert into orderhistory(orderId, userId, totalAmount,orderDate) values(?,?,?,?)";
		 		  try {
			PreparedStatement statement2 = con.prepareStatement(orderHistoryQuery);
			statement2.setInt(1, orderId);
			statement2.setInt(2, userId);
			statement2.setFloat(3, totalAmount);
			statement2.setDate(4, sqlDate);
			 status=statement2.executeUpdate();
			System.out.println("All Set Success");
			con.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	if(status!=0) {
		session.setAttribute("cart",null );
		response.sendRedirect("orderSuccess.jsp");
		
	}
	else {
		response.sendRedirect("orderFailed.jsp");
	}
	
	}

	
}
