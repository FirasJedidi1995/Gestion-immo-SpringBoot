package com.example.gestion_immo.Repository;


import com.example.gestion_immo.Entities.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photos,Long> {
}
