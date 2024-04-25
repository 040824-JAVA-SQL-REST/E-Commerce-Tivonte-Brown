package com.revature.eCommerce.models;

import java.util.UUID;

import com.revature.eCommerce.dto.request.NewRegisterRequest;

public class User {
    private String userID;
    private String name;
    private String password;
    private String email;
    private String purchaseHistory;
    private String roleID;
    private long money;


    public User() {
    }

    public User (NewRegisterRequest req){
        this.userID = UUID.randomUUID().toString();
        this.name = req.getName();
        this.password = req.getPassword();
        this.email = req.getEmail();

    }

    public User(String name, String password, String email) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.email = email;
        this.money = 0L;
        this.roleID = "DEFAULT";
    }

    public String getUserID() {
        return userID;
    }


    public void setUserID(String userID) {
        this.userID = userID;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getRoleID() {
        return roleID;
    }


    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }


    public long getMoney() {
        return money;
    }


    public void setMoney(long money) {
        this.money = money;
    }

}
