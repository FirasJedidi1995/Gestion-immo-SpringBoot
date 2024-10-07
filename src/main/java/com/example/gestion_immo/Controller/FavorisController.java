package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Entities.Annonce;
import com.example.gestion_immo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("/api/users/{userId}/favoris")
@RequestMapping("/api/favoris")
@PreAuthorize("hasRole('ADMIN')")
public class FavorisController {

    @Autowired
    private UserService userService;

    @PostMapping("{userId}/{annonceId}")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> addFavoris(@PathVariable Long userId, @PathVariable Long annonceId) {
        userService.addFavoris(userId, annonceId);
       // return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }

    @DeleteMapping("/{userId}/{annonceId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> removeFavoris(@PathVariable Long userId, @PathVariable Long annonceId) {
        userService.removeFavoris(userId, annonceId);
       // return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "delete success !!"));
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseAnnonce>> getFavorisAnnonce(@PathVariable Long userId) {
        List<ResponseAnnonce> favoris = userService.getFavorisAnnonce(userId);
        return ResponseEntity.ok(favoris);
    }



}
