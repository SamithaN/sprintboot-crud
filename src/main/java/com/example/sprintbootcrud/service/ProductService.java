package com.example.sprintbootcrud.service;

import com.example.sprintbootcrud.entity.Product;
import com.example.sprintbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   @Autowired
   private ProductRepository repository;

   public Product saveProduct(Product product){
       return repository.save(product);
   }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
       return repository.findAll();
    }

    public Product getProduct(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProduct(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !! "+id;
    }

    public Product updateProduct(Product product){
        Product existProduct = repository.findById(product.getId()).orElse(null);
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        return repository.save(existProduct);
    }

}
