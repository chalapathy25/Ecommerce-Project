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
@Table(name="orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemId")
    private int orderItemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subTotal")
    private float subTotal;
    
    @OneToOne
    @JoinColumn(name="pId")
     private Product product;
    
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderTable orderTable;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderItem(int orderItemId, int quantity, float subTotal, OrderTable orderTable) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.orderTable = orderTable;
	}

	public OrderItem(int quantity, float subTotal, OrderTable orderTable) {
		super();
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.orderTable = orderTable;
	}
	

	public OrderItem(int quantity, float subTotal, Product product, OrderTable orderTable) {
		super();
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.product = product;
		this.orderTable = orderTable;
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	


}
