package com.revature.eCommerce.services;

import java.util.List;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;

import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.models.User;
import com.revature.eCommerce.utils.ResourceNotFoundException;


public class UserService {
    private final UserDao userDao;
    //private final RoleService roleService;

    public UserService(UserDao userDao){
        this.userDao = userDao;

    }

    public void save(User user){
        userDao.save(user);
    }

    public Optional<User> login(String name, String password){
        return userDao.findAll().stream().filter(u -> u.getName().equals(name) && BCrypt.checkpw(password, u.getPassword())).findFirst();
    }

/*      public UserService(RoleService roleService, UserDao userDao){
        this.roleService = roleService;
        this.userDao = userDao;
    }
 */

/*     public void save(User user){
        String defaultID = roleService.getRoleIDByName{"DEFAULT"};
        if (defaultID == null || defaultID.isEmpty()) {
            throw new ResourceNotFoundException("DEFAULT role not found!");
        }
        userDao.save(user);
    }
 */

    public boolean isUniqueUsername(String name) {
        List<User> users = userDao.findAll();
        return users.stream().noneMatch(u -> u.getName().equals(name));
    }

    public boolean isValidUsername(String username){

        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isValidPassword(String password){
        //Minimum eight characters, at least one letter, one number and one special character

        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}