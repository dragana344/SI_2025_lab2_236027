package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SILab2Test {

    // === Every-statement tests ===

    @Test
    void testAllItemsNullThrows() {
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> SILab2.checkCart(null, "1234567890123456")
        );
        assertEquals("allItems list can't be null!", ex.getMessage());
    }

    @Test
    void testValidItemNoDiscount() {
        double total = SILab2.checkCart(
                List.of(new Item("Strawberry", 3, 100, 0.0)),
                "1234567890123456"
        );
        assertEquals(300.0, total);
    }

    @Test
    void testInvalidCardCharacterThrows() {
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> SILab2.checkCart(
                        List.of(new Item("Strawberry", 3, 100, 0.2)),
                        "A234567890123456"
                )
        );
        assertEquals("Invalid character in card number!", ex.getMessage());
    }

    @Test
    void testInvalidItemThrows() {
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> SILab2.checkCart(
                        List.of(new Item("", 3, 100, 0.2)),
                        "1234567890123456"
                )
        );
        assertEquals("Invalid item!", ex.getMessage());
    }

    @Test
    void testInvalidCardNumberLengthThrows() {
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> SILab2.checkCart(
                        List.of(new Item("Strawberry", 3, 100, 0.2)),
                        "123456789012"
                )
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }


    // === Multiple-condition tests ===
    // FFF: no branch → no -30
    @Test
    void testFFF_NoAdjustment() {
        double total = SILab2.checkCart(
                List.of(new Item("Strawberry", 1, 150, 0.0)),
                "1234567890123456"
        );
        assertEquals(150.0, total);
    }

    // FFT: quantity>10 → -30 then +150*15
    @Test
    void testFFT_QuantityAdjustment() {
        double total = SILab2.checkCart(
                List.of(new Item("Strawberry", 15, 150, 0.0)),
                "1234567890123456"
        );
        assertEquals(2220.0, total);
    }

    // FTX: discount>0 → -30 then +150*(1-0.2)*1
    @Test
    void testFTX_DiscountAdjustment() {
        double total = SILab2.checkCart(
                List.of(new Item("Strawberry", 1, 150, 0.2)),
                "1234567890123456"
        );
        assertEquals(90.0, total);
    }

    // TXX: price>300 → -30 then +310*0
    @Test
    void testTXX_PriceAdjustment() {
        double total = SILab2.checkCart(
                List.of(new Item("Strawberry", 0, 310, 0.0)),
                "1234567890123456"
        );
        assertEquals(-30.0, total);
    }
}
