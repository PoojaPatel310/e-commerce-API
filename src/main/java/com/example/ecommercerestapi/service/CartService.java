package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.Cart;
import com.example.ecommercerestapi.entity.User;

import java.util.List;

public interface CartService {

    List<Cart> listAllCarts();

    List<Cart> getCartByUser(User user);
    Cart getCartById(int id);
    Cart insertCart(Cart cart);
    Cart updateCart(Cart cart);
    int deleteCart(int id);
}
