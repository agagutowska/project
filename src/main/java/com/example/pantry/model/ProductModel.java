package com.example.pantry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    //komit
    @Column(name = "product_name")
    private String productName;

    //komit
    @Column(name = "quantity")
    private Integer quantityOfProduct;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "status")
    private String statusOfProduct;


//    @ManyToOne //do shelves
@ManyToOne
@JoinColumn(name = "shelf_id") // Nazwa kolumny reprezentującej klucz obcy
private ShelfModel shelf;

}
