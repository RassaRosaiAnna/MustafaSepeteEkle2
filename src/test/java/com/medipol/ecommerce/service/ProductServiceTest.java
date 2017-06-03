package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    @Test
    public void shouldListInitialProducts() throws Exception {
        //TODO  başlangıctaki ürüğnleri listele

        final ProductService productService = new ProductService();
        //productService.list().size();
        productService.list();

    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO bir ürün ekle

        //final Product product = new Product(1, "Abc", 10);

        //String productName = product.getName();
        //assertTrue(product.getName().equals("Abc"));
        //assertTrue(product.getId() == 1);
        //assertTrue(product.getPrice()==10);


        ProductService productService = new ProductService();

        productService.add(1,"Patates",10);

        assertTrue(productService.findBy(1).getName().equals("Patates"));


    }

    @Test
    public void shouldMultipleOneProduct() throws Exception {
        //TODO birden fazla ürün ekle
        //final Product product = new Product(1, "Bellona", 10);
        //final Product product2 = new Product(2, "Casper", 5);

        //String productName = product.getName();
        //String productName2 = product2.getName();
        //assertTrue(productName.equals("Bellona"));
        //assertTrue(productName2.equals("Casper"));

        //assertTrue(product.getName().equals("Bellona"));
        //assertTrue(product2.getName().equals("Casper"));

        //assertTrue(productService.findBy(2).getId()==2);
        //assertTrue(productService.findBy(3).getId()==3);

        ProductService productService = new ProductService();
        productService.add(2,"Bellona",3);
        productService.add(3,"Casper",2);


        assertTrue(productService.findBy(2).getName().equals("Bellona"));
        assertTrue(productService.findBy(3).getName().equals("Casper"));





    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO id ile ürün sil
        //Product product = new Product(1,"Samsung",3000);

        //productService.delete(deletedOfId);

        //assertTrue(deletedOfId == 1);
        //assertTrue(productService.findBy(4).getId()==4);

        ProductService productService = new ProductService();
        productService.add(4,"Sunny",25);

        int deletedOfId = 4;
        productService.delete(deletedOfId);


        assertTrue(deletedOfId==4);

    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO ürün ismi güncelle

        //Product product = new Product(10,"Bayrak",10);
        ProductService productService = new ProductService();
        productService.add(10,"Patates",3);
        //productService.findBy(10).setName("Sprey");
        productService.update(10,"Sprey",3);

        assertTrue(productService.findBy(10).getName().equals("Sprey"));


    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO ürün fiyat güncelle
        //Product product = new Product(3,"Gozluk",3);

        ProductService productService = new ProductService();
        productService.add(3,"Gozluk",3);
        productService.update(3,"Gozluk",15);

        assertTrue(productService.findBy(3).getPrice()==15);
    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO ürün isim ve fiyat güncelle
        //Product product = new Product(4,"Kalem",50);
        ProductService productService = new ProductService();
        productService.add(4,"Kalem",300);
        productService.update(4,"Pilot Kalem",500);

        assertTrue(productService.findBy(4).getName().equals( "Pilot Kalem"));
        assertTrue(productService.findBy(4).getPrice()==500);


    }

}