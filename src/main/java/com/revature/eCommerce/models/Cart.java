package com.revature.eCommerce.models;

public class Cart {
    private String cartID;
    private String buyer;
    private String productID;
    private String productName;
    private long price;
    private int quantity;

    public Cart(){}


    public Cart(String cartID, String buyer, String productName, int quantity) {
        this.cartID = cartID;
        this.buyer = buyer;
        this.productName = productName;
        this.quantity = quantity;
    }



    public Cart(String cartID, String buyer, String productID, String productName, long price, int quantity) {
        this.cartID = cartID;
        this.buyer = buyer;
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }



    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
