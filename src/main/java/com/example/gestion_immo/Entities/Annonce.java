package com.example.gestion_immo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.InputStream;
import java.sql.Blob;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String offre;
    private String titre;
    private String description;
    private String adresse;
    private double prix;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private  Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville ville;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offre_id")
    private Offre offre;


    @ManyToMany(mappedBy = "annoncesFavorites")
    private Set<User> favoritedByUsers = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany
//    private List<Image> images;


//    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Photos> photos=new ArrayList<>();




    //liéé annonce avec ville
//    @ManyToOne
//    @JoinColumn(name = "ville_id", nullable = false)
//    private Ville ville;





}
