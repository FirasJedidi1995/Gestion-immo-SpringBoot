package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestOptions;
import com.example.gestion_immo.Dto.ResponseOptions;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Entities.Categorie;
import com.example.gestion_immo.Entities.Options;
import com.example.gestion_immo.Entities.Region;
import com.example.gestion_immo.Repository.CategorieRepository;
import com.example.gestion_immo.Repository.OptionsRepository;
import com.example.gestion_immo.Service.OptionsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionsServiceImp implements OptionsService {
    @Autowired
    OptionsRepository optionsRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public List<ResponseOptions> getAllOptions() {
        List<Options> options=optionsRepository.findAll();
        List<ResponseOptions> optionsFormated=new ArrayList<>();
        for (Options option : options){
            ResponseOptions optionF=ResponseOptions.makeOptions(option);
            optionsFormated.add(optionF);
        }

        return optionsFormated;
    }

    @Override
    @Transactional
    public void createOption(RequestOptions requestOptions) {
    List<Categorie> categories=categorieRepository.findAllById(requestOptions.getCategorieId());
        Options option=Options.builder()
                .labelle(requestOptions.getLabelle())
                .build();
        option.setCategories(categories);
        optionsRepository.save(option);
        categories.forEach(categorie -> categorie.getOptions().add(option));
        categorieRepository.saveAll(categories);

    }

    @Override
    public boolean deleteOption(Long id) {
        if (!optionsRepository.existsById(id)){
            return false;
        }
        optionsRepository.deleteById(id);
        return true;

    }
}
