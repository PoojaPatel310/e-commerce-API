package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.Service;

import java.util.List;

public interface ServiceService {

    List<Service> listAllService();
    Service getServiceById(int id);
    Service insertService(Service service);
    Service updateService(Service service);
    int deleteService(int id);

}
