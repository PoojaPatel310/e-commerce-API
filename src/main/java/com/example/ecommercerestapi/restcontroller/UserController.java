package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.User;
import com.example.ecommercerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        List<User> users = userService.listAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> listAll(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        User savedUser = userService.insertUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id,
                                       @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted Successfully",HttpStatus.OK);
    }

}
