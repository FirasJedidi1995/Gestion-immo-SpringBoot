package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestAnnonce;
import com.example.gestion_immo.Dto.RequestCategorie;
import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Dto.ResponseCategorie;
import com.example.gestion_immo.Entities.Annonce;

import java.util.List;

public interface AnnonceService {

    List<ResponseAnnonce> getAllAnnonces();
    void createAnnonce(RequestAnnonce requestAnnonce);

    boolean deleteAnnonce(Long id);

    List<ResponseAnnonce> getUserAnnonces(Long userId);

}
