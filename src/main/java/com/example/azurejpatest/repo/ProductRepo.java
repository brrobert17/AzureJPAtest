package com.example.azurejpatest.repo;

import com.example.azurejpatest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);
}
