package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.CompanyDetail;

import java.util.List;

public interface CompanyDetailService {
    
    List<CompanyDetail> listAllCompanyDetail();
    CompanyDetail getCompanyDetailById(int id);
    CompanyDetail insertCompanyDetail(CompanyDetail companyDetail);
    CompanyDetail updateCompanyDetail(CompanyDetail companyDetail);
    int deleteCompanyDetail(int id);
    
}
