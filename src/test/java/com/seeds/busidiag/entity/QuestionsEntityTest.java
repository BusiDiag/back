package com.seeds.busidiag.entity;

import com.seeds.busidiag.enums.QuestionCategory;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionsEntityTest {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidQuestion() {
        Questions question = Questions.builder()
                .category(QuestionCategory.cat1)
                .importance(3)
                .questionText("This is a valid question.")
                .build();
        assertTrue(validator.validate(question).isEmpty());
    }

    @Test
    public void testInvalidQuestion() {
        Questions question = Questions.builder()
                .category(null)
                .importance(6)
                .questionText("")
                .build();
        assertFalse(validator.validate(question).isEmpty());
    }
}
