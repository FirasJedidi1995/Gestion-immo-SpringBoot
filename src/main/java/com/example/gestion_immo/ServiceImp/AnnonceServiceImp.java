package com.example.gestion_immo.ServiceImp;

import com.example.gestion_immo.Dto.RequestAnnonce;
import com.example.gestion_immo.Dto.ResponseAnnonce;
import com.example.gestion_immo.Entities.*;
import com.example.gestion_immo.Repository.*;
import com.example.gestion_immo.Service.AnnonceService;
import com.example.gestion_immo.Service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnonceServiceImp implements AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<ResponseAnnonce> getAllAnnonces() {
        List<Annonce> annonces=annonceRepository.findAll();
        List<ResponseAnnonce> AnnonceFormated = new ArrayList<>();
        for (Annonce annonce : annonces){
            ResponseAnnonce annonceF=ResponseAnnonce.makeAnnonce(annonce);
            AnnonceFormated.add(annonceF);
        }

        return AnnonceFormated;
    }

    @Override
    public void createAnnonce(RequestAnnonce requestAnnonce) {
        //Region region=regionRepository.findById(requestAnnonce.getRegionId()).orElseThrow();
        Ville ville=villeRepository.findById(requestAnnonce.getVilleId()).orElseThrow();
        Categorie categorie= categorieRepository.findById(requestAnnonce.getCategorieId()).orElseThrow();
        Offre offre=offreRepository.findById(requestAnnonce.getOffreId()).orElseThrow();
        User user=userRepository.findById(requestAnnonce.getUserId()).orElseThrow();
        Annonce annonce=Annonce.builder()
                .offre(offre)
                .titre(requestAnnonce.getTitre())
                .description(requestAnnonce.getDescription())
                .ville(ville)
                //.region(region)
                .categorie(categorie)
                .adresse(requestAnnonce.getAdresse())
                .prix(requestAnnonce.getPrix())
                .user(user)
                .build();
        annonceRepository.save(annonce);
    }

    @Override
    public boolean deleteAnnonce(Long id) {
        return false;
    }

//    @Override
//    public List<ResponseAnnonce> getUserAnnonces(Long userId) {
//        return annonceRepository.findByUserId(userId);
//    }

    public List<ResponseAnnonce> getUserAnnonces(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        // Assurez-vous que les annonces favorites sont chargées (si nécessaire, selon votre stratégie de chargement)
        return user.getAnnoncesPublished().stream()
                .map(ResponseAnnonce::makeAnnonce) // Utilisation de la méthode makeAnnonce pour la conversion
                .collect(Collectors.toList());
    }

}
