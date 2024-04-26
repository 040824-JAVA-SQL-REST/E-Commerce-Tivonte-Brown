package com.revature.eCommerce.dto.responses;

import com.revature.eCommerce.models.Role;
import com.revature.eCommerce.models.User;

public class Principal {
    private String name;
    private String password;
    private Role role;

    public Principal (){

    }

    public Principal (User user, Role role){
        this.name = user.getName();
        this.password = user.getPassword();
        this.role = role;

    }


    public Principal(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Principal(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
