package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> listAllOrderDetails();
    OrderDetail getOrderDetailById(int id);
    OrderDetail insertOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    int deleteOrderDetail(int id);
}
