package com.eddev.zeru.models;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eddev.zeru.models.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger idUser;

    private String dsUser;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_USER_PROFILE")
    private Set<String> profiles = new HashSet<>();

    public User() {
        addProfile(ProfileType.COMMON_USER);
    }

    @JsonIgnore
    public Set<ProfileType> getProfilesType() {
        return profiles.stream().map(pro -> ProfileType.toEnum(pro)).collect(Collectors.toSet());
    }

    public void addProfile(ProfileType profile) {
        this.profiles.add(profile.getIdProfileType());
    }

}
