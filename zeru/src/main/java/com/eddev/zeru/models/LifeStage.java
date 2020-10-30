package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.eddev.zeru.models.enums.LifeStageType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
public class LifeStage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private BigInteger idLifeStage;

    @Getter
    @Setter
    @Column(nullable = false)
    private BigInteger dsLifeStage;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date tmLifeStage;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_specie", nullable = false)
    private Specie specie;

    @Column(nullable = false)
    private int tpLifeStage;

    public void setTpLifeStage(LifeStageType tpLifeStage) {
        this.tpLifeStage = tpLifeStage.getIdLifeStageType();
    }

    public LifeStageType getTpLifeStageType() {
        return LifeStageType.toEnum(tpLifeStage);
    }

}
