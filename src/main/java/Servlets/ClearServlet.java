package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DaoImpl.Cart;

/**
 * Servlet implementation class ClearServlet
 */
@WebServlet("/clear")
public class ClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		 HttpSession session = request.getSession();    	    	
    		 Cart cart=(Cart)session.getAttribute("cart");
    		 session.setAttribute("cart", null);
    		 response.sendRedirect("viewCart.jsp");

    	
    	}

	
}
