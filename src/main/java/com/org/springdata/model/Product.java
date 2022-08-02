package com.org.springdata.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@DynamicUpdate
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

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL

    )

    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(
            mappedBy = "products"
    )
    private List<Category> categories = new ArrayList<>();

    //Méthodes utilitaires
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setProduct(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setProduct(null);
    }


}
