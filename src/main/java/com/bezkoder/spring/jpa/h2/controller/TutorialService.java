package com.bezkoder.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.h2.model.Lieu;
import com.bezkoder.spring.jpa.h2.repository.LieuRepository;

@Service
public class TutorialService {

    @Autowired
    LieuRepository lieuRepository;

    public List<Lieu> getAllLieu() {
        return lieuRepository.findAll();
    }

    public Lieu getLieuById(long id) {
        Optional<Lieu> tutorialData = lieuRepository.findById(id);

        if (tutorialData.isPresent()) {
            return tutorialData.get();
        } else {
            return null;
        }
    }
}
