package com.product.product_management;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int categId;

	    @Column(nullable = false, unique = true)
	    private String categName;

	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<Product> products;
	    
	    public Category() {
			// TODO Auto-generated constructor stub
		}

		public Category(int categId, String categName, List<Product> products) {
			super();
			this.categId = categId;
			this.categName = categName;
			this.products = products;
		}

		public int getCategId() {
			return categId;
		}

		public void setCategId(int categId) {
			this.categId = categId;
		}

		public String getCategName() {
			return categName;
		}

		public void setCategName(String categName) {
			this.categName = categName;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}
	    
	    	    


}
