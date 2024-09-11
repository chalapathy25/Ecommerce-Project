package Dao;

import java.util.List;

import Modules.User;

public interface UserDao {
	int addUser(User u);
    List getAllUser();
    User getUser(int userId);
    User getUser(String email);
    int updateUser(User u);
    int deleteUser(int userId);

}
