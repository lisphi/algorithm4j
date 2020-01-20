package com.lishaopeng.algorithm.sort;

public class RadixSort implements SortStrategy<Value> {
    public final static Value[] sampleValues = new Value[] {
            Value.of(2, "847"),
            Value.of(5, "694"),
            Value.of(3, "235"),
            Value.of(3, "112"),
            Value.of(4, "893"),
            Value.of(1, "238"),
            Value.of(5, "934"),
            Value.of(2, "472"),
            Value.of(1, "119"),
            Value.of(1, "478")
    };

    @Override
    public Value[] sort(Value[] items) {
        for (int i = 2; i >= 0; i--) {
            final int index = i;
            new CountingSort(new ValueRadix() {
                @Override
                public int getRadix(Value item) {
                    return Integer.valueOf(item.getName().charAt(index));
                }
            }).sort(items);
        }
        return items;
    }
}
