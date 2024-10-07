package com.example.gestion_immo;

import com.example.gestion_immo.Entities.Role;
import com.example.gestion_immo.auth.AuthenticationService;
import com.example.gestion_immo.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//import static com.example.gestion_immo.Entities.Role.ADMIN;
import static com.example.gestion_immo.Entities.Role.Admin;

@SpringBootApplication
public class GestionImmoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionImmoApplication.class, args);
    }







//    @Bean
//    public CommandLineRunner commandLineRunner(AuthenticationService service){
//        return args -> {
//            String adminEmail = "admin@gmail.com";
//            if (!service.existsByEmail(adminEmail)) {
//                var admin = RegisterRequest.builder()
//                        .firstname("Admin")
//                        .lastname("Admin")
//                        .email(adminEmail)
//                        .password("password")
//                        .phone_number(93122649)
//
//
//                        .role(Admin)
//                        .build();
//                System.out.println("Admin token: " + service.register(admin));
//            } else {
//                System.out.println("Existing admin token: " + service.getTokenForExistingUser(adminEmail));
//            }
//        };
//    }
//
}
