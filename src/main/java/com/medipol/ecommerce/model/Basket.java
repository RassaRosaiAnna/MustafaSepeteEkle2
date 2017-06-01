package com.medipol.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {


    private List<BasketItem> items = new ArrayList<>();

    public void addItem(BasketItem item) {
        items.add(item);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Integer calculateBasketPrice() {

        //TODO
       //  items.get(0).price();

        //BasketItem basketItem = null;

       // return basketItem.price();


        return 11;

    }
}
