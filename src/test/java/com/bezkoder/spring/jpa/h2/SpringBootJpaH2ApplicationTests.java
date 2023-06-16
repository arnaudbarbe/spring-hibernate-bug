package com.bezkoder.spring.jpa.h2;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bezkoder.spring.jpa.h2.controller.TutorialService;
import com.bezkoder.spring.jpa.h2.model.ETypeSalle;
import com.bezkoder.spring.jpa.h2.model.Equipement;
import com.bezkoder.spring.jpa.h2.model.Lieu;
import com.bezkoder.spring.jpa.h2.model.Salle;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {

    @Autowired
    private TutorialService tutorialService;

    @Test
    @Transactional
    void contextLoads() {

        try {
            Lieu lieu = new Lieu("title", "desc", false);
            Equipement equipement = new Equipement();
            Salle salle = new Salle();
            salle.setType(ETypeSalle.toto);

            salle = tutorialService.saveSalle(salle);

            salle.getEquipements().add(equipement);
            equipement.setLieu(lieu);
            equipement.setSalle(salle);

            lieu.getEquipements().add(equipement);
            lieu.getSalles().add(salle);

            lieu = tutorialService.saveLieu(lieu);

            Lieu existingLieu = tutorialService.getLieuById(lieu.getId());

            System.out.println(existingLieu.getDescription());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
