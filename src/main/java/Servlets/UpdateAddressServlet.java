package Servlets;

import java.io.IOException;

import DaoImpl.UserDaoImpl;
import Modules.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateAddressServlet
 */
@WebServlet("/update")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String address = request.getParameter("address");
		  HttpSession session = request.getSession();
		  User user=(User)session.getAttribute("loginUser");
		  user.setAddress(address);
		  UserDaoImpl userDaoImpl = new UserDaoImpl();
		  
		  userDaoImpl.updateUser(user);
		  session.setAttribute("loginUser", user);
		  response.sendRedirect("checkout.jsp");
		  
    	
    	
    	
    	}

	

}
