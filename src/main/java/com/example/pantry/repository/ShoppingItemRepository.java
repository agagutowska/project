package com.example.pantry.repository;

import com.example.pantry.model.ShoppingItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItemModel, Long> {
    Page<ShoppingItemModel> findAll(Pageable pageable);

}
