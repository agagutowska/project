package com.example.pantry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantityOfProduct;

    @Column(name = "expiry_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd");
    private LocalDate expiryDate;

    @Column(name = "status")
    private String statusOfProduct;


//    @ManyToOne //do shelves




}
