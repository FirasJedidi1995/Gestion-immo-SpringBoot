package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.RequestRegion;
import com.example.gestion_immo.Dto.ResponseRegion;
import com.example.gestion_immo.Service.RegionService;
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
@RequestMapping("api/region")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping()
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Object> createRegion(@RequestBody @Valid RequestRegion request){
        regionService.createRegion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }
    @GetMapping()
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseRegion>> getAllRegions(){
        List<ResponseRegion> regions=regionService.getAllRegion();
        return ResponseEntity.ok(regions);
    }
    @DeleteMapping(value="{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public  ResponseEntity<Object> deleteRegion(@PathVariable Long id){
        boolean deleteRegion= regionService.DeleteRegion(id);
        if(deleteRegion) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message","Region not exist"));

    }

}
