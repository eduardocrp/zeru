package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Phylum implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private BigInteger idPhylum;
    private String dsPhylum;

}
