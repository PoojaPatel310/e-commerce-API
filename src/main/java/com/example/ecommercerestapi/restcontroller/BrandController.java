package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.Brand;
import com.example.ecommercerestapi.service.BrandService;
import com.example.ecommercerestapi.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private BrandService brandService;
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<String> insertBrand(@ModelAttribute Brand brand, @RequestParam("photo1") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.length() > 3) {
            brand.setLogo(fileName);
            Brand savedBrand = brandService.insertBrand(brand);
            String uploadDir = "brand-logo/" + savedBrand.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            brand.setLogo("noming.png");
            Brand savedBrand = brandService.insertBrand(brand);
        }
        return ResponseEntity.ok("Brand saved successfully");
    }

//    @PostMapping
//    public ResponseEntity<Brand> insertBrand(@RequestBody Brand brand){
//        Brand SavedBrand = brandService.insertBrand(brand);
//        return new ResponseEntity<>(SavedBrand, HttpStatus.CREATED);
//    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") int id){
        Brand brand = brandService.getBrandById(id);
        return new ResponseEntity<>(brand,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> brandList(){
        List<Brand> brands = brandService.listAllBrand();
        return new ResponseEntity<>(brands,HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<String> updateBrand(@PathVariable("id") int id, @ModelAttribute Brand brand, @RequestParam("photo1") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.length() > 3) {
            brand.setLogo(fileName);
            Brand savedBrand = brandService.updateBrand(brand);
            String uploadDir = "brand-logo/" + savedBrand.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            Brand savedBrand = brandService.updateBrand(brand);
        }
        return ResponseEntity.ok("Brand update successfully");
    }
//    @PutMapping("{id}")
//    public ResponseEntity<Brand> updateBrand(@PathVariable("id") int id,@RequestBody Brand brand){
//        Brand brand1 = brandService.updateBrand(brand);
//
//        return new ResponseEntity<>(brand1,HttpStatus.OK);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") int id){
        brandService.deleteBrand(id);
        return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
    }

}
