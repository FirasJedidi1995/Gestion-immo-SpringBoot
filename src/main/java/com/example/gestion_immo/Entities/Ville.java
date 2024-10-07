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
@Table(name = "ville")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomVille;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private  Instant updatedAt;
    private  Long region_id;
    @OneToMany(mappedBy = "ville")
    private List<Annonce> annonces;
}
