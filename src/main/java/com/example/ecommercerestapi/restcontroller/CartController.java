package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.Cart;
import com.example.ecommercerestapi.service.CartService;
import com.example.ecommercerestapi.service.ProductService;
import com.example.ecommercerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    public CartController(CartService cartService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> listALl(){
        List<Cart> carts = cartService.listAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    //
    @PostMapping
    public  ResponseEntity<Cart> insert(@RequestBody Cart cart){
        Cart savedCart = cartService.insertCart(cart);
        return new ResponseEntity<>(savedCart,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") int id){
        Cart cart = cartService.getCartById(id);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cart> update(@PathVariable("id")int id,
                                       @RequestBody Cart cart){
        cart.setId(id);
        Cart updatedCart = cartService.updateCart(cart);
        return new ResponseEntity<>(updatedCart,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart Deleted Successfully",HttpStatus.OK);
    }


}
