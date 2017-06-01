package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()//TODO
@RestController
public class MedipolBasketRestController {

    //createBasket
    //getBasketDetail
    //addToBasket
    //removeProduct
    //incrementQuantity
    //decrementQuantity
    //getBasketPrice



    @Autowired private  BasketService basketService;
    @Autowired private ProductService productService;

    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    @RequestMapping(path = "/getBasketDetail")
    public void getBasketDetail(){
        basketService.printBasketDetail();
    }

    @RequestMapping(path = "/removeProduct")
    public void removeProduct(int productId){
        productService.delete(productId);
    }

    @RequestMapping(path = "/getBasketPrice")
    public void getBasketPrice(){
        basketService.getBasketPrice();
    }

    @RequestMapping(path = "/createBasket")
    public void createBasket(){
        Basket basket = new Basket();
    }

   @RequestMapping(path = "/incrementQuantity")
    public void incrementQuantity(@RequestParam Product product,@RequestParam Integer productId){
        basketService.incrementQuantity(product,productId);
    }


    @RequestMapping(path = "/decrementQuantity")
    public void decrementQuantity(@RequestParam Product product,@RequestParam Integer productId){
        basketService.decrementQuantity(product,productId);
    }



}
