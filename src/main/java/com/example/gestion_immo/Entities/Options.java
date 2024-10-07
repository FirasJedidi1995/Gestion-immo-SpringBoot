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
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelle;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private  Instant updatedAt;



//    //liaison de la classe options avec categorie
   @ManyToMany(mappedBy = "options")
   private List<Categorie>categories;
}
