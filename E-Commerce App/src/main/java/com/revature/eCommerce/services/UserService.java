package com.revature.eCommerce.services;

public class UserService {

    public boolean isUniqueUsername() {
        //ToDO
        return true;
    }

    public boolean isValidUsername(String username){

        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")
    }

    public boolean isValidPassword(String password){
        //Minimum eight characters, at least one letter, one number and one special character:
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    }
}
