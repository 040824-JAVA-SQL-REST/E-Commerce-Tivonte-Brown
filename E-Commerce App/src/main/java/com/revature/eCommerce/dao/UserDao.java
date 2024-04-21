package com.revature.eCommerce.dao;

import java.util.List;

import com.revature.eCommerce.models.*;

public class UserDao implements CrudDao<User> {

    @Override
    public void save(User obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User obj) {
        // TODO Auto-generated method stub

    }


    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

/*     public User Login(String username, String password) {
        //create User service
        UserService uSer = UserService.getConnection();
        try (
            PreparedStatement prepState = uSer.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?;")) {
            prepState.setString(1, username);
            prepState.setString(2, password);
            ResultSet rs = prepState.executeQuery();

            if (rs.next()) {
                // if a user with the given username and password exists in the database, return a User

                User accountL =  new User(rs.getInt("UserID"),
                rs.getString("username"), rs.getString("password"));
                return accountL;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // if no user was found, return null
        return null;
    } */

}