package com.example.pantry.repository;

import com.example.pantry.model.ShoppingListModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListModel, Long> {
    Page<ShoppingListModel> findAll(Pageable pageable);

}
