package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Businesses;
import com.seeds.busidiag.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Businesses, Integer> {

    Optional<Businesses> findByOwner(Users owner);
}
