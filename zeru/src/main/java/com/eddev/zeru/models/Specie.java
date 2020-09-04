package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Specie implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private BigInteger idSpecie;
    private String nmScientific;
    private String nmCommon;
    private String idSibbr;
    
    @ManyToOne
    @JoinColumn(name = "id_genus")
    private Genus genus;

}

