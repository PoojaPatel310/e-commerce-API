package com.example.ecommercerestapi.repository;


import com.example.ecommercerestapi.entity.Brand;
import com.example.ecommercerestapi.entity.Category;
import com.example.ecommercerestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    List<Product> findByCategory(Category category);
    List<Product> findByBrand(Brand brand);
}

