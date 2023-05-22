package com.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    Service service;
    @GetMapping(value = "/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping(value = "/products", params = "name")
    public List<Product> getProductByName(String name){
        return service.getProductByName(name);
    }

    @GetMapping(value = "/products", params = "text")
    public List<Product> getProductByText(String text){
        return service.getProductByText(text);
    }

    @GetMapping(value = "/products", params = "place")
    public List<Product> getProductByPlace(String place){
        return service.getProductByPlace(place);
    }

    @GetMapping(value = "/products", params = "year")
    public List<Product> getProductOutOfWarranty(int year){
        return service.getProductOutOfWarranty(year);
    }

    @PostMapping("/product")
    public void saveProduct(@RequestBody Product product){
        service.saveProduct(product);
    }

    @DeleteMapping(value = "/product", params = "id")
    public void deleteProduct(int id){
        service.deleteProduct(id);
    }
}
