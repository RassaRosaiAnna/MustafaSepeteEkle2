package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    public ProductService() {

        products.add(new Product(1, "nike air", 200));
        products.add(new Product(2, "addidas", 300));
    }

    public void add(int Id, String name, Integer quantity) {
        //TODO
        products.add(new Product(Id, name, quantity));

    }

    public void delete(Integer id) {
        //TODO
        int indexToDelete = -1;

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                indexToDelete = i;
                break;
            }
        }
        products.remove(indexToDelete);
    }

    public void update(Integer id, String name, Integer price) {
        //TODO

        // Product product = null;

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                //   product = products.get(i);
                products.get(i).setName(name);
                products.get(i).setPrice(price);
                break;
            }
        }

        //  product.setName(name);
        // product.setPrice(price);

//        for (Product product : products) {
//            if(product.getId() == id){
//                product.setName(name);
//                product.setPrice(price);
//                break;
//            }
//        }

    }

    public List<Product> list() {
        return products;
    }

    public Product findBy(int productId) {
        //TODO
        for (int i = 0; i < products.size(); i++) {
            if (productId == products.get(i).getId()) {
                return products.get(i);
            }
        }
        return null;
    }
}
