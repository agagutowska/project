package com.example.pantry.model;


import jakarta.persistence.*;

@Entity
public class ShoppingListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_list_Id")
    private Long shoppingListId;

    private String name;







}
