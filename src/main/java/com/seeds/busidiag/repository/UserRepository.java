package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.User;
import com.seeds.busidiag.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findByRole(UserRole role);
}
