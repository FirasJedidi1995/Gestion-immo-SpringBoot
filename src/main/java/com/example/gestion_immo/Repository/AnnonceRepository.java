package com.example.gestion_immo.Repository;

import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Entities.Annonce;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    List<ResponseAnnonce> findByUserId(Long userId);
}
