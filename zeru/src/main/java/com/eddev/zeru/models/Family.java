package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Family implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private BigInteger idFamily;
    private String dsFamily;
    
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

}

