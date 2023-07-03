package com.example.ecommercerestapi.repository;

import com.example.ecommercerestapi.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,Integer> {
}
