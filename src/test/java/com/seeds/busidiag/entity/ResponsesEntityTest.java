package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;
import com.seeds.busidiag.enums.QuestionCategory;
import com.seeds.busidiag.enums.UserRole;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ResponsesEntityTest {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidResponse() {

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

        Questions question = Questions.builder()
                .category(QuestionCategory.cat1)
                .importance(3)
                .questionText("This is a valid question.")
                .build();

        Responses response = Responses.builder()
                .diagnosis(diagnosis)
                .question(question)
                .category(QuestionCategory.cat1)
                .importance(3)
                .userScore(4)
                .weightedScore(3.5f)
                .build();
        assertTrue(validator.validate(response).isEmpty());
    }

    @Test
    public void testInvalidResponse() {
        Responses response = Responses.builder()
                .diagnosis(null)
                .question(null)
                .category(null)
                .importance(6)
                .userScore(0)
                .weightedScore(-1f)
                .build();
        assertFalse(validator.validate(response).isEmpty());
    }
}
