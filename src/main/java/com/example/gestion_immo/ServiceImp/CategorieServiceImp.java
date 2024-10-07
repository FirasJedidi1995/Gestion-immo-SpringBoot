package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestCategorie;
import com.example.gestion_immo.Dto.ResponseCategorie;
import com.example.gestion_immo.Entities.Categorie;
import com.example.gestion_immo.Repository.CategorieRepository;
import com.example.gestion_immo.Service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategorieServiceImp implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<ResponseCategorie> getAllCategories() {
        List<Categorie> categories=categorieRepository.findAll();
        List<ResponseCategorie> categorieList=new ArrayList<>();
        for (Categorie categorie : categories){
            ResponseCategorie categorieL=ResponseCategorie.makeCategorie(categorie);
            categorieList.add(categorieL);

        }

        return categorieList;
    }

    @Override
    public void createCategorie(RequestCategorie requestCategorie) {
        Categorie categorie=Categorie.builder()
                .labelle(requestCategorie.getLabelle())
                .build();
        categorieRepository.save(categorie);

    }

    @Override
    public boolean deleteCategorie(Long id) {
        if (!categorieRepository.existsById(id)){
            return false;
        }
        categorieRepository.deleteById(id);
        return true;
    }
}
