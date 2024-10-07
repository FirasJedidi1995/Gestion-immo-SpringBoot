package com.example.gestion_immo.Repository;


import com.example.gestion_immo.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {
}
