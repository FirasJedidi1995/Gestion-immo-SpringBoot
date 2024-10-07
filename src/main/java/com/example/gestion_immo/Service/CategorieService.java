package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestCategorie;
import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseCategorie;
import com.example.gestion_immo.Dto.ResponseRegion;

import java.util.List;

public interface CategorieService {
    List<ResponseCategorie> getAllCategories();
    void createCategorie(RequestCategorie requestCategorie);

    boolean deleteCategorie(Long id);

}
