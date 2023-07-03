package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.OrderMaster;
import com.example.ecommercerestapi.service.OrderMasterService;
import com.example.ecommercerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-master")
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private UserService userService;

    public OrderMasterController(OrderMasterService orderMasterService, UserService userService) {
        this.orderMasterService = orderMasterService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<OrderMaster>> listAll(){
        List<OrderMaster> orderMasters = orderMasterService.listAllOrderMasters();
        return new ResponseEntity<>(orderMasters, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderMaster> getOrderById(@PathVariable("id") int id){
        OrderMaster orderMaster = orderMasterService.getOrderMasterById(id);
        return new ResponseEntity<>(orderMaster,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderMaster> insert(@RequestBody OrderMaster orderMaster){
        OrderMaster savedOrder = orderMasterService.insertOrderMaster(orderMaster);
        return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderMaster> update(@PathVariable("id") int id,
                                              @RequestBody OrderMaster orderMaster){
        orderMaster.setId(id);
        OrderMaster updatedOrder = orderMasterService.updateOrderMaster(orderMaster);
        return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        orderMasterService.deleteOrderMaster(id);
        return new ResponseEntity<>("Order Deleted Successfully",HttpStatus.OK);
    }

}
