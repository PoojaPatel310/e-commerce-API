package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.OrderMaster;
import com.example.ecommercerestapi.repository.OrderMasterRepository;
import com.example.ecommercerestapi.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    OrderMasterRepository repository;
    @Override
    public List<OrderMaster> listAllOrderMasters() {
        return repository.findAll();
    }

    @Override
    public OrderMaster getOrderMasterById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public OrderMaster insertOrderMaster(OrderMaster orderMaster) {
        return repository.save(orderMaster);
    }

    @Override
    public OrderMaster updateOrderMaster(OrderMaster orderMaster) {
        return repository.save(orderMaster);
    }

    @Override
    public int deleteOrderMaster(int id) {
        repository.deleteById(id);
        return id;
    }
}
