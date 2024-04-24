package com.revature.eCommerce.dto.requests;

public class NewLoginRequest {

    private String name;
    private String password;

    public NewLoginRequest(String name, String password, String email) {
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

}
