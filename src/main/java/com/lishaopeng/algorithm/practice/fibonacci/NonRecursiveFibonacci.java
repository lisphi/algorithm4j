package com.lishaopeng.algorithm.practice.fibonacci;

import java.math.BigDecimal;

public class NonRecursiveFibonacci implements Fibonacci {
    @Override
    public BigDecimal getValue(int i) {
        if (i <= 0) {
            return BigDecimal.ZERO;
        }
        if (i == 1 || i == 2) {
            return BigDecimal.ONE;
        }
        BigDecimal bprev = BigDecimal.ONE;
        BigDecimal prev = BigDecimal.ONE;
        for (int j = 3; j <= i; j++) {
            BigDecimal current = bprev.add(prev);
            bprev = prev;
            prev = current;
        }
        return prev;
    }
}
