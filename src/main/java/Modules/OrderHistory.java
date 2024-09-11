package Modules;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderHistoryId")
    private int orderHistoryId;

    @Column(name = "totalAmount")
    private float totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "orderDate")
    private String orderDate;

    @OneToOne
    @JoinColumn(name = "orderId")
    private OrderTable orderTable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public OrderHistory() {
		// TODO Auto-generated constructor stub
	}
	public OrderHistory(int orderHistoryId, float totalAmount, String status, String orderDate) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
	}
	
	public OrderHistory(float totalAmount, String status, String orderDate, OrderTable orderTable, User user) {
		super();
		this.totalAmount = totalAmount;
		this.status = status;
		this.orderDate = orderDate;
		this.orderTable = orderTable;
		this.user = user;
	}
	
	public OrderTable getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
    
    


}
