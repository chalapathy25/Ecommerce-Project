package Modules;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderTable")
public class OrderTable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "orderId")
	    private int orderId;

	    @Column(name = "orderDate")
	    private String orderDate;

	    @Column(name = "totalAmount")
	    private float totalAmount;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "paymentMode")
	    private String paymentMode;

	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private User user;

	    @OneToMany(mappedBy = "orderTable", cascade = CascadeType.ALL)
	    private Set<OrderItem> orderItems;
	    
	public OrderTable(String orderDate, float totalAmount, String status, String paymentMode, User user,
			Set<OrderItem> orderItems) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.user = user;
		this.orderItems = orderItems;
	}
	
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderTable() {
		// TODO Auto-generated constructor stub
	}
	public OrderTable(int orderId, String orderDate, float totalAmount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	public OrderTable(String orderDate, float totalAmount, String status, String paymentMode, User user) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	


}
