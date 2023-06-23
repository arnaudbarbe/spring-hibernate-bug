package com.bezkoder.spring.jpa.h2;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

            Salle salle = new Salle();
            salle.setType(ETypeSalle.toto);

            Equipement equipement1 = new Equipement();
            lieu.getEquipements().add(equipement1);
            equipement1.setLieu(lieu);
            salle.getEquipements().add(equipement1);
            equipement1.setSalle(salle);

            Equipement equipement2 = new Equipement();
            lieu.getEquipements().add(equipement2);
            equipement2.setLieu(lieu);

            salle.setLieu(lieu);
            lieu.getSalles().add(salle);

            salle = tutorialService.saveSalle(salle);
            lieu = tutorialService.saveLieu(lieu);

            Lieu existingLieu = tutorialService.getLieuById(lieu.getId());
//should have 2 equipements into lieu but only 1 is returned, look into console and see generated SQL to retrieve Equipement from a Lieu
            assertEquals(2, existingLieu.getEquipements().size());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
