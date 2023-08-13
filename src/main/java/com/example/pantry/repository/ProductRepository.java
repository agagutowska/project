package com.example.pantry.repository;

import com.example.pantry.model.ProductModel;
import com.example.pantry.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByShelf(ShelfModel shelf, Sort sort);

}
