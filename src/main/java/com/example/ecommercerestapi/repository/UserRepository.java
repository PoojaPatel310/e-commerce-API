package com.example.ecommercerestapi.repository;


import com.example.ecommercerestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailAndPassword(String email,String password);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
