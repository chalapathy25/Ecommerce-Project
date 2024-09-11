package Dao;

import java.util.List;

import Modules.OrderTable;

public interface OrderTableDao {
	int addOrderTable(OrderTable o);
    List getAllOrderTable(int userId);
    OrderTable getOrderTable(int orderId );

}
