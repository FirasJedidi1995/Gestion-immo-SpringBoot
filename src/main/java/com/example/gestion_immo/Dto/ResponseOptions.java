package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Categorie;
import com.example.gestion_immo.Entities.Options;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOptions {
    Long id;
    String Labelle;



    public static ResponseOptions makeOptions (Options option){
        return  ResponseOptions.builder()
                .id(option.getId())
                .Labelle(option.getLabelle())

                .build();
    }

}
