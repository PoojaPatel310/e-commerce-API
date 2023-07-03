package com.example.ecommercerestapi.repository;


import com.example.ecommercerestapi.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
