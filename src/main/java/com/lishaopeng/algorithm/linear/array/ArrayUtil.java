package com.lishaopeng.algorithm.linear.array;

public class ArrayUtil {
    public static void revertWord(char[] words) {
        if (words == null) {
            return;
        }
        revertChar(words,0, words.length - 1);
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == ' ') {
                revertChar(words, start, i - 1);
                start = i + 1;
            }
        }
        revertChar(words, start, words.length - 1);
    }

    private static void revertChar(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    private static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
