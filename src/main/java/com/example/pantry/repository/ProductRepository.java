package com.example.pantry.repository;

import com.example.pantry.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Page<ProductModel>findAll(Pageable pageable);
}
