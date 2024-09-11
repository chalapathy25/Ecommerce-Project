package Dao;

import java.util.List;

import Modules.OrderItem;

public interface OrderItemDao {
	int addOrderItem(OrderItem o);
    List getAllOrderItem(int orderId);
    OrderItem getOrderItem(int orderItemId );
    int updateOrderItem(OrderItem o);
    int deleteOrderItem(int orderItemId);
	

}
