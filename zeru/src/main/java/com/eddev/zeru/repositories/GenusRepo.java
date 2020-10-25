package com.eddev.zeru.repositories;

import java.math.BigInteger;

import com.eddev.zeru.models.Genus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenusRepo extends JpaRepository<Genus, BigInteger> {

}
