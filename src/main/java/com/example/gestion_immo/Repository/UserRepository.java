package com.example.gestion_immo.Repository;


import com.example.gestion_immo.Dto.ResponseUser;
import com.example.gestion_immo.Entities.Role;
import com.example.gestion_immo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByRole(Role role);
}
