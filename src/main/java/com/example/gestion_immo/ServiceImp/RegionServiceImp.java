package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Entities.Region;
import com.example.gestion_immo.Entities.Ville;
import com.example.gestion_immo.Repository.RegionRepository;
import com.example.gestion_immo.Repository.VilleRepository;
import com.example.gestion_immo.Service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RegionServiceImp implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<ResponseRegion> getAllRegion() {
        List<Region> regions=regionRepository.findAll();
        List<ResponseRegion> regionFormated=new ArrayList<>();
        for (Region region:regions){
            ResponseRegion regionF=ResponseRegion.makeRegion(region);
            regionFormated.add(regionF);

        }
        return regionFormated;
    }

    @Override
    public void createRegion(RequestRegion requestRegion) {
        Region region=Region.builder()
                .nomRegion(requestRegion.getNomRegion())


                .build();
        regionRepository.save(region);
    }

    @Override
    public boolean DeleteRegion(Long id) {
        if(!regionRepository.existsById(id)){
            return false;
        }
        regionRepository.deleteById(id);
        return true;
    }
}
