package com.example.pantry.repository;

import com.example.pantry.model.ShelfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfModel, Long> {

}
