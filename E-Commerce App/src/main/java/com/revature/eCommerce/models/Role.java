package com.revature.eCommerce.models;

public class Role {

    private String ID;
    private String roleName;

    public Role(){}

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleID, String roleName) {
        this.ID = roleID;
        this.roleName = roleName;
    }


}