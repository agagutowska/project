package com.example.pantry.model;

import com.example.pantry.enums.ProductStatusEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatusEnumTest {

    @Test
    @DisplayName("check if display status is consistent with a specific enum")
    void testGetDisplayStatus() {
        assertEquals("Okay", ProductStatusEnum.OKAY.getDisplayStatus());
        assertEquals("If special offer", ProductStatusEnum.SPECIAL_OFFER.getDisplayStatus());
        assertEquals("Need to buy", ProductStatusEnum.NEED_TO_BUY.getDisplayStatus());
    }

    @Test
    @DisplayName("check enum values")
    void testEnumValues() {
        ProductStatusEnum[] expectedValues = {
                ProductStatusEnum.OKAY,
                ProductStatusEnum.SPECIAL_OFFER,
                ProductStatusEnum.NEED_TO_BUY
        };
        assertArrayEquals(expectedValues, ProductStatusEnum.values());
    }

    @Test
    @DisplayName("compare enums with values from class ProductStatus")
    void testEnumFromValue() {
        assertEquals(ProductStatusEnum.OKAY, ProductStatusEnum.valueOf("OKAY"));
        assertEquals(ProductStatusEnum.SPECIAL_OFFER, ProductStatusEnum.valueOf("SPECIAL_OFFER"));
        assertEquals(ProductStatusEnum.NEED_TO_BUY, ProductStatusEnum.valueOf("NEED_TO_BUY"));
    }

}