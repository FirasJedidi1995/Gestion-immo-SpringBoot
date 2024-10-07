package com.example.gestion_immo.auth;


import com.example.gestion_immo.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
     String firstname;
     String lastname;
     int phone_number;

     String email;

     String password;

   // private Role role;

}
