package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.UserRole;
import com.seeds.busidiag.enums.BusinessType;
import com.seeds.busidiag.enums.BusinessStatus;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BusinessesEntityTest {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidBusiness() {
        User owner = User.builder()
                .email("owner@example.com")
                .username("owner")
                .password("password")
                .role(UserRole.USER)
                .build();

        Business business = Business.builder()
                .ownerId(owner.getId())
                .type(BusinessType.PUBLIC)
                .size("large")
                .status(BusinessStatus.ACTIVE)
                .date(LocalDate.now())
                .build();
        assertTrue(validator.validate(business).isEmpty());
    }

    @Test
    public void testInvalidBusiness() {
        Business business = Business.builder()
                .ownerId(0)
                .type(null)
                .size("large")
                .status(null)
                .date(null)
                .build();
        assertFalse(validator.validate(business).isEmpty());
    }
}