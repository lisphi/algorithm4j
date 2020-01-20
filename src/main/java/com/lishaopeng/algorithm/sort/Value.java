package com.lishaopeng.algorithm.sort;

public class Value implements Comparable<Value> {
    private int value;
    private String name;

    public Value(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Value o) {
        if (o == null) {
            return 1;
        }
        if (value == o.value) {
            return 0;
        }
        return Integer.valueOf(this.value).compareTo(o.value);
    }

    public static Value of(int value, String name) {
        return new Value(value, name);
    }
}
