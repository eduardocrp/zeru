package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Specie implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idSpecie;
    
    @Column(nullable = false)
    private String nmScientific;

    @Column(nullable = false)
    private String nmCommon;

    private String idSibbr;
    
    @ManyToOne
    @JoinColumn(name = "id_genus", nullable = false)
    private Genus genus;

}

