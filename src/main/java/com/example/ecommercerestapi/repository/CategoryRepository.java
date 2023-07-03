package com.example.ecommercerestapi.repository;


import com.example.ecommercerestapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
