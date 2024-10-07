package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestOffre;
import com.example.gestion_immo.Dto.RequestOptions;
import com.example.gestion_immo.Dto.ResponseOffre;

import java.util.List;

public interface OffreService {

    List<ResponseOffre> getAllOffres();
    void createOffre(RequestOffre requestOffre);
    boolean deleteOffre(Long id);
}
