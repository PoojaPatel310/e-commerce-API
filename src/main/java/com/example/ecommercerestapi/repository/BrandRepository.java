package com.example.ecommercerestapi.repository;

import com.example.ecommercerestapi.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
