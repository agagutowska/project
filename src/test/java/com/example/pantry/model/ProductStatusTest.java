package com.example.pantry.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatusTest {

    @Test
    @DisplayName("check if display status is consistent with a specific enum")
    void testGetDisplayStatus() {
        assertEquals("Okay", ProductStatus.OKAY.getDisplayStatus());
        assertEquals("If special offer", ProductStatus.SPECIAL_OFFER.getDisplayStatus());
        assertEquals("Need to buy", ProductStatus.NEED_TO_BUY.getDisplayStatus());
    }

    @Test
    @DisplayName("check enum values")
    void testEnumValues() {
        ProductStatus[] expectedValues = {
                ProductStatus.OKAY,
                ProductStatus.SPECIAL_OFFER,
                ProductStatus.NEED_TO_BUY
        };
        assertArrayEquals(expectedValues, ProductStatus.values());
    }

    @Test
    @DisplayName("compare enums with values from class ProductStatus")
    void testEnumFromValue() {
        assertEquals(ProductStatus.OKAY, ProductStatus.valueOf("OKAY"));
        assertEquals(ProductStatus.SPECIAL_OFFER, ProductStatus.valueOf("SPECIAL_OFFER"));
        assertEquals(ProductStatus.NEED_TO_BUY, ProductStatus.valueOf("NEED_TO_BUY"));
    }

}