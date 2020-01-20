package com.lishaopeng.algorithm.linear.stack.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixExpressionCalculatorTest {
    ExpressionCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PostfixExpressionCalculator();
    }

    @Test
    void evaluate1() {
        assertDoesNotThrow(() -> {
            Long actual = calculator.evaluate("1+2*3");
            assertEquals(7L, actual);
        });
    }

    @Test
    void evaluate2() {
        assertDoesNotThrow(() -> {
            Long actual = calculator.evaluate("1*2+3");
            assertEquals(5L, actual);
        });
    }

    @Test
    void evaluate3() {
        assertDoesNotThrow(() -> {
            Long actual = calculator.evaluate("(11+(22+33*4)*25)*7");
            assertEquals(27027L, actual);
        });
    }
}