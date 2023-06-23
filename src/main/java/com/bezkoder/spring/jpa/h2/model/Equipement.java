/**
 * 
 */
package com.bezkoder.spring.jpa.h2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "LIEUFK")
    private Lieu lieu;

    @ManyToOne(optional = true)
    @JoinColumn(name = "SALLEFK")
    private Salle salle;

    @Enumerated(EnumType.STRING)
    private ETypeEquipement type;

    public Equipement() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public ETypeEquipement getType() {
        return type;
    }

    public void setType(ETypeEquipement type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Equipement [id=" + id + ", type=" + type + "]";
    }
}
