package com.lishaopeng.algorithm.practice.fibonacci;

import java.math.BigDecimal;

public class RecursiveFibonacci implements Fibonacci {
    @Override
    public BigDecimal getValue(int i) {
        if (i <= 0) {
            return BigDecimal.ZERO;
        }
        if (i == 1 || i == 2) {
            return BigDecimal.ONE;
        }
        return getValue(i - 2).add(getValue(i -  1));
    }
}
