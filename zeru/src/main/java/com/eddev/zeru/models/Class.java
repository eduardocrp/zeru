package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Class implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private BigInteger idClass;
    private String dsClass;
    
    @ManyToOne
    @JoinColumn(name = "id_phylum")
    private Phylum phylum;

}
