package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private Basket basket = new Basket();
    private List<Product> products = new ArrayList<Product>();

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        //TODO productName, quantity

        for (BasketItem basketItem : basket.getItems()) {
            basketItem.getProduct().getName();
            basketItem.getQuantity();
            System.out.println(basketItem.getQuantity());
            System.out.println(basketItem.getProduct().getName());
        }

    }

    public void addProduct(Product product, Integer quantity) {
        //TODO
        products.add(quantity, product);

    }

    public void removeProduct(Product product) {
        //TODO
        //sepetten ilgili ürünü silmeli
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (product.getId() == products.get(i).getId()) {
                index = i;
                break;
            }
        }
        products.remove(index);
    }

    public void incrementQuantity(Product product, Integer quantity) {
//        //TODO sepetteki itemin sayisi soylenen kadar artirilmali

        for (BasketItem basketItem : basket.getItems()) {
            if (basketItem.getProduct().getId() == product.getId()) {
                basketItem.incrementQuantity(quantity);
            }
        }
    }

    public void decrementQuantity(Product product, Integer quantity) {
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali

        for (BasketItem basketItem : basket.getItems()) {
            if (basketItem.getProduct().getId() == product.getId()) {
                basketItem.decrementQuantity(quantity);
                //0 ise sepetten cikartilmali
                if (basketItem.getQuantity() == 0) {
                    removeProduct(product);
                }
            }
        }

    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice( ) {
        //TODO  sepet tutarini donmeli


        //return basket.calculateBasketPrice();
        Basket basket = new Basket();
       // basket.calculateBasketPrice();
        return  basket.calculateBasketPrice();

    }

}
