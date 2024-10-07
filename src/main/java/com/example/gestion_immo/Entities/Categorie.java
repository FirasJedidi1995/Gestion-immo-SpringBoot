package com.example.gestion_immo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@ToString
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelle;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private  Instant updatedAt;






    @OneToMany(mappedBy = "categorie")
    private List<Annonce> annonces;



    @ManyToMany
    @JoinTable(
            name = "categorie_option",
            joinColumns = @JoinColumn(name = "categorie_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Options> options;




}
