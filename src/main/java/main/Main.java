package main;

import java.util.List;

import DaoImpl.OrderHistoryDaoImpl;
import DaoImpl.OrderItemDaoImpl;
import DaoImpl.OrderTableDaoImpl;
import DaoImpl.ProductDaoImpl;
import DaoImpl.UserDaoImpl;
import Modules.OrderHistory;
import Modules.OrderItem;
import Modules.OrderTable;
import Modules.Product;
import Modules.User;

public class Main {

	public static void main(String[] args) {
		 System.out.println( "Hello World!" );
	        UserDaoImpl userDaoImpl = new UserDaoImpl();
	        User user = new User("Ntr", "ntr@gmail.com", "96829", "123", "kuppam");
	        User user1 = new User("John Doe", "john.doe@example.com", "555-1234", "password123", "123 Elm Street");
	        User user2 = new User("Jane Smith", "jane.smith@example.com", "555-5678", "password456", "456 Oak Avenue");
	        User user3 = new User("Alice Johnson", "alice.johnson@example.com", "555-8765", "password789", "789 Pine Road");
	        User user4 = new User("Bob Brown", "bob.brown@example.com", "555-4321", "password000", "101 Maple Street");
	        User user5 = new User("Charlie Davis", "charlie.davis@example.com", "555-6789", "password111", "202 Birch Avenue");
	        User user6 = new User("Diana Evans", "diana.evans@example.com", "555-3456", "password222", "303 Cedar Lane");
	        User user7 = new User("Eve White", "eve.white@example.com", "555-7890", "password333", "404 Walnut Street");
	        User user8 = new User("Frank Miller", "frank.miller@example.com", "555-2345", "password444", "505 Fir Avenue");
	        User user9 = new User("Grace Wilson", "grace.wilson@example.com", "555-9876", "password555", "606 Chestnut Road");
	        User user10 = new User("Hank Lee", "hank.lee@example.com", "555-5432", "password666", "707 Spruce Lane"); 
	        userDaoImpl.addUser(user);
	        userDaoImpl.addUser(user1);
	        userDaoImpl.addUser(user2);
	        userDaoImpl.addUser(user3);
	        userDaoImpl.addUser(user4);
	        userDaoImpl.addUser(user5);
	        userDaoImpl.addUser(user6);
	        userDaoImpl.addUser(user7);
	        userDaoImpl.addUser(user8);
	        userDaoImpl.addUser(user9);
	        userDaoImpl.addUser(user10);
	        ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	        Product product1 = new Product("iPhone 15", "Apple", 999.99f, "6.1-inch Super Retina XDR display", "/images/iphone15.jpg");
	        Product product2 = new Product("Galaxy S24 Ultra", "Samsung", 1199.99f, "6.8-inch Dynamic AMOLED display, 1TB storage", "/images/galaxyS24Ultra.jpg");
	        Product product3 = new Product("Pixel 9 Pro", "Google", 899.99f, "6.7-inch OLED display, Google Tensor G3", "/images/pixel9Pro.jpg");
	        Product product4 = new Product("OnePlus 12", "OnePlus", 799.99f, "6.7-inch Fluid AMOLED display, 12GB RAM", "/images/oneplus12.jpg");
	        Product product5 = new Product("Xperia 1 V", "Sony", 949.99f, "6.5-inch 4K OLED display, triple camera system", "/images/xperia1V.jpg");
	        Product product6 = new Product("Moto Edge 40", "Motorola", 699.99f, "6.6-inch OLED display, 256GB storage", "/images/motoEdge40.jpg");
	        Product product7 = new Product("Vivo X90 Pro", "Vivo", 849.99f, "6.78-inch AMOLED display, Zeiss optics", "/images/vivoX90Pro.jpg");
	        Product product8 = new Product("Oppo Find X6", "Oppo", 799.99f, "6.74-inch AMOLED display, Snapdragon 8 Gen 2", "/images/oppoFindX6.jpg");
	        Product product9 = new Product("Asus ROG Phone 7", "Asus", 1099.99f, "6.78-inch AMOLED display, Snapdragon 8 Gen 2", "/images/asusROGPhone7.jpg");
	        Product product10 = new Product("Nokia X30 5G", "Nokia", 599.99f, "6.43-inch AMOLED display, 5G connectivity", "/images/nokiaX30.jpg");

	       productDaoImpl.addProduct(product1);
	        productDaoImpl.addProduct(product2);
	        productDaoImpl.addProduct(product3);
	        productDaoImpl.addProduct(product4);
	        productDaoImpl.addProduct(product5);
	        productDaoImpl.addProduct(product6);
	        productDaoImpl.addProduct(product7);
	        productDaoImpl.addProduct(product8);
	        productDaoImpl.addProduct(product9);
	        productDaoImpl.addProduct(product10);
	        OrderTableDaoImpl orderDaoImpl = new OrderTableDaoImpl();

	        OrderTable order1 = new OrderTable("2024-09-01", 1199.98f, "Completed", "Credit Card", user1);
	        OrderTable order2 = new OrderTable("2024-09-02", 699.99f, "Shipped", "PayPal", user2);
	        OrderTable order3 = new OrderTable("2024-09-03", 499.99f, "Pending", "Debit Card", user3);
	        OrderTable order4 = new OrderTable("2024-09-04", 199.99f, "Completed", "Credit Card", user4);
	        OrderTable order5 = new OrderTable("2024-09-05", 149.99f, "Delivered", "PayPal", user5);
	        OrderTable order6 = new OrderTable("2024-09-06", 499.99f, "Completed", "Credit Card", user6);
	        OrderTable order7 = new OrderTable("2024-09-07", 129.99f, "Shipped", "Debit Card", user7);
	        OrderTable order8 = new OrderTable("2024-09-08", 89.99f, "Pending", "Credit Card", user8);
	        OrderTable order9 = new OrderTable("2024-09-09", 59.99f, "Completed", "PayPal", user9);
	        OrderTable order10 = new OrderTable("2024-09-10", 299.99f, "Delivered", "Credit Card", user10);

	        orderDaoImpl.addOrderTable(order1);
	        orderDaoImpl.addOrderTable(order2);
	        orderDaoImpl.addOrderTable(order3);
	        orderDaoImpl.addOrderTable(order4);
	        orderDaoImpl.addOrderTable(order5);
	        orderDaoImpl.addOrderTable(order6);
	        orderDaoImpl.addOrderTable(order7);
	        orderDaoImpl.addOrderTable(order8);
	        orderDaoImpl.addOrderTable(order9);
	        orderDaoImpl.addOrderTable(order10);
	        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

	        OrderItem item1 = new OrderItem(2, 899.99f,product1, order1);
	        OrderItem item2 = new OrderItem(1, 699.99f,product2, order2);
	        OrderItem item3 = new OrderItem(1, 499.99f,product3, order3);
	        OrderItem item4 = new OrderItem(1, 199.99f,product4, order4);
	        OrderItem item5 = new OrderItem(1, 149.99f,product5, order5);
	        OrderItem item6 = new OrderItem(1, 499.99f,product6, order6);
	        OrderItem item7 = new OrderItem(1, 129.99f,product7, order7);
	        OrderItem item8 = new OrderItem(1, 89.99f,product8, order8);
	        OrderItem item9 = new OrderItem(1, 59.99f,product9, order9);
	        OrderItem item10 = new OrderItem(1, 299.99f,product10, order10);

	        orderItemDao.addOrderItem(item1);
	        orderItemDao.addOrderItem(item2);
	        orderItemDao.addOrderItem(item3);
	        orderItemDao.addOrderItem(item4);
	        orderItemDao.addOrderItem(item5);
	        orderItemDao.addOrderItem(item6);
	        orderItemDao.addOrderItem(item7);
	        orderItemDao.addOrderItem(item8);
	        orderItemDao.addOrderItem(item9);
	        orderItemDao.addOrderItem(item10);
	        OrderHistoryDaoImpl orderHistoryDaoImpl = new OrderHistoryDaoImpl();

	        OrderHistory history1 = new OrderHistory( 1199.98f, "Completed", "2024-09-01", order1, user1);
	        OrderHistory history2 = new OrderHistory( 699.99f, "Shipped", "2024-09-02", order2, user2);
	        OrderHistory history3 = new OrderHistory( 499.99f, "Pending", "2024-09-03", order3, user3);
	        OrderHistory history4 = new OrderHistory( 199.99f, "Completed", "2024-09-04", order4, user4);
	        OrderHistory history5 = new OrderHistory( 149.99f, "Delivered", "2024-09-05", order5, user5);
	        OrderHistory history6 = new OrderHistory( 499.99f, "Completed", "2024-09-06", order6, user6);
	        OrderHistory history7 = new OrderHistory( 129.99f, "Shipped", "2024-09-07", order7, user7);
	        OrderHistory history8 = new OrderHistory( 89.99f, "Pending", "2024-09-08", order8, user8);
	        OrderHistory history9 = new OrderHistory( 59.99f, "Completed", "2024-09-09", order9, user9);
	        OrderHistory history10 = new OrderHistory( 299.99f, "Delivered", "2024-09-10", order10, user10);

	        orderHistoryDaoImpl.addOrderHistory(history1);
	        orderHistoryDaoImpl.addOrderHistory(history2);
	        orderHistoryDaoImpl.addOrderHistory(history3);
	        orderHistoryDaoImpl.addOrderHistory(history4);
	        orderHistoryDaoImpl.addOrderHistory(history5);
	        orderHistoryDaoImpl.addOrderHistory(history6);
	        orderHistoryDaoImpl.addOrderHistory(history7);
	        orderHistoryDaoImpl.addOrderHistory(history8);
	        orderHistoryDaoImpl.addOrderHistory(history9);
	        orderHistoryDaoImpl.addOrderHistory(history10);
	        System.out.println("Success");
		 
		 
		//System.out.println( new OrderTableDaoImpl().getMaxOrder());
	}
	        

}
