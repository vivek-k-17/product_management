package com.product.product_management;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    
    public Page<Product> getAllProducts(Pageable p) {
        return productRepository.findAll(p);
    }


    public Optional<Product> getProductById(int productId) {
        return productRepository.findById(productId);
    }


    public Product createProduct(Product p1, int categId) {
        Optional<Category> oc = categoryRepository.findById(categId);

        if (oc.isPresent()) {
            p1.setCategory(oc.get());
            return productRepository.save(p1);
        }

        return null; 
    }

    
    public Product updateProduct(int productId, Product productDetails) {
    	Product  op = productRepository.findById(productId).orElse(null);
        
        if (op!=null) {
            op.setProductName(productDetails.getProductName());
            op.setPrice(productDetails.getPrice());
            return productRepository.save(op);
        }
        
        return null; 
    }


    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

	
}


//public Product createProduct(Product p1, int categoryId) {
//Category c = categoryRepository.findById(categoryId)
//      .orElseThrow(() -> new RuntimeException("Category not found"));
//p1.setCategory(c);
//return productRepository.save(p1);
//}




//public Product updateProduct(int productId, Product productDetails) {
//return productRepository.findById(productId).map(product -> {
//  product.setProductName(productDetails.getProductName());
//  product.setPrice(productDetails.getPrice());
//  product.setCategory(productDetails.getCategory());
//  return productRepository.save(product);
//}).orElseThrow(() -> new RuntimeException("Product not found"));
//}