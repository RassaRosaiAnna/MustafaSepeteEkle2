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
        BasketService basketService = new BasketService();
        Basket basket = new Basket();
        Product product = new Product(1,"Anahtarlik",3);

        final BasketItem basketItem = new BasketItem(1, product);

        basket.addItem(basketItem);

        //assertTrue(basketService.getBasket().getItems().get(1).getQuantity()==1);

        assertTrue(basketItem.getQuantity()==1);


    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO 2 adetli ürün ekeleme
        BasketService basketService = new BasketService();
        Basket basket = new Basket();

        Product product = new Product(2,"Tahta",3);
        final BasketItem basketItem = new BasketItem(2, product);
        basket.addItem(basketItem);

        //assertTrue(basketService.getBasket().getItems().get(0).getQuantity()==2);

        assertTrue(basketItem.getQuantity()==2);


    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO birden fazla

        Basket basket = new Basket();

        Product product = new Product(3,"Telefon",3);
        Product product1 = new Product(4,"Tablet",3);
        BasketItem basketItem = new BasketItem(3,product);
        BasketItem basketItem2 = new BasketItem(4,product1);
        basket.addItem(basketItem);
        basket.addItem(basketItem2);

        assertTrue(basketItem.getQuantity()==3);
        assertTrue(basketItem2.getQuantity()==4);

    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO
        //sepetten urunu sildi mi
        BasketService basketService = new BasketService();

        final Basket basket = new Basket();
        Product product = new Product(3,"Kulaklık",3);

        BasketItem basketItem = new BasketItem(2,product);
        basket.addItem(basketItem);

        basketService.removeProduct(product);
    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO  basketin ürün sayısını 1 arttır
        BasketService basketService = new BasketService();
        Basket basket = new Basket();
        Product product = new Product(3,"Patates",2);

        BasketItem basketItem = new BasketItem(5,product);
        basket.addItem(basketItem);


        basketService.incrementQuantity(product,6);

        // assertTrue(basket.calculateBasketPrice()==10);

         assertTrue(basketService.getBasketPrice()==10);

    }

    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO basketin ürün sayısını 1 azakt
        BasketService basketService = new BasketService();

        Basket basket = new Basket();
        Product product = new Product(4,"Mermer",1);

        BasketItem basketItem = new BasketItem(2,product);
        basket.addItem(basketItem);

        basketService.decrementQuantity(product,1);

        assertTrue(basketItem.getQuantity()==2);

    }

    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO  sepetteki ürünün sayısını bir azalt 0 sa ürünü sepetten sil

        Product product = new Product(11,"Oyuncak Kamyon",3);
        Basket basket = new Basket();
        BasketItem basketItem = new BasketItem(2,product);
        basket.addItem(basketItem);
        BasketService basketService = new BasketService();
        basketService.decrementQuantity(product,1);
        if(basketItem.getQuantity()==0){
            basketService.removeProduct(product);
        }

        //for(int i = 0; i<basket.getItems().size(); i++){
          //  assertTrue(basket.getItems().get(i).equals( "Oyuncak Kamyon"));
        //}

    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı
        Basket basket = new Basket();
        BasketService  basketService = new BasketService();


    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali
        BasketService basketService = new BasketService();
        Basket basket = new Basket();
        Product product = new Product(10,"Elma",3);
        BasketItem basketItem = new BasketItem(3,product);

        basket.addItem(basketItem);


       // assertTrue(basket.calculateBasketPrice()==9);
        //int result = basketService.getBasketPrice();
        //assertTrue(result == 9);

        assertTrue(basketService.getBasketPrice()==9);

    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali
        BasketService basketService = new BasketService();
        Basket basket = new Basket();
        Product product = new Product(11,"Soğan",2);
        Product product2 = new Product(12,"Kivi",2);

        BasketItem basketItem = new BasketItem(2,product);
        BasketItem basketItem2 = new BasketItem(2,product2);

        basket.addItem(basketItem);
        basket.addItem(basketItem2);

      //  int response = basket.calculateBasketPrice();

       // assertTrue(response  == 4);

        assertTrue(basketService.getBasketPrice() == 16);


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

        //Bu condition doğru çalışıyor
        assertTrue(basket.calculateBasketPrice()==3);
        //ama bu yanlış çalışıyor
        assertTrue(basketService.getBasketPrice()==3);

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

        //Bu condition doğru çalışıyor
        assertTrue(basket.calculateBasketPrice()==3);

        //ama bu yanlış çalışıyor
        assertTrue(basketService.getBasketPrice()==3);

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

        //Bu condition doğru çalışıyor
        // assertTrue(basket.calculateBasketPrice()==7);

        //ama bu yanlış çalışıyor
        assertTrue( basketService.getBasketPrice()==7);

    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali

        BasketService basketService = new BasketService();

        Basket basket = new Basket();

        Product product = new Product(1,"Cilek",3);
        Product product1 = new Product(2,"Karpuz",4);

        BasketItem basketItem = new BasketItem(2,product);
        BasketItem basketItem1 = new BasketItem(2,product1);

        basket.addItem(basketItem);
        basket.addItem(basketItem1);

        basketService.decrementQuantity(product,1);
        basketService.decrementQuantity(product1,1);

        //Bu condition doğru çalışıyor
        //assertTrue(basket.calculateBasketPrice()== 14);

        //ama bu yanlış çalışıyor
        assertTrue(basketService.getBasketPrice()==14);

    }
}