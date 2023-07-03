package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.OrderDetail;
import com.example.ecommercerestapi.repository.OrderDetailRepository;
import com.example.ecommercerestapi.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository repository;

    @Override
    public List<OrderDetail> listAllOrderDetails() {
        return repository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public OrderDetail insertOrderDetail(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }

    @Override
    public int deleteOrderDetail(int id) {
        repository.deleteById(id);
        return id;
    }
}
