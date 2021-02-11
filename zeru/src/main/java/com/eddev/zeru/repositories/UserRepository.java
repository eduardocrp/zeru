package com.eddev.zeru.repositories;

import java.math.BigInteger;

import com.eddev.zeru.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

}
