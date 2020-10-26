package com.eddev.zeru.repositories;

import java.math.BigInteger;

import com.eddev.zeru.models.Family;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, BigInteger> {

}
