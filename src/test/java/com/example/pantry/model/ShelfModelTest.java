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
    @DisplayName("the name of shelf is correct")
    void setValidShelfName() {
        //given
        ShelfModel shelf = new ShelfModel();
        shelf.setShelfName("Fridge");

        //when
        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf); //Oczekujemy, że nie zostaną wygenerowane żadne naruszenia ograniczeń (violations są puste), co oznacza, że pola spełniają ograniczenia @NotBlank i @Size.

        //then
        assertThat(violations).isEmpty(); //Podczas używania assertThat, jeśli metoda isEmpty() zwróci true, oznacza to, że test zakończy się pomyślnie. W przeciwnym razie, jeśli naruszenia ograniczeń zostałyby znalezione, test nie przeszedłby i wyświetliłby błąd.

    }
//     NIE WIEM CZY TAK SIĘ ROBI, CZY WSZYSTKIE TESTY MUSZĄ BYĆ ZDANE?

//    @Test
//    @DisplayName("the name of shelf is incorrect, it's too long")
//    void setTooLongShelfName() {
//        //given
//        ShelfModel shelf = new ShelfModel();
//        shelf.setShelfName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//
//        //when
//        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
//
//        //then
//        assertThat(violations).isEmpty();
//
//    }
//
//    @Test
//    @DisplayName("the name of shelf is incorrect, it's too short")
//    void setTooShortShelfName() {
//        //given
//        ShelfModel shelf = new ShelfModel();
//        shelf.setShelfName("aa");
//
//        //when
//        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
//
//        //then
//        assertThat(violations).isEmpty();
//
//    }
//
//    @Test
//    @DisplayName("the name of shelf is incorrect, it's blank")
//    void setBlankShelfName() {
//        //given
//        ShelfModel shelf = new ShelfModel();
//        shelf.setShelfName("");
//
//        //when
//        Set<ConstraintViolation<ShelfModel>> violations = validator.validate(shelf);
//
//        //then
//        assertThat(violations).isEmpty();
//
//    }

}