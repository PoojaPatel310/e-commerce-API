package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.Service;
import com.example.ecommercerestapi.repository.ServiceRepository;
import com.example.ecommercerestapi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository repository;
    @Override
    public List<Service> listAllService() {
        return repository.findAll();
    }

    @Override
    public Service getServiceById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Service insertService(Service service) {
        return repository.save(service);
    }

    @Override
    public Service updateService(Service service) {
        return repository.save(service);
    }

    @Override
    public int deleteService(int id) {
        repository.deleteById(id);
        return id;
    }
}
