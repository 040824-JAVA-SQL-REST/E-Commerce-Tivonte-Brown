package com.revature.eCommerce.services;

import java.util.List;

import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.models.User;


public class UserService {
    private final UserDao userDao;


    public UserService(UserDao userDao){
        this.userDao = userDao;

    }

    public boolean isUniqueUsername() {
        List<User> users = userDao.findAll();
        return users.stream().noneMatch(u -> u.getName().equals(name));
    }

    public boolean isValidUsername(String username){

        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")
    }

    public boolean isValidPassword(String password){
        //Minimum eight characters, at least one letter, one number and one special character

        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    }
}
