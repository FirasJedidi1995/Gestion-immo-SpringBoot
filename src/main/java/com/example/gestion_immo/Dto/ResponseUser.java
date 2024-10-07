package com.example.gestion_immo.Dto;

import com.example.gestion_immo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private Long id;
    private String firstname;
    private String lastname;
    private int phone_number;
    private String email;


    public static ResponseUser makeUser(User user) {
        return ResponseUser.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .phone_number(user.getPhone_number())

                .build();
    }
}
