package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAuthority('admin:create')")
    @Operation(summary = "Upload an image file")


    public ResponseEntity<String> uploadImage(
            @Parameter(description = "File to upload", required = true, content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE, schema = @Schema(type = "string", format = "binary")))
            @RequestPart("image") MultipartFile file) {

        try {
            String uploadImage = imageService.uploadImage(file);
            return new ResponseEntity<>(uploadImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading image: " + e.getMessage());
        }
    }

    @GetMapping("/download/{fileName:.+}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] imageData = imageService.downloadImage(fileName);
        if (imageData == null || imageData.length == 0) {
            return ResponseEntity.notFound().build();
        }


        MediaType mediaType = MediaType.IMAGE_PNG;

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(imageData);
    }
}
