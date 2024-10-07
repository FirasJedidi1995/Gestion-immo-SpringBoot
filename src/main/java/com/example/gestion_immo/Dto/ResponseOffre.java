package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Offre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOffre {
    Long id;
    String offre;

    public static ResponseOffre makeOffre(Offre offre){
        return ResponseOffre.builder()
                .id(offre.getId())
                .offre(offre.getOffre())

                .build();
    }

}
