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
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idOrder;

    @Column(nullable = false)
    private String dsOrder;
    
    @ManyToOne
    @JoinColumn(name = "id_class_order", nullable = false)
    private ClassOrder classOrder;

}
