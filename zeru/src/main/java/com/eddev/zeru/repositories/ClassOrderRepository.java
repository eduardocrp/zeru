package com.eddev.zeru.repositories;

import java.math.BigInteger;

import com.eddev.zeru.models.ClassOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassOrderRepository extends JpaRepository<ClassOrder, BigInteger> {

}
