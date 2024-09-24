package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.UserRole;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersEntityTest {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testValidUsers() {
        Users users = Users.builder()
                .email("example@example.com")
                .username("test")
                .password("test")
                .role(UserRole.USER)
                .build();
        assertTrue(validator.validate(users).isEmpty());
    }

    @Test
    public void testInvalidUsers() {
        Users users = Users.builder()
                .email("example@example.com")
                .username("test")
                .password("short")
                .role(null)
                .build();
        assertFalse(validator.validate(users).isEmpty());
    }
}