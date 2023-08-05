package com.example.pantry.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShelfModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelf_id")
    private Long shelfId;

    @Column(name = "shelf_name")
    private String shelfName;


    //    @OneToMany //do products
    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL)
    private List<ProductModel> products;

    @Override
    public String toString() {
        return "ShelfModel{" +
                "shelfId=" + shelfId +
                ", shelfName='" + shelfName + '\'' +
                '}';
    }
}
