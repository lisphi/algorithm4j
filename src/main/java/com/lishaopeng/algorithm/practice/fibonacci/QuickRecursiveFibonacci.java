package com.lishaopeng.algorithm.practice.fibonacci;

import com.lishaopeng.algorithm.hash.CocoaMap;
import com.lishaopeng.algorithm.hash.SimpleHashMap;

import java.math.BigDecimal;

public class QuickRecursiveFibonacci implements Fibonacci {
    CocoaMap<Integer, BigDecimal> map = new SimpleHashMap<>();

    @Override
    public BigDecimal getValue(int i) {
        if (i <= 0) {
            return BigDecimal.ZERO;
        }
        if (i == 1 || i == 2) {
            return BigDecimal.ONE;
        }
        boolean exists = map.containsKey(i);
        if (exists) {
            return map.get(i);
        }
        BigDecimal value = getValue(i - 2).add(getValue(i -  1));
        map.put(i, value);
        return value;
    }
}
