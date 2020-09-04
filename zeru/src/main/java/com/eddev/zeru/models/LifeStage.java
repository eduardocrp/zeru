package com.eddev.zeru.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
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

    @Getter
    @Setter
    private BigInteger idLifeStage;
    @Getter
    @Setter
    private BigInteger dsLifeStage;

    @Getter
    @Setter
    private Date tmLifeStage;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_specie")
    private Specie specie;

    private int tpLifeStage;

    public void setTpLifeStage(LifeStageType tpLifeStage) {
        this.tpLifeStage = tpLifeStage.getIdLifeStageType();
    }

    public LifeStageType getTpLifeStageType() {
        return LifeStageType.toEnum(tpLifeStage);
    }

}
