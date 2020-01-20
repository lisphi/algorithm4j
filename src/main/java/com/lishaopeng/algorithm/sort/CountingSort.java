package com.lishaopeng.algorithm.sort;

import java.util.Arrays;

public class CountingSort implements SortStrategy<Value> {
    private ValueRadix valueRadix;

    public final static Value[] sampleValues = new Value[] {
            Value.of(2, "b"),
            Value.of(5, "e"),
            Value.of(3, "c"),
            Value.of(3, "cc"),
            Value.of(4, "d"),
            Value.of(1, "a"),
            Value.of(5, "ee"),
            Value.of(2, "bb"),
            Value.of(1, "aa"),
            Value.of(1, "aaa")
    };

    public CountingSort() {
        this(null);
    }

    public CountingSort(ValueRadix valueRadix) {
        if (valueRadix == null) {
            this.valueRadix = new ValueRadix() {
                @Override
                public int getRadix(Value item) {
                    return item.getValue();
                }
            };
        } else {
            this.valueRadix = valueRadix;
        }
    }

    @Override
    public Value[] sort(Value[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }
        int maxIndex = getMaxIndex(items);
        int[] baseIndexes = new int[maxIndex + 1];
        Arrays.fill(baseIndexes, 0);
        for (Value item : items) {
            baseIndexes[getRadix(item)] += 1;
        }
        for (int i = 1; i < baseIndexes.length; i++) {
            baseIndexes[i] += baseIndexes[i - 1];
        }
        for (int i = baseIndexes.length - 1; i > 0; i--) {
            baseIndexes[i] = baseIndexes[i - 1];
        }
        baseIndexes[0] = 0;
        Value[] values = new Value[items.length];
        int[] deltaIndexes = new int[maxIndex + 1];
        Arrays.fill(deltaIndexes, 0);
        for (int i = 0; i < items.length; i++) {
            int index = getRadix(items[i]);
            values[baseIndexes[index] + deltaIndexes[index]] = items[i];
            deltaIndexes[index]++;
        }
        for (int i = 0; i < items.length; i++) {
            items[i] = values[i];
        }
        return items;
    }

    private int getRadix(Value item) {
        return valueRadix.getRadix(item);
    }

    private int getMaxIndex(Value[] items) {
        int max = getRadix(items[0]);
        for (int i = 1; i < items.length; i++) {
            if (getRadix(items[i]) > max) {
                max = getRadix(items[i]);
            }
        }
        return max;
    }
}
