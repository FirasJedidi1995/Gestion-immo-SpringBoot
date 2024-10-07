package com.example.gestion_immo.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAnnonce {
     Long offreId;
     String titre;
     String description;
     String adresse;
     double prix;
     Long categorieId;
     Long villeId;
     Long UserId;
     //List<Long> imageId;
     //Long regionId;

     //Long clientId;

}
