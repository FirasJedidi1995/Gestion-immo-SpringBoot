package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestVille;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Dto.ResponseVille;
import com.example.gestion_immo.Entities.Ville;
import com.example.gestion_immo.Repository.VilleRepository;
import com.example.gestion_immo.Service.RegionService;
import com.example.gestion_immo.Service.VilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@RequiredArgsConstructor
@Service
public class VilleServiceImp implements VilleService {

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public List<ResponseVille> getAllVilles() {
        List<Ville> villes=villeRepository.findAll();
        List<ResponseVille> villeFormated=new ArrayList<>();
        for (Ville ville:villes){
            ResponseVille villeF=ResponseVille.makeVille(ville);
            villeFormated.add(villeF);
        }
        return villeFormated;
    }

    @Override
    public void createVille(RequestVille villeRequest) {
        Ville ville=Ville.builder()
                .nomVille(villeRequest.getNomVille())
                .region_id(villeRequest.getRegion_id())
                .build();
        villeRepository.save(ville);

    }

    @Override
    public boolean deleteVille(Long id) {
        if (!villeRepository.existsById(id)){
            return false;
        }
        villeRepository.deleteById(id);
        return true;
    }
}
