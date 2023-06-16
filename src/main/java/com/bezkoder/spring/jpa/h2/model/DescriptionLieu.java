/**
 * 
 */
package com.bezkoder.spring.jpa.h2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DescriptionLieu implements Serializable {

    private static final long serialVersionUID = 1L;

    protected DescriptionLieu() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lieu_id_sequence")
    @SequenceGenerator(name = "lieu_id_sequence", sequenceName = "lieu_id_sequence", allocationSize = 1)
    private Long id;

}
