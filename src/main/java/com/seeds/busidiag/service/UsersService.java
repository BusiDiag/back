package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Users;
import com.seeds.busidiag.enums.UserRole;

import java.util.List;

public interface UsersService {

    int save(Users user);

    Users findById(int id);

    int updateById(Users user, int id);

    int deleteById(int id);

    Users findByEmail(String email);

    Users findByUsername(String username);

    List<Users> findByRole(UserRole role);
}
