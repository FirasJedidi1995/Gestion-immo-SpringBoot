package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.RequestCategorie;
import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseCategorie;
import com.example.gestion_immo.Service.CategorieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/categorie")
@RequiredArgsConstructor
public class CategorieController {

    @Autowired
    CategorieService categorieService;
    @PostMapping()
    public ResponseEntity<Object> createCategorie(@RequestBody @Valid RequestCategorie request){
        categorieService.createCategorie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCategorie>> getAllCategories(){
        List<ResponseCategorie> categories =categorieService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteCategorie(@PathVariable Long id){
        boolean deleteCategorie=categorieService.deleteCategorie(id);
        if (deleteCategorie){
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","delete success !!"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message","Categorie Not Exist"));
    }

}
