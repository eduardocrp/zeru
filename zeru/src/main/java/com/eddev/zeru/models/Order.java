package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private BigInteger idOrder;
    private String dsOrder;
    
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class classOrder;

}
