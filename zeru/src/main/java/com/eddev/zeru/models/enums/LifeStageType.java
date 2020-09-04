package com.eddev.zeru.models.enums;

public enum LifeStageType {

    SOW(1), GERMINATE(2), SPROUT(3), SEEDLINGS(4), COLLECT(5);

    private int idLifeStageType;

    LifeStageType(int idLifeStageType) {

        this.idLifeStageType = idLifeStageType;

    }

    public int getIdLifeStageType() {

        return this.idLifeStageType;

    }

    public static LifeStageType toEnum(int idLifeStageType) {

        for(LifeStageType value: LifeStageType.values())
            if(value.getIdLifeStageType() == idLifeStageType)
                return value;

        throw new IllegalArgumentException("Identificador inválido: " + idLifeStageType);

    }

}
