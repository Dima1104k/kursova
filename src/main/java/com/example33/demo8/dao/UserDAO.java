package com.example33.demo8.dao;

import com.example33.demo8.model.User;
import java.util.List;

public interface UserDAO {
  
    List<User> getAllUsers() throws Exception;

    List<User> getUsersByType(String type) throws Exception;

    List<User> findUsersByGroup(String group) throws Exception;

    User getUserById(Integer id) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(Integer id) throws Exception;

    Integer getNextId() throws Exception;

    void addUser(User user) throws Exception;

     User findUserByName(String firstName, String lastName)throws Exception;;

}
