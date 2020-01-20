package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.stack.calculator.exception.CalculatorException;

public interface ExpressionCalculator {
    Long evaluate(String expressoin) throws CalculatorException;
}
