package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private Date dateComment;
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;



}
