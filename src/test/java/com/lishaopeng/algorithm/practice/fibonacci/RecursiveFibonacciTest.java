package com.lishaopeng.algorithm.practice.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFibonacciTest {
    Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new RecursiveFibonacci();
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
        BigDecimal value = fibonacci.getValue(40);
        assertEquals(BigDecimal.valueOf(102334155), value);
    }
}