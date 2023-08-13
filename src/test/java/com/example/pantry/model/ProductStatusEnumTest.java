package com.example.pantry.model;

import com.example.pantry.enums.ProductStatusEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatusEnumTest {

    @Test
    @DisplayName("Test checks if display status is consistent with a specific enum")
    void getDisplayStatus() {
        assertEquals("Okay", ProductStatusEnum.OKAY.getDisplayStatus());
        assertEquals("If special offer", ProductStatusEnum.SPECIAL_OFFER.getDisplayStatus());
        assertEquals("Need to buy", ProductStatusEnum.NEED_TO_BUY.getDisplayStatus());
    }

    @Test
    @DisplayName("Test checks enum values")
    void setEnumValues() {
        ProductStatusEnum[] expectedValues = {
                ProductStatusEnum.OKAY,
                ProductStatusEnum.SPECIAL_OFFER,
                ProductStatusEnum.NEED_TO_BUY
        };
        assertArrayEquals(expectedValues, ProductStatusEnum.values());
    }

    @Test
    @DisplayName("Test compares enums with values from class ProductStatus")
    void setEnumFromValue() {
        assertEquals(ProductStatusEnum.OKAY, ProductStatusEnum.valueOf("OKAY"));
        assertEquals(ProductStatusEnum.SPECIAL_OFFER, ProductStatusEnum.valueOf("SPECIAL_OFFER"));
        assertEquals(ProductStatusEnum.NEED_TO_BUY, ProductStatusEnum.valueOf("NEED_TO_BUY"));
    }
}