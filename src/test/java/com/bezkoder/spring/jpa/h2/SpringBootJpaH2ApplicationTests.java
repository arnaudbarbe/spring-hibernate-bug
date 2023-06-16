package com.bezkoder.spring.jpa.h2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bezkoder.spring.jpa.h2.controller.TutorialService;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {

    @Autowired
    private TutorialService tutorialService;

    @Test
    void contextLoads() {
        tutorialService.getAllLieu();
    }

}
