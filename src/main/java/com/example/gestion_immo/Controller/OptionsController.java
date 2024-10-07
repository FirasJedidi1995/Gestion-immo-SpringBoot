package com.example.gestion_immo.Controller;


import com.example.gestion_immo.Dto.RequestOptions;
import com.example.gestion_immo.Dto.ResponseOptions;
import com.example.gestion_immo.Service.OptionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/options")
@RequiredArgsConstructor
public class OptionsController {
    @Autowired
    private OptionsService optionsService;

    @PostMapping()
    public ResponseEntity<Object> createOption(@RequestBody @Valid RequestOptions request){
        optionsService.createOption(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }

    @GetMapping()
    public ResponseEntity<List<ResponseOptions>> getAllOptions(){
        List<ResponseOptions> options=optionsService.getAllOptions();
        return ResponseEntity.ok(options);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteOption(@PathVariable Long id){
        boolean deleteOption=optionsService.deleteOption(id);
        if (deleteOption){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message","Option Not Exist"));
    }

}
