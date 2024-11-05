package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Users;
import com.seeds.busidiag.enums.UserRole;
import com.seeds.busidiag.repository.UserRepository;
import com.seeds.busidiag.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int save(Users user) {
        Users savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public Users findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public int updateById(Users user, int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        user.setId(id);
        userRepository.save(user);
        return id;
    }

    @Override
    public int deleteById(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No user found with email: " + email));
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("No user found with username: " + username));
    }

    @Override
    public List<Users> findByRole(UserRole role) {
        return userRepository.findByRole(role);
    }
}
