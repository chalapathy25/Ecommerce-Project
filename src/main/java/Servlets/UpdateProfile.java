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
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/profile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");

		String email = request.getParameter("email");
		if (email != null && !email.trim().isEmpty()) {
			user.setEmail(email);
		}

		String userName = request.getParameter("userName");
		if (userName != null && !userName.trim().isEmpty()) {
			user.setUserName(userName);
		}

		String phoneNumber = request.getParameter("phoneNumber");
		if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
			user.setPhoneNumber(phoneNumber);
		}

		String address = request.getParameter("address");
		if (address != null && !address.trim().isEmpty()) {
			user.setAddress(address);
		}

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateUser(user);

		session.setAttribute("loginUser", user);
		System.out.println("after" + (User) session.getAttribute("loginUser"));
		response.sendRedirect("home");
	}
}
