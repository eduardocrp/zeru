package com.eddev.zeru.models.enums;

public enum ProfileType {

    ADMIN("ROLE_ADMIN"), 
    COMMON_USER("ROLE_COMMON_USER");

    private String idProfileType;

    ProfileType(String idProfileType) {

        this.idProfileType = idProfileType;

    }

    public String getIdProfileType() {

        return this.idProfileType;

    }

    public static ProfileType toEnum(String idProfileType) {

        for (ProfileType value : ProfileType.values())
            if (value.getIdProfileType().equals(idProfileType))
                return value;

        throw new IllegalArgumentException("Identificador inválido: " + idProfileType);

    }

}
