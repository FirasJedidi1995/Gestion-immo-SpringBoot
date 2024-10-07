package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.RequestAnnonce;
import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Service.AnnonceService;
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
@RequestMapping("api/annonce")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseAnnonce>> getAllAnnonces(){
        List<ResponseAnnonce> annonces =annonceService.getAllAnnonces();
        return ResponseEntity.ok(annonces);
    }

//    @GetMapping
//    @PreAuthorize("hasAuthority('admin:read')")
//    public ResponseEntity<List<ResponseAnnonce>> getAllAnnonces(){
//        List<ResponseAnnonce> annonces =annonceService.getAllAnnonces();
//        return ResponseEntity.ok(annonces);
//    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> createAnnonce (@RequestBody @Valid RequestAnnonce request){
        annonceService.createAnnonce(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }
    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseAnnonce>> getAnnoncesByUser(@PathVariable Long userId) {
        List<ResponseAnnonce> annonces = annonceService.getUserAnnonces(userId);
        if (annonces.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(annonces);
    }
}
