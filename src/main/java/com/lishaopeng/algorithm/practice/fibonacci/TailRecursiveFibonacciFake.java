package com.lishaopeng.algorithm.practice.fibonacci;

import java.math.BigDecimal;

public class TailRecursiveFibonacciFake implements Fibonacci {
    @Override
    public BigDecimal getValue(int i) {
        return getValue(i, BigDecimal.ONE, BigDecimal.ONE);
    }

    private BigDecimal getValue(int i, BigDecimal pprev, BigDecimal prev) {
        if (i <= 0) {
            return BigDecimal.ZERO;
        }
        if (i == 1) {
            return pprev;
        }
        if (i == 2) {
            return prev;
        }
        return getValue(i - 1, prev, pprev.add(prev));
    }
}
