package com.lishaopeng.algorithm.practice.fibonacci;

import java.math.BigDecimal;

public class TailRecursiveFibonacciGenuine implements Fibonacci {
    @Override
    public BigDecimal getValue(int i) {
        return getValue(i, BigDecimal.ONE, BigDecimal.ONE).invoke();
    }

    private TailRecursion<BigDecimal> getValue(int i, BigDecimal bprev, BigDecimal prev) {
        if (i <= 0) {
            return finishTailRecursion(BigDecimal.ZERO);
        }
        if (i == 1) {
            return finishTailRecursion(bprev);
        }
        if (i == 2) {
            return finishTailRecursion(prev);
        }
        return () -> getValue(i - 1, prev, bprev.add(prev));
    }

    private TailRecursion<BigDecimal> finishTailRecursion(BigDecimal value) {
        return new TailRecursion<BigDecimal>() {
            @Override
            public TailRecursion<BigDecimal> apply() {
                throw new IllegalStateException();
            }
            @Override
            public boolean isFinished() {
                return true;
            }
            @Override
            public BigDecimal getResult() {
                return value;
            }
        };
    }

}
