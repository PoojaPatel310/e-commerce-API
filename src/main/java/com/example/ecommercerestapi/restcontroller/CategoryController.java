package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.Category;
import com.example.ecommercerestapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAll(){
        List<Category> categories = categoryService.listAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category){
      Category savedCategory = categoryService.insertCategory(category);
      return  new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id,
                                           @RequestBody Category category){
        category.setId(id);
        Category updatedCategory = categoryService.updateCategory(category);
        return  new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category deleted Successfully",HttpStatus.OK);
    }
}
