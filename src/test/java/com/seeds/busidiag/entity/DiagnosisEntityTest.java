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

public class DiagnosisEntityTest {
    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidDiagnosis() {
        Users owner = Users.builder()
                .email("owner@example.com")
                .username("owner")
                .password("password")
                .role(UserRole.USER)
                .build();

        Businesses business = Businesses.builder()
                .owner(owner)
                .type(BusinessType.PUBLIC)
                .size("large")
                .status(BusinessStatus.ACTIVE)
                .date(LocalDate.now())
                .build();

        Diagnosis diagnosis = Diagnosis.builder()
                .business(business)
                .date(LocalDate.now())
                .scoreCat1(4.5f)
                .scoreCat2(3.8f)
                .scoreCat3(4.0f)
                .scoreCat4(5.0f)
                .recommendations("This is a recommendation.")
                .build();
        assertTrue(validator.validate(diagnosis).isEmpty());
    }

    @Test
    public void testInvalidDiagnosis() {
        Diagnosis diagnosis = Diagnosis.builder()
                .business(null)
                .date(null)
                .scoreCat1(-1f)
                .scoreCat2(6f)
                .recommendations("")
                .build();
        assertFalse(validator.validate(diagnosis).isEmpty());
    }
}
