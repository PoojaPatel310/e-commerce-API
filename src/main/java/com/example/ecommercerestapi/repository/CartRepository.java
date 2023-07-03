package com.example.ecommercerestapi.repository;

import com.example.ecommercerestapi.entity.Cart;
import com.example.ecommercerestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    List<Cart> findByUser(User user);
}
