package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :productList")
    List<Product> findProductsAndCategories(List<Product> productList);
}
