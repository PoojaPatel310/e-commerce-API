package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.Cart;
import com.example.ecommercerestapi.entity.User;
import com.example.ecommercerestapi.repository.CartRepository;
import com.example.ecommercerestapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository repository;
    @Override
    public List<Cart> listAllCarts() {
        return repository.findAll();
    }

    @Override
    public List<Cart> getCartByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Cart getCartById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Cart insertCart(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public int deleteCart(int id) {
        repository.deleteById(id);
        return id;
    }
}
