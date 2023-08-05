package com.example.pantry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pantry.model.ShoppingListModel;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListModel, Long> {

}
