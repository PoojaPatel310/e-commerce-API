package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.Brand;
import com.example.ecommercerestapi.repository.BrandRepository;
import com.example.ecommercerestapi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository repository;

    @Override
    public List<Brand> listAllBrand() {
        return repository.findAll();
    }

    @Override
    public Brand getBrandById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Brand insertBrand(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public int deleteBrand(int id) {
        repository.deleteById(id);
        return id;
    }
}
