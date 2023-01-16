package com.example.azurejpatest.service;

import com.example.azurejpatest.entity.Product;
import com.example.azurejpatest.repo.ProductRepo;
import com.example.azurejpatest.service.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    final ProductRepo productRepo;


    public Product create(Product product) {
        return productRepo.save(product);
    }

    public Product getById(Integer id) throws ProductNotFoundException {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found by id: " + id));
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product update(Integer id, Product product) throws ProductNotFoundException {
        productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found by id: " + id));

        return productRepo.save(product);
    }

    public void del(Integer id) throws ProductNotFoundException {
        productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found by id: " + id));
        productRepo.deleteById(id);
    }

    public Product getByName(String name) throws ProductNotFoundException {
        return productRepo.findByName(name).orElseThrow(() -> new ProductNotFoundException("product not found by name: " + name));
    }
}

