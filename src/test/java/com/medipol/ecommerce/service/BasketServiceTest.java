package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class BasketServiceTest {

    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO basket olustur
        Basket basket = new Basket();

    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO bir adetli ürün ekle

        Basket basket = new Basket();
        Product product = new Product(1,"Anahtarlik",3);

        final BasketItem basketItem = new BasketItem(1, product);

        basket.addItem(basketItem);

         //  assertTrue(basketItem.getQuantity() == 1);
         // assertTrue(result == 5);


        assertTrue(basketItem.getQuantity()==1);

    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO 2 adetli ürün ekeleme

        Basket basket = new Basket();

        Product product = new Product(2,"Tahta",3);
        final BasketItem basketItem = new BasketItem(2, product);
        basket.addItem(basketItem);

        assertTrue(basketItem.getQuantity()==1);


    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO birden fazla

        Basket basket = new Basket();

        Product product = new Product(3,"Telefon",3);
        Product product1 = new Product(4,"Tablet",3);
        BasketItem basketItem = new BasketItem(3,product);
        BasketItem basketItem2 = new BasketItem(4,product1);

        assertTrue(basketItem.getQuantity()==3);
        assertTrue(basketItem2.getQuantity()==4);


    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO
        //sepetten urunu sildi mi
        ProductService productService = new ProductService();

        final Basket basket = new Basket();
        Product product = new Product(3,"asd",3);
        BasketItem basketItem = new BasketItem(2,product);

        productService.delete(3);

        // EKSİK :)

    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO  basketin ürün sayısını 1 arttır
        BasketService basketService = new BasketService();
        Basket basket = new Basket();
        Product product = new Product(3,"qwdasd",2);

        BasketItem basketItem = new BasketItem(5,product);


        basketService.incrementQuantity(product,3);

        assertTrue(basketItem.getQuantity() == 5);


    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO basketin ürün sayısını 1 azakt
        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(4,"Mermer",1);

        BasketItem basketItem = new BasketItem(1,product);

        basketService.decrementQuantity(product,2);

    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO  sepetteki ürünün sayısını bir azalt 0 sa ürünü sepetten sil
    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı

    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali
        Basket basket = new Basket();
        Product product = new Product(10,"asd",3);
        BasketItem basketItem = new BasketItem(3,product);

        basket.addItem(basketItem);


        assertTrue(basket.calculateBasketPrice()==9);

    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali

        Basket basket = new Basket();
        Product product = new Product(11,"Abc",2);
        BasketItem basketItem = new BasketItem(2,product);

        int response = basket.calculateBasketPrice();

        assertTrue(response  == 4);


    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali
        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(1,"Elma",3);
        BasketItem basketItem = new BasketItem(1,product);
        basket.addItem(basketItem);
        basketService.incrementQuantity(product,2);

        basketService.getBasketPrice();


    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali

        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(1,"Armut",3);
        BasketItem basketItem = new BasketItem(1,product);
        basket.addItem(basketItem);

        basketService.decrementQuantity(product,1);

        basketService.getBasketPrice();


    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali
        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(1,"Patates",3);
        Product product1 = new Product(2,"Kadayıf",4);

        BasketItem basketItem = new BasketItem(1,product);
        BasketItem basketItem1 = new BasketItem(1,product1);

        basket.addItem(basketItem);
        basket.addItem(basketItem1);

        basketService.incrementQuantity(product,2);
        basketService.incrementQuantity(product1,2);

        basketService.getBasketPrice();

    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali

        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(1,"Cilek",3);
        Product product1 = new Product(2,"Karpuz",4);

        BasketItem basketItem = new BasketItem(1,product);
        BasketItem basketItem1 = new BasketItem(1,product1);

        basket.addItem(basketItem);
        basket.addItem(basketItem1);

        basketService.decrementQuantity(product,3);
        basketService.decrementQuantity(product1,1);

        basketService.getBasketPrice();


    }


}