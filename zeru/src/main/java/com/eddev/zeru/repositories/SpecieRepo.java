package com.eddev.zeru.repositories;

import java.math.BigInteger;

import com.eddev.zeru.models.Specie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecieRepo extends JpaRepository<Specie, BigInteger> {

}
