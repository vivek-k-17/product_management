package com.product.product_management;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @GetMapping    //retrive paginated list of category
    public Page<Category> getAllCategories(Pageable p) {  //return data from paginated format
        return cs.getAllCategories(p);  //fetch category with pagination from database
    }

    @GetMapping("/{categId}")
    public Optional<Category> getCategoryById(@PathVariable int categId) { //If the category exists, it returns the category object.
    																		//If not found, it returns empty (avoiding NullPointerException).
    	return cs.getCategoryById(categId);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category c1) {
        return cs.createCategory(c1);
    }

    @PutMapping("/{categId}")
    public Category updateCategory(@PathVariable int categId, @RequestBody Category c1) {
        return cs.updateCategory(categId, c1);
    }

    @DeleteMapping("/{categId}")
    public void deleteCategory(@PathVariable int categId) {
        cs.deleteCategory(categId);
    }
}