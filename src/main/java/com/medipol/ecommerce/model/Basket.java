package com.medipol.ecommerce.model;

import com.medipol.ecommerce.service.BasketService;

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

    public int calculateBasketPrice() {
        int result = 0;
        //TODO
        for(int i = 0; i<items.size(); i++){
             result = result + items.get(i).getQuantity()*items.get(i).getProduct().getPrice();
        }
        return result;

    }
}
