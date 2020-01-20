package com.lishaopeng.algorithm.median;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapMedianTest {
    private Median<Integer> median;

    @BeforeEach
    void setUp() {
        median = new HeapMedian<>();
    }

    @Test
    void testGetValue2_1() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue2_2() {
        Integer actual = median.getValue(new Integer[] {
                2,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue2_3() {
        Integer actual = median.getValue(new Integer[] {
                2,
                2
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue3_1() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                3
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue3_2() {
        Integer actual = median.getValue(new Integer[] {
                2,
                1,
                3
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue3_3() {
        Integer actual = median.getValue(new Integer[] {
                3,
                2,
                1
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue3_4() {
        Integer actual = median.getValue(new Integer[] {
                1,
                1,
                2
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue3_5() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue3_6() {
        Integer actual = median.getValue(new Integer[] {
                2,
                1,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue3_7() {
        Integer actual = median.getValue(new Integer[] {
                2,
                2,
                2
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_1() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                3,
                4
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_2() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                4,
                3
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_3() {
        Integer actual = median.getValue(new Integer[] {
                1,
                3,
                2,
                4
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_4() {
        Integer actual = median.getValue(new Integer[] {
                1,
                3,
                4,
                2
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_5() {
        Integer actual = median.getValue(new Integer[] {
                1,
                4,
                3,
                2
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_6() {
        Integer actual = median.getValue(new Integer[] {
                1,
                4,
                2,
                3
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_7() {
        Integer actual = median.getValue(new Integer[] {
                4,
                3,
                2,
                1
        });
        assertEquals(2, actual);
    }

    @Test
    void testGetValue4_8() {
        Integer actual = median.getValue(new Integer[] {
                1,
                1,
                2,
                2
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue4_9() {
        Integer actual = median.getValue(new Integer[] {
                2,
                2,
                1,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue4_10() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                1,
                2
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue4_11() {
        Integer actual = median.getValue(new Integer[] {
                2,
                1,
                2,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue4_12() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                2,
                1
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue4_13() {
        Integer actual = median.getValue(new Integer[] {
                2,
                1,
                1,
                2
        });
        assertEquals(1, actual);
    }

    @Test
    void testGetValue5_1() {
        Integer actual = median.getValue(new Integer[] {
                1,
                2,
                3,
                4,
                5
        });
        assertEquals(3, actual);
    }

    @Test
    void testGetValue5_2() {
        Integer actual = median.getValue(new Integer[] {
                5,
                4,
                3,
                2,
                1
        });
        assertEquals(3, actual);
    }

    @Test
    void testGetValue10_1() {
        Integer actual = median.getValue(new Integer[] {
                2,
                7,
                9,
                3,
                5,
                6,
                0,
                1,
                4,
                8
        });
        assertEquals(4, actual);
    }
}