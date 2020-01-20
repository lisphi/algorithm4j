package com.lishaopeng.algorithm.practice.fibonacci;

import java.util.stream.Stream;

public interface TailRecursion<T> {
    TailRecursion<T> apply();

    default boolean isFinished() {
        return false;
    }

    default T getResult() {
        throw new IllegalStateException();
    }

    default T invoke() {
        return Stream.iterate(this, TailRecursion::apply)
                .filter(TailRecursion::isFinished)
                .findFirst()
                .get()
                .getResult();
    }
}
