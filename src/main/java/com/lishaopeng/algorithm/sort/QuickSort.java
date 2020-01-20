package com.lishaopeng.algorithm.sort;

public class QuickSort<E extends Comparable<E>> implements SortStrategy<E>  {
    @Override
    public E[] sort(E[] items) {
        if (items == null || items.length < 2 ) {
            return items;
        }
        sort(items, 0, items.length - 1);
        return items;
    }

    private void sort(E[] items, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(items, start, end);
        sort(items, start, pivot);
        sort(items, pivot + 1, end);
    }

    private int partition(E[] items, int start, int end) {
        // 1. 随便找一个支点位置 pivot
        int pivot = (start + end) / 2;
        // 2. 将支点元素保存到本地变量 pivotItem
        E pivotItem = items[pivot];
        // 3. 将数组第0个元素挪到数组的支点位置 pivot ，把第0个位置空出来方便后续挪动元素
        items[pivot] = items[start];
        // 4. 把支点位置设置到第0
        pivot = start;
        // 5. 从第1个元素开始遍历数组
        // 5.1. 当前元素比 pivotItem 小
        // 5.1.1 将当前元素挪到支点位置
        // 5.1.2 将支点位置向右挪一步
        // 5.1.3 将支点位置的元素挪到当前元素的位置，保持支点位置的元素始终空出
        // 5.2. 当前元素不比 pivotItem 小，继续遍历
        for (int i = start + 1; i <= end; i++) {
            if (compare(items[i], pivotItem) < 0) {
                items[pivot] = items[i];
                pivot++;
                items[i] = items[pivot];
            }
        }
        // 将最开始保持的支点元素 pivotItem 填入当前支点位置
        items[pivot] = pivotItem;
        // 此时支点位置已经在合适的位置，其左边的元素都比它小，右边的元素都不小于它
        return pivot;
    }
}
