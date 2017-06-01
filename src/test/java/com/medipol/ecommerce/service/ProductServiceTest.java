package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    @Test
    public void shouldListInitialProducts() throws Exception {
        //TODO  başlangıctaki ürüğnleri listele

        final ProductService productService = new ProductService();
        productService.list();

    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO bir ürün ekle

        final Product product = new Product(1, "Abc", 10);
        String productName = product.getName();
        assertTrue(productName.equals("Abc"));


    }

    @Test
    public void shouldMultipleOneProduct() throws Exception {
        //TODO birden fazla ürün ekle
        final Product product = new Product(1, "Bellona", 10);
        final Product product2 = new Product(2, "Casper", 5);

        String productName = product.getName();
        String productName2 = product2.getName();


        assertTrue(productName.equals("Bellona"));
        assertTrue(productName2.equals("Casper"));

    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO id ile ürün sil
        Product product = new Product(1,"Samsung",3000);
        ProductService productService = new ProductService();

        int deletedOfId = 1;
        productService.delete(deletedOfId);

        assertTrue(deletedOfId == 1);

    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO ürün ismi güncelle

        Product product = new Product(10,"Bayrak",1000000);

        ProductService productService = new ProductService();
        productService.update(10,"Sprey",10);


    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO ürün fiyat güncelle
        Product product = new Product(3,"Gozluk",3);

        ProductService productService = new ProductService();
        productService.update(3,"Gozluk",100);
    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO ürün isim ve fiyat güncelle
        Product product = new Product(4,"Kalem",50);
        ProductService productService = new ProductService();
        productService.update(4,"Pilot Kalem",500);


    }

}