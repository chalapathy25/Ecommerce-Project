package Dao;

import java.util.List;

import Modules.Product;

public interface ProductDao {
	int addProduct(Product p);
    List getAllProducts();
    Product getProduct(int pId);
    int updateProduct(Product p);
    int deleteUser(int pId);


}
