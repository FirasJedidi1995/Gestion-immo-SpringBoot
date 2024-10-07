package com.example.gestion_immo.Controller;

import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Dto.ResponseUser;
import com.example.gestion_immo.Entities.User;
import com.example.gestion_immo.Service.AnnonceService;
import com.example.gestion_immo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ADMIN')")
//@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnnonceService annonceService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseUser>> getUsersWithRoleUser() {
        List<ResponseUser> users = userService.findUsersWithRoleUser();
        return ResponseEntity.ok(users);
    }


    @DeleteMapping(value="{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public  ResponseEntity<Object> deleteUser(@PathVariable Long id){
        boolean deleteUser= userService.deleteUser(id);
        if(deleteUser) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "delete success !!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message","user not exist"));

    }


}
