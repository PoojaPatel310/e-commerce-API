package com.example.ecommercerestapi.serviceimpl;

import com.example.ecommercerestapi.entity.CompanyDetail;
import com.example.ecommercerestapi.repository.CompanyDetailRepository;
import com.example.ecommercerestapi.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {
    @Autowired
    CompanyDetailRepository repository;

    @Override
    public List<CompanyDetail> listAllCompanyDetail() {
        return repository.findAll();
    }

    @Override
    public CompanyDetail getCompanyDetailById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public CompanyDetail insertCompanyDetail(CompanyDetail companyDetail) {
        return repository.save(companyDetail);
    }

    @Override
    public CompanyDetail updateCompanyDetail(CompanyDetail companyDetail) {
        return repository.save(companyDetail);
    }

    @Override
    public int deleteCompanyDetail(int id) {
        repository.deleteById(id);
        return id;
    }
}
