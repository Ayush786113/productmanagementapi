package com.productmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product, Integer> {
    public List<Product> findByName(String name);
    public List<Product> findByPlace(String place);
    @Query(value = "SELECT * FROM products WHERE warranty < :year", nativeQuery = true)
    public List<Product> getProductOutOfWarranty(int year);
}
