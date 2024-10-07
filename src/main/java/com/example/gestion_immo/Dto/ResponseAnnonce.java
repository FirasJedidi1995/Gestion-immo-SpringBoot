package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Annonce;
import com.example.gestion_immo.Entities.Categorie;
import com.example.gestion_immo.Entities.User;
import com.example.gestion_immo.Entities.Ville;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAnnonce {
     Long id;
     ResponseOffre offre;
     String titre;
     String description;
     String adresse;
     double prix;
     ResponseCategorie categorie;
     ResponseVille ville;


    public static ResponseAnnonce makeAnnonce(Annonce annonce){

       return ResponseAnnonce.builder()
               .id(annonce.getId())
               .offre(ResponseOffre.makeOffre(annonce.getOffre()))
               .titre(annonce.getTitre())
               .description(annonce.getDescription())
               .adresse(annonce.getAdresse())
               .prix(annonce.getPrix())
               .ville(ResponseVille.makeVille(annonce.getVille()))
               .categorie(ResponseCategorie.makeCategorie(annonce.getCategorie()))

               .build();
    }
}
