package Servlets;

import java.io.IOException;
import java.util.List;

import DaoImpl.OrderHistoryDaoImpl;
import Modules.OrderHistory;
import Modules.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
    	 User user = (User) session.getAttribute("loginUser");
		List<OrderHistory> allOrderHistory = new OrderHistoryDaoImpl().getAllOrderHistory(user.getUserId());
		session.setAttribute("orderHistory", allOrderHistory);
	   response.sendRedirect("history.jsp");
    		
	}

	

}
