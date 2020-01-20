package com.lishaopeng.algorithm.linear.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void testPush() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        Integer pushed = stack.push(1);
        pushed = stack.push(2);
        assertEquals(2, pushed);
    }

    @Test
    void pop1() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void pop2() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        Integer pushed = stack.push(1);
        Integer poped = stack.pop();
        assertEquals(pushed, poped);
        assertEquals(1, pushed);
    }

    @Test
    void pop3() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.pop();
        stack.pop();
        Integer poped = stack.pop();
        assertEquals(9, poped);
    }
}