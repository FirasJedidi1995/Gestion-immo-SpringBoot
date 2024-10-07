package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.RequestCategorie;
import com.example.gestion_immo.Dto.RequestOptions;
import com.example.gestion_immo.Dto.ResponseCategorie;
import com.example.gestion_immo.Dto.ResponseOptions;

import java.util.List;

public interface OptionsService {

    List<ResponseOptions> getAllOptions();
    void createOption(RequestOptions requestOptions);

    boolean deleteOption(Long id);
}
