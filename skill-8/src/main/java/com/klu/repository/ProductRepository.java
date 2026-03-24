package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Method
    List<Product> findByCategory(String category);

    // Derived Query Method
    List<Product> findByPriceBetween(double min, double max);

    // JPQL Query - Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // JPQL Query - Price greater than
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    // JPQL Query - Category search
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);
}