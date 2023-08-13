package com.example.pantry.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ShelfModelTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Test checks if the name of shelf is correct")
    void setValidShelfName() {
        //given
        ShelfModel shelf = new ShelfModel();
        shelf.setShelfName("Fridge");
        //when
        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
        //then
        assertThat(violations).isEmpty();
    }

    @Test
    @DisplayName("Test checks what if the name name of shelf is too long")
    void setTooLongShelfName() {
        //given
        ShelfModel shelf = new ShelfModel();
        shelf.setShelfName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //when
        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
        //then
        assertThat(violations).isNotEmpty();
    }

    @Test
    @DisplayName("Test checks what if the name of shelf is too short")
    void setTooShortShelfName() {
        //given
        ShelfModel shelf = new ShelfModel();
        shelf.setShelfName("aa");
        //when
        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
        //then
        assertThat(violations).isNotEmpty();
    }

    @Test
    @DisplayName("Test checks what if the name of shelf is blank")
    void setBlankShelfName() {
        //given
        ShelfModel shelf = new ShelfModel();
        shelf.setShelfName(" ");
        //when
        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
        //then
        assertThat(violations).isNotEmpty();
    }

}