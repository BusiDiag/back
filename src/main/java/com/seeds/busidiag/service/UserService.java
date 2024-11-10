package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.User;
import com.seeds.busidiag.enums.UserRole;

import java.util.List;

public interface UserService {

    int save(User user);

    User findById(int id);

    int updateById(User user, int id);

    int deleteById(int id);

    User findByEmail(String email);

    User findByUsername(String username);

    List<User> findByRole(UserRole role);
}
