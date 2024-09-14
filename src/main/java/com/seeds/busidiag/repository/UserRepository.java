package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Users;
import com.seeds.busidiag.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByUsername(String username);

    List<Users> findByRole(UserRole role);
}
