package Servlets;

import java.io.IOException;

import DaoImpl.Cart;
import DaoImpl.ProductDaoImpl;
import Modules.CartItem;
import Modules.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/viewCart")
public class ViewCart extends HttpServlet {
    // Changed to doGet to handle GET requests from anchor tags
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
    	
    	String action=request.getParameter("action");
    	Cart cart=(Cart)session.getAttribute("cart");
    	if(cart==null) {
    		cart=new Cart();
    		 session.setAttribute("cart",cart );
    	}
    	if(action.equals("add")) {
    		addCart(request,cart);
    		
    	}else if(action.equals("update")) {
    		updateCart(request,cart);
    	
    	}else if(action.equals("delete")) {
    		deleteCart(request,cart);
    		
    	} 
    	session.setAttribute("cart",cart );
    	System.out.println("going from servlet");
    	 response.sendRedirect("viewCart.jsp");	
    	 	
    }
    private void deleteCart(HttpServletRequest request, Cart cart) {
    	int itemId=Integer.parseInt(request.getParameter("itemId"));
    	cart.removeItem(itemId);
	}
	private void updateCart(HttpServletRequest request, Cart cart) {
		//System.out.println(request.getParameter("itemId"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
	    cart.updateItem(itemId, quantity);
		System.out.println(quantity);
		System.out.println(cart.getItems().get(itemId));
		
		
	}
	public void addCart(HttpServletRequest request,Cart cart) {
    	int pId = Integer.parseInt(request.getParameter("pId"));
    	System.out.println(pId);
    	int quantity=Integer.parseInt(request.getParameter("quantity"));
    	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
    	Product product = productDaoImpl.getProduct(pId);
    	float subTotal=0;;
    	if(product!=null) {
    		
        	String pName=product.getpName();
        	float price=product.getPrice();
        	//float subTotal=price*quantity;
        	subTotal+=(price*quantity);
        	 CartItem cartItem = new  CartItem(pId, pName,quantity, subTotal, price);
        	 System.out.println(cartItem);
        	 cart.addItem(cartItem);
        	
    	}
    	
    }
}

