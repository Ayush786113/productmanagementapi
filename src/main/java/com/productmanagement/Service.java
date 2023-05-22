package com.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository repository;
    public List<Product> getAllProducts(){
        return repository.findAll();
    }
    public List<Product> getProductByName(String name){
        return repository.findByName(name);
    }
    public List<Product> getProductByText(String text){
        return repository.findAll().stream().filter(product -> {
            return product.getName().toLowerCase().contains(text.toLowerCase()) ||
                    product.getPlace().toLowerCase().contains(text.toLowerCase()) ||
                    product.getType().toLowerCase().contains(text.toLowerCase());
        }).toList();
    }

    public List<Product> getProductByPlace(String place){
        return repository.findByPlace(place);
    }

    public List<Product> getProductOutOfWarranty(int year){
        return repository.getProductOutOfWarranty(year);
    }

    public void saveProduct(Product product){
        repository.save(product);
    }
    public void deleteProduct(int id){
        repository.deleteById(id);
    }
}
