package com.revature.eCommerce.models;

public class Cart {
    private String buyer;
    private String product;
    private long price;
    private int quantity;

    public Cart(){}

    public Cart(String buyer, String product, long price, int quantity) {
        this.buyer = buyer;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getbuyer() {
        return buyer;
    }

    public void setbuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
