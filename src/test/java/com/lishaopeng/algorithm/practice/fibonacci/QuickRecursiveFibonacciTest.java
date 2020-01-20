package com.lishaopeng.algorithm.practice.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickRecursiveFibonacciTest {
    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new QuickRecursiveFibonacci();
    }

    @Test
    void testGetValue() {
        assertEquals(BigDecimal.valueOf(1L), fibonacci.getValue(1));
        assertEquals(BigDecimal.valueOf(1L), fibonacci.getValue(2));
        assertEquals(BigDecimal.valueOf(2L), fibonacci.getValue(3));
        assertEquals(BigDecimal.valueOf(3L), fibonacci.getValue(4));
        assertEquals(BigDecimal.valueOf(5L), fibonacci.getValue(5));
        assertEquals(BigDecimal.valueOf(8L), fibonacci.getValue(6));
        assertEquals(BigDecimal.valueOf(13L), fibonacci.getValue(7));
        assertEquals(BigDecimal.valueOf(21L), fibonacci.getValue(8));
        assertEquals(BigDecimal.valueOf(34L), fibonacci.getValue(9));
        assertEquals(BigDecimal.valueOf(55L), fibonacci.getValue(10));
    }

    @Test
    void testGetValue2() {
        BigDecimal value = fibonacci.getValue(1000);
        assertEquals("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875", value.toString());
    }
}