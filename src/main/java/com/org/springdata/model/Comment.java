package com.org.springdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@ToString
@Table(name = "commentaire")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentaire_id")
    private int commentId;
    @Column(name = "contenu")
    private String content;
    @Column(name = "produit_id")
    private int product_id;
}
