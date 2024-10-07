package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Region;
import com.example.gestion_immo.Entities.Ville;
import com.example.gestion_immo.Repository.VilleRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseVille {
    Long id;
    String nomVille;








    public static    ResponseVille makeVille(Ville ville) {

        return ResponseVille.builder()
                .id(ville.getId())
                .nomVille(ville.getNomVille())

                .build();
    }
}
