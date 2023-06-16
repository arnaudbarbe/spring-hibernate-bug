package com.bezkoder.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.h2.model.Lieu;
import com.bezkoder.spring.jpa.h2.model.Salle;
import com.bezkoder.spring.jpa.h2.repository.LieuRepository;
import com.bezkoder.spring.jpa.h2.repository.SalleRepository;

@Service
public class TutorialService {

    @Autowired
    LieuRepository lieuRepository;

    @Autowired
    SalleRepository salleRepository;

    @PersistenceContext
    EntityManager entityManager;

    public List<Lieu> getAllLieu() {
        return lieuRepository.findAll();
    }

    public Lieu getLieuById(long id) {

        this.entityManager.clear();

        Optional<Lieu> tutorialData = lieuRepository.findById(id);

        if (tutorialData.isPresent()) {
            return tutorialData.get();
        } else {
            return null;
        }
    }

    /**
     * @param lieu
     * @return
     */
    public Lieu saveLieu(Lieu lieu) {
        return lieuRepository.save(lieu);

    }

    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }
}
