package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.stack.calculator.exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixExpressionCalculatorTest {
    ExpressionCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new InfixExpressionCalculator();
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
    void evaluate3() throws Exception {
        Long actual = calculator.evaluate("2*(3+4)");
        assertEquals(14L, actual);
    }


    @Test
    void evaluate4() {
        InfixExpressionCalculator calculator = new InfixExpressionCalculator();
        assertDoesNotThrow(() -> {
            Long actual = calculator.evaluate("(11+(22+33*4)*25)*7");
            assertEquals(27027L, actual);
        });
    }

    @Test
    void evaluate5() {
        InfixExpressionCalculator calculator = new InfixExpressionCalculator();
        assertThrows(CalculatorException.class, () -> {
            calculator.evaluate("");
        });
    }
}