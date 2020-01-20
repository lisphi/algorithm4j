package com.lishaopeng.algorithm.median;

public class QuickMedian<E extends Comparable<E>> implements Median<E> {
    @SuppressWarnings("unchecked")
    @Override
    public E getValue(E[] items) {
        if (items == null) {
            return null;
        }
        if (items.length == 1) {
            return items[0];
        }
        Object[] targetItems = (Object[])items;
        int targetLeft = 0;
        int targetRight = targetItems.length - 1;
        int targetMid = targetLeft + (targetRight - targetLeft) / 2;
        while (targetLeft < targetRight) {
            Object[] tmpItems = new Object[targetRight - targetLeft + 1];
            E baseValue = (E)targetItems[targetLeft + (targetRight - targetLeft)/2];
            int left = 0;
            int right = tmpItems.length - 1;
            int mid = targetMid - targetLeft;
            for (int i = targetLeft ; i <= targetRight; i++) {
                E current = (E)targetItems[i];
                if (compare(current, baseValue) < 0) {
                    tmpItems[left++] = current;
                } else if (compare(current, baseValue) > 0) {
                    tmpItems[right--] = current;
                }
            }
            if (left <= mid && mid <= right) {
                return baseValue;
            }
            if (left > mid) {
                targetLeft = 0;
                targetRight = left == 0 ? left : left - 1;
            } else if (right < mid) {
                targetRight -= targetLeft;
                targetLeft = right == tmpItems.length - 1 ? right : right + 1;
            }
            targetMid = mid;
            targetItems = tmpItems;
        }
        return (E)targetItems[targetMid];
    }
}
