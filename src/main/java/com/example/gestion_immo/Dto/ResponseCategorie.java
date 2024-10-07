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
public class ResponseCategorie {
    Long id;
    String labelle;
    List<ResponseOptions> options;
//    Instant createdAt;
//    Instant updatedAt;

    public static ResponseCategorie makeCategorie (Categorie categorie){
        return  ResponseCategorie.builder()
                .id(categorie.getId())
                .labelle(categorie.getLabelle())
//                .createdAt(categorie.getCreatedAt())
//                .updatedAt(categorie.getUpdatedAt())
                .options(categorie.getOptions()
                        .stream()
                        .map(ResponseOptions::makeOptions)
                        .collect(Collectors.toList()))
                .build();
    }
}
