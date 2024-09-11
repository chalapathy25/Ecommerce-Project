package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import DaoImpl.OrderItemDaoImpl;
import Modules.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/historyDetail")
public class HistoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		int orderId=Integer.parseInt(request.getParameter("orderId"));
		ArrayList<OrderItem> orderList = (ArrayList<OrderItem>) new OrderItemDaoImpl().getAllOrderItem(orderId);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", orderList);
		response.sendRedirect("historyDetail.jsp");
   	
   	}

	

}
