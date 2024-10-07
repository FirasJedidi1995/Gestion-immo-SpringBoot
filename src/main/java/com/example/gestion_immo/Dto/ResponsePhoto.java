package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.Photos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePhoto {
    Long id;
    Long annonceId;
    String photoUri;
    ResponseAnnonce annonce;
    Instant createdAt;
    Instant updatedAt;

    public static ResponsePhoto makePhoto(Photos photo, String baseUrl){
        String photoUri=baseUrl+"/photos/"+photo.getId();
        return ResponsePhoto.builder()
                .id(photo.getId())
                .photoUri(photoUri)
                .annonce(ResponseAnnonce.makeAnnonce(photo.getAnnonce()))
                .createdAt(photo.getCreatedAt())
                .updatedAt(photo.getUpdatedAt())
                .build();
    }
}
