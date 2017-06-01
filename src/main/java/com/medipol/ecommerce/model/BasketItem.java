package com.medipol.ecommerce.model;

public class BasketItem {

    private int quantity;
    private Product product;

    public BasketItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer price() {
        //TODO
        return quantity * product.getPrice();
    }

    public void incrementQuantity(int quantity){
        this.quantity += quantity;
    }

    public void decrementQuantity(int quantity){
        this.quantity -= quantity;
        if(this.quantity <0){
            this.quantity = 0;
        }
    }

}
