package com.example.gestion_immo.Repository;


import com.example.gestion_immo.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
