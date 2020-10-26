package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Phylum implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private BigInteger idPhylum;
    private String dsPhylum;

}
