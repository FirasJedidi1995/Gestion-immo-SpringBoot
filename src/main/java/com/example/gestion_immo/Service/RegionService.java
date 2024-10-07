package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Entities.Region;

import java.util.List;

public interface RegionService {

    List<ResponseRegion> getAllRegion();
    void createRegion(RequestRegion requestRegion);

    boolean DeleteRegion(Long id);


}
