package com.lishaopeng.algorithm.sort;

import java.util.Arrays;

public class BucketSort implements SortStrategy<Value> {
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

    @Override
    public Value[] sort(Value[] items) {
        if (items == null || items.length < 2) {
            return items;
        }
        int max = getMaxIndex(items);
        int[] counting = new int[max + 1];
        for (Value item : items) {
            counting[item.getValue()] += 1;
        }
        Value[][] buckets = new Value[counting.length][];
        for (int i = 0; i < counting.length; i++) {
            buckets[i] = new Value[counting[i]];
        }
        Arrays.fill(counting, 0);
        for (int i = 0; i < items.length; i++) {
            int index = items[i].getValue();
            buckets[index][counting[index]++] = items[i];
        }
        for (int i = 0; i < buckets.length; i++) {
            new QuickSort<Value>().sort(buckets[i]);
        }
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                items[k] = buckets[i][j];
                k++;
            }
        }
        return items;
    }

    private int getMaxIndex(Value[] items) {
        int max = items[0].getValue();
        for (int i = 1; i < items.length; i++) {
            if (items[i].getValue() > max) {
                max = items[i].getValue();
            }
        }
        return max;
    }
}
