package com.esprit.microservices.post.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String Subject;
    private String  Commentaire;
    @ManyToOne
    Review review;

}
