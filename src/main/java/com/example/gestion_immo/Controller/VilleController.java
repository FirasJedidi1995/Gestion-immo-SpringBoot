package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.RequestVille;
import com.example.gestion_immo.Dto.ResponseVille;
import com.example.gestion_immo.Service.VilleService;
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
@RequestMapping("api/ville")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class VilleController {
    @Autowired
    private VilleService villeService;

    @PostMapping()
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> addVille(@RequestBody @Valid RequestVille request){
        villeService.createVille(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }
    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseVille>> getAllVilles(){
        List<ResponseVille> villes =villeService.getAllVilles();
        return ResponseEntity.ok(villes);
    }
    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Object> deleteVille (@PathVariable Long id){

        boolean deletedVille =  villeService.deleteVille(id);
        if(deletedVille) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!"));
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "ville not exist"));
    }
}
