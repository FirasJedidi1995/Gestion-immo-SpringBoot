package com.example.gestion_immo.Service;

import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Dto.ResponseUser;
import com.example.gestion_immo.Entities.Annonce;
import com.example.gestion_immo.Entities.Role;
import com.example.gestion_immo.Entities.User;
import com.example.gestion_immo.Repository.AnnonceRepository;
import com.example.gestion_immo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnnonceRepository annonceRepository;

    public List<ResponseUser> findUsersWithRoleUser() {
        List<User> users = userRepository.findByRole(Role.USER);
        List<ResponseUser> usersFormated = new ArrayList<>();
        for (User user : users) {
            ResponseUser member = ResponseUser.makeUser(user);
            usersFormated.add(member);
        }
        return usersFormated;
    }

    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)){
            return false;
        }
        userRepository.deleteById(id);
        return true;

    }

    public void addFavoris(Long userId, Long annonceId) {
        User user = userRepository.findById(userId).orElseThrow();
        Annonce annonce = annonceRepository.findById(annonceId).orElseThrow();
        user.getAnnoncesFavorites().add(annonce);
        userRepository.save(user);
    }

    public void removeFavoris(Long userId, Long annonceId) {
        User user = userRepository.findById(userId).orElseThrow();
        Annonce annonce = annonceRepository.findById(annonceId).orElseThrow();
        user.getAnnoncesFavorites().remove(annonce);
        userRepository.save(user);
    }

//    public List<ResponseAnnonce> getFavorisAnnonce(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow();
//
//
//        return user.getAnnoncesFavorites().stream()
//                .map(this::ResponseAnnonce)
//                .collect(Collectors.toList());
//    }

    public List<ResponseAnnonce> getFavorisAnnonce(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        // Assurez-vous que les annonces favorites sont chargées (si nécessaire, selon votre stratégie de chargement)
        return user.getAnnoncesFavorites().stream()
                .map(ResponseAnnonce::makeAnnonce) // Utilisation de la méthode makeAnnonce pour la conversion
                .collect(Collectors.toList());
    }
}



