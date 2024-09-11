package Dao;

import java.util.List;

import Modules.OrderHistory;

public interface OrderHistoryDao {
	int addOrderHistory(OrderHistory o);
    List getAllOrderHistory(int userId);
    OrderHistory getOrderHistory(int orderHistoryId );

}
