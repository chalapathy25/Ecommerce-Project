package Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DaoImpl.UserDaoImpl;
import Modules.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Login() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.getUser(email);
        System.out.println(user);

        if (user != null && password.equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            System.out.println("Login successful, redirecting to home.");
            response.sendRedirect("home");
        } else {
            System.out.println("Login failed, redirecting to reLogin.jsp.");
            response.sendRedirect("reLogin.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests similarly if needed
        doGet(request, response);
    }
}
