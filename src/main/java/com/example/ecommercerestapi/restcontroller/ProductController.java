package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.Product;
import com.example.ecommercerestapi.service.BrandService;
import com.example.ecommercerestapi.service.CategoryService;
import com.example.ecommercerestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    public ProductController(ProductService productService, CategoryService categoryService, BrandService brandService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAll(){
        List<Product> products = productService.listAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product){
        Product savedProducd = productService.insertProduct(product);
        return new ResponseEntity<>(savedProducd,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id,
                                          @RequestBody Product product){
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted Successfully",HttpStatus.OK);
    }

}
