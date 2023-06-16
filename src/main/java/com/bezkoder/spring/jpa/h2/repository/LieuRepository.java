package com.bezkoder.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.h2.model.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, Long> {

}
