package com.lishaopeng.algorithm.sort;

import com.lishaopeng.algorithm.median.HeapMedian;
import com.lishaopeng.algorithm.median.Median;
import com.lishaopeng.algorithm.median.QuickMedian;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unchecked")
public class SortBenchmark {
    public static void main(String[] args) {
        SortBenchmark benchmark = new SortBenchmark();
        System.out.println("===== 100 * 1000 =====");
        benchmark.run(benchmark.generateIntArrays100x1000());
        System.out.println("===== 1000 * 100 =====");
        benchmark.run(benchmark.generateIntArrays1000x100());
        System.out.println("===== 10000 * 10 =====");
        benchmark.run(benchmark.generateIntArrays10000x10());
        System.out.println("===== 1 * 10000 =====");
        benchmark.run(benchmark.generateIntArray100000());
    }

    Random random = new Random(System.currentTimeMillis() / 1000000L);
    SortStrategy<Integer>[] sorts = (SortStrategy<Integer>[])new SortStrategy[] {
            new BubbleSort<>(),
            new SelectionSort<>(),
            new InsertionSort<>(),
            new ShellSort<>(),
            new MergeSort<>(),
            new QuickSort<>(),
            new BinaryHeapSort<>(),
            new HeapMedianSort(),
            new QuickMedianSort()
    };

    private void run(Integer[][] intArrays) {
        for (SortStrategy<Integer> sortStrategy : sorts) {
            Integer[][] cloned = cloneIntArrays(intArrays);
            long start = System.currentTimeMillis();
            for (int i = 0; i < intArrays.length; i++) {
                sortStrategy.sort(cloned[i]);
            }
            long end = System.currentTimeMillis();
            System.out.format("%15s - %6d\n",
                    sortStrategy.getClass().getSimpleName(),
                    end - start);
        }
    }

    private void run(Integer[] intArray) {
        for (int i = 3; i < sorts.length; i++) {
            Integer[] cloned = Arrays.copyOf(intArray, intArray.length);
            long start = System.currentTimeMillis();
            sorts[i].sort(cloned);
            long end = System.currentTimeMillis();
            System.out.format("%15s - %6d\n",
                    sorts[i].getClass().getSimpleName(),
                    end - start);
        }
    }


    private Integer[][] generateIntArrays100x1000() {
        Integer[][] intArrays = new Integer[100][1000];
        for (int i = 0; i < intArrays.length; i++) {
            for (int j = 0; j < intArrays[i].length; j++) {
                intArrays[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        return intArrays;
    }

    private Integer[][] generateIntArrays1000x100() {
        Integer[][] intArrays = new Integer[1000][100];
        for (int i = 0; i < intArrays.length; i++) {
            for (int j = 0; j < intArrays[i].length; j++) {
                intArrays[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        return intArrays;
    }

    private Integer[][] generateIntArrays10000x10() {
        Integer[][] intArrays = new Integer[10000][10];
        for (int i = 0; i < intArrays.length; i++) {
            for (int j = 0; j < intArrays[i].length; j++) {
                intArrays[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        return intArrays;
    }

    private Integer[] generateIntArray100000() {
        Integer[] intArray = new Integer[1000000];
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = random.nextInt(Integer.MAX_VALUE);
        }
        return intArray;
    }

    private Integer[][] cloneIntArrays(Integer[][] intArrays) {
        Integer[][] clonedIntArrays = new Integer[intArrays.length][];
        for (int i = 0; i < clonedIntArrays.length; i++) {
            clonedIntArrays[i] = Arrays.copyOf(intArrays[i], intArrays[i].length);
        }
        return clonedIntArrays;
    }

    class HeapMedianSort implements SortStrategy<Integer> {
        Median<Integer> media = new HeapMedian<Integer>();
        @Override
        public Integer[] sort(Integer[] items) {
            Integer value = media.getValue(items);
            return new Integer[] { value };
        }
    }

    class QuickMedianSort implements SortStrategy<Integer> {
        Median<Integer> media = new QuickMedian<>();
        @Override
        public Integer[] sort(Integer[] items) {
            Integer value = media.getValue(items);
            return new Integer[] { value };
        }
    }
}
