/**
 * 
 */
package com.bezkoder.spring.jpa.h2.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lieu_id_sequence")
    @SequenceGenerator(name = "lieu_id_sequence", sequenceName = "lieu_id_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = true)
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

    @Override
    public String toString() {
        return "Salle [id=" + id + ", type=" + type + "]";
    }
}
