package com.example.ecommercerestapi.service;



import com.example.ecommercerestapi.entity.Brand;
import com.example.ecommercerestapi.entity.Category;
import com.example.ecommercerestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    List<Product> getProductByCategory(Category category);
    List<Product> getProductByBrand(Brand brand);
    Product getProductById(int id);
    Product insertProduct(Product product);
    Product updateProduct(Product product);
    int deleteProduct(int id);
}
