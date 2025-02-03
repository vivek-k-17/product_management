package com.product.product_management;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getAllCategories(Pageable p) {
        return categoryRepository.findAll(p);
    }

    public Optional<Category> getCategoryById(int categId) {
        return categoryRepository.findById(categId);
    }

    public Category createCategory(Category c1) {
        return categoryRepository.save(c1);
    }

    
    public Category updateCategory(int categId, Category categoryDetails) {
        Optional<Category> oc = categoryRepository.findById(categId);

        if (oc.isPresent()) {
            Category c1 = oc.get();
            c1.setCategName(categoryDetails.getCategName()); 
            return categoryRepository.save(c1);
        }

        return null; 
    }


    public void deleteCategory(int categId) {
        categoryRepository.deleteById(categId);
    }
}



//public Category updateCategory(int categId, Category categoryDetails) {
//return categoryRepository.findById(categId).map(category -> {
//  category.setCategName(categoryDetails.getCategName());
//  return categoryRepository.save(category);
//}).orElseThrow(() -> new RuntimeException("Category not found"));
//}
