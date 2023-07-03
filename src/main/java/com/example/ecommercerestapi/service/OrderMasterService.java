package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.OrderMaster;

import java.util.List;

public interface OrderMasterService {

    List<OrderMaster> listAllOrderMasters();
    OrderMaster getOrderMasterById(int id);
    OrderMaster insertOrderMaster(OrderMaster orderMaster);
    OrderMaster updateOrderMaster(OrderMaster orderMaster);
    int deleteOrderMaster(int id);
}
