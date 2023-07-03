package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.CompanyDetail;
import com.example.ecommercerestapi.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company-detail")
public class CompanyDetailController {
    @Autowired
    private CompanyDetailService companyDetailService;

    public CompanyDetailController(CompanyDetailService companyDetailService) {
        this.companyDetailService = companyDetailService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDetail>> listAll(){
        List<CompanyDetail> companyDetails = companyDetailService.listAllCompanyDetail();
        return new ResponseEntity<>(companyDetails, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyDetail> getCompanyDetailById(@PathVariable("id") int id){
        CompanyDetail companyDetail = companyDetailService.getCompanyDetailById(id);
        return new ResponseEntity<>(companyDetail,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDetail> insert(@RequestBody CompanyDetail companyDetail){
        CompanyDetail savedCompanyDetail = companyDetailService.insertCompanyDetail(companyDetail);
        return new ResponseEntity<>(savedCompanyDetail,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompanyDetail> update(@PathVariable("id") int id,
                                                @RequestBody CompanyDetail companyDetail){
        companyDetail.setId(id);
        CompanyDetail updatedCompanyDetail = companyDetailService.updateCompanyDetail(companyDetail);
        return new ResponseEntity<>(updatedCompanyDetail,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        companyDetailService.deleteCompanyDetail(id);
        return new ResponseEntity<>("Company Detail Deleted",HttpStatus.OK);
    }
}
