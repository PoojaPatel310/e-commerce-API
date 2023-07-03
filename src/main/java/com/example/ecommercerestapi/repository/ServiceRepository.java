package com.example.ecommercerestapi.repository;


import com.example.ecommercerestapi.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {

}
