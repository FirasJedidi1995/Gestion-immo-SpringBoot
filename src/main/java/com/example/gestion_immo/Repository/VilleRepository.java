package com.example.gestion_immo.Repository;


import com.example.gestion_immo.Entities.Region;
import com.example.gestion_immo.Entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville,Long> {

    @Query("SELECT v.region_id FROM Ville v WHERE v.id = :villeId")
    Region findRegionByVilleId(@Param("villeId") Long villeId);
}