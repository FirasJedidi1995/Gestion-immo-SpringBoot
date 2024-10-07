package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestOffre;
import com.example.gestion_immo.Dto.ResponseOffre;
import com.example.gestion_immo.Entities.Offre;
import com.example.gestion_immo.Repository.OffreRepository;
import com.example.gestion_immo.Service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreServiceImp implements OffreService {

    @Autowired
    private OffreRepository offreRepository;
    @Override
    public List<ResponseOffre> getAllOffres() {
        List<Offre> offres=offreRepository.findAll();
        List<ResponseOffre> offreFormated=new ArrayList<>();
        for (Offre offre:offres){
            ResponseOffre offreF=ResponseOffre.makeOffre(offre);
            offreFormated.add(offreF);
        }

        return offreFormated;
    }

    @Override
    public void createOffre(RequestOffre requestOffre) {

        Offre offre=Offre.builder()
                .offre(requestOffre.getOffre())

                .build();
        offreRepository.save(offre);
    }

    @Override
    public boolean deleteOffre(Long id) {

        if(!offreRepository.existsById(id)){
            return false;
        }
        offreRepository.deleteById(id);
        return true;
    }
}
