package com.example.pantry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ShoppingItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_item_id")
    private Long shoppingItemId;

    @Column(name = "name")
    private String itemName;

    @Column(name = "quantity")
    private Integer itemQuantity;

//    @Column(name = "basket")
//    boolean basket;

//    @Column(name = "destination")
//    private String destination;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private ProductModel product;


}
