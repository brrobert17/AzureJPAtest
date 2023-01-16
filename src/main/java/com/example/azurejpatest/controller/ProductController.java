package com.example.azurejpatest.controller;

import com.example.azurejpatest.entity.Product;
import com.example.azurejpatest.service.ProductService;
import com.example.azurejpatest.service.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping
    public List<Product> getAll (){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.getById(id);
    }

    @GetMapping(params = "name")
    public Product getByName(@RequestParam String name) throws ProductNotFoundException {
        return productService.getByName(name);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.update(id, product);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id) throws ProductNotFoundException {
        productService.del(id);
    }

}

