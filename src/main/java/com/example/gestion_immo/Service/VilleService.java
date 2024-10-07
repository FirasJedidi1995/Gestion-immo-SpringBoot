package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestVille;
import com.example.gestion_immo.Dto.ResponseVille;

import java.util.List;
import java.util.Set;

public interface VilleService {
    List<ResponseVille> getAllVilles();
    void createVille(RequestVille villeRequest);
    boolean deleteVille(Long id);



}
