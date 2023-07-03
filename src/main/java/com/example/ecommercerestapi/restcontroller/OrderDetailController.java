package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.OrderDetail;
import com.example.ecommercerestapi.entity.Product;
import com.example.ecommercerestapi.service.OrderDetailService;
import com.example.ecommercerestapi.service.OrderMasterService;
import com.example.ecommercerestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private ProductService productService;

    public OrderDetailController(OrderDetailService orderDetailService, OrderMasterService orderMasterService, ProductService productService) {
        this.orderDetailService = orderDetailService;
        this.orderMasterService = orderMasterService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> listAll(){
        List<OrderDetail> orderDetails = orderDetailService.listAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable("id") int id){
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
        return new ResponseEntity<>(orderDetail,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> insert(@RequestBody OrderDetail orderDetail){
        OrderDetail savedOrderDetail = orderDetailService.insertOrderDetail(orderDetail);
        return new ResponseEntity<>(savedOrderDetail,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDetail> update(@PathVariable("id") int id,
                                              @RequestBody OrderDetail orderDetail){
        orderDetail.setId(id);
        OrderDetail updatedOrderDetail = orderDetailService.updateOrderDetail(orderDetail);
        return new ResponseEntity<>(updatedOrderDetail,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        orderDetailService.deleteOrderDetail(id);
        return new ResponseEntity<>("OrderDetail deleted Successfully",HttpStatus.OK);
    }

}
