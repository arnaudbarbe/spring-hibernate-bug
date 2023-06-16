/**
 * 
 */
package com.bezkoder.spring.jpa.h2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Salle extends DescriptionLieu {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "LIEUFK", insertable = false, updatable = false)
    private Lieu lieu;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private Set<Equipement> equipements;

    @Enumerated(EnumType.STRING)
    private ETypeSalle type;

    public Salle() {
        super();
        equipements = new HashSet<>();
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Set<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(Set<Equipement> equipements) {
        this.equipements = equipements;
    }

    public ETypeSalle getType() {
        return type;
    }

    public void setType(ETypeSalle type) {
        this.type = type;
    }
}
