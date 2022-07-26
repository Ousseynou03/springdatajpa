package com.org.springdata.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

@Table(name = "produit")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private int productId;

    @Column(name = "nom")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cout")
    private int cost;

}
