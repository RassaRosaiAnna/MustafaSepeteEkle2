package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/medipol1")//TODO
@RestController
public class MedipolProductRestController {

    @Autowired private BasketService basketService = new BasketService();
    @Autowired private ProductService productService = new ProductService();

    @RequestMapping(path = "/addProduct")
    public void addToProduct(int Id,String productName,int productQuantity){
        productService.add(Id,productName,productQuantity);
    }
    @RequestMapping(path = "/deleteProduct")
    public void deleteToProduct(int productId){
        productService.delete(productId);
    }

    @RequestMapping(path = "/updateProduct")
    public void updateProduct(int productId, String productName, int productPrice){
        productService.update(productId,productName,productPrice);
    }

    @RequestMapping(path = "/product")
    public void productList(){
        productService.list();
    }

    @RequestMapping(path = "/findById")
    public void findById(int productId ){
        productService.findBy(productId);
    }


    //add
    //delete
    //update
    //list
    //findById

}
