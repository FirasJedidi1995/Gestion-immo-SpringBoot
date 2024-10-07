package com.example.gestion_immo.Controller;


import com.example.gestion_immo.Dto.RequestOffre;
import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseOffre;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Service.OffreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/offre")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class OffreController {

    @Autowired
    private OffreService offreService;

    @PostMapping()
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> createOffre(@RequestBody @Valid RequestOffre request){
        offreService.createOffre(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseOffre>> getAllOffres(){
        List<ResponseOffre> offres=offreService.getAllOffres();
        return ResponseEntity.ok(offres);
    }

    @DeleteMapping(value="{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public  ResponseEntity<Object> deleteOffre(@PathVariable Long id){
        boolean deleteOffre= offreService.deleteOffre(id);
        if(deleteOffre) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message","Offre not exist"));

    }
}
