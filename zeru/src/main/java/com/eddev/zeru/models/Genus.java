package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Genus implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private BigInteger idGenus;
    private String dsGenus;
    
    @ManyToOne
    @JoinColumn(name = "id_family")
    private Family family;

}

