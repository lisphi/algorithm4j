package com.lishaopeng.algorithm.linear.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

    @Test
    void revertWord() {
        char[] words = "Lendon bridge is falling down".toCharArray();
        ArrayUtil.revertWord(words);
        assertEquals("down falling is bridge Lendon", new String(words));
    }
}