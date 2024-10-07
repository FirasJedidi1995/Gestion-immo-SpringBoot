package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRegion {
    Long id;
    String nomRegion;
    List<ResponseVille> villes;

    public static ResponseRegion makeRegion(Region region) {


        return ResponseRegion.builder()
                .id(region.getId())
                .nomRegion(region.getNomRegion())
                .villes(region.getVilles()
                        .stream()
                        .map(ResponseVille::makeVille)
                        .collect(Collectors.toList()))
                .build();
    }
}
