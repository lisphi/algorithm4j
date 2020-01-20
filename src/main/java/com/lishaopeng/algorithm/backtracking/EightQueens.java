package com.lishaopeng.algorithm.backtracking;

import com.lishaopeng.algorithm.linear.array.SimpleArrayList;

import java.util.Arrays;

public class EightQueens {
    public static void main(String[] args) {
        int[] rows = new EightQueens().solve();
        for (int row = 0; row < rows.length; row++) {
            for (int column = 0; column < 8; column++) {
                System.out.print(rows[row] == column ? rows[row] + 1 : 0);
            }
            System.out.println();
        }
        int[][] arrayOfRows = new EightQueens().solveAll();
        System.out.format("total=%d\n", arrayOfRows.length);
    }

    public int[][] solveAll() {
        SimpleArrayList<int[]> list = new SimpleArrayList<>(100);

        int[] rows = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
        int rowIndex = 0;
        while (true) {
            int[] cloneRows = Arrays.copyOf(rows, rows.length);
            boolean success = recursiveMove(cloneRows, rowIndex);
            if (!success) {
                break;
            }
            list.add(cloneRows);
            rows = Arrays.copyOf(cloneRows, cloneRows.length);
            for (int i = rows.length - 1; i >= 0; i--) {
                if (rows[i] < 7) {
                    for (int j = i+1; j < rows.length; j++) {
                        rows[j] = -1;
                    }
                    rowIndex = i;
                    break;
                }
            }
        }
        int[][] results = new int[list.size()][];
        int i = 0;
        for (int[] row : list) {
            results[i++] = row;
        }
        return results;
    }

    public int[] solve() {
        int[] rows = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
        boolean success = recursiveMove(rows, 0);
        if (success) {
            return rows;
        } else {
            return new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
        }
    }

    private boolean recursiveMove(int[] rows, int rowIndex) {
        boolean moved = move(rows, rowIndex);
        if (moved) {
            if (rowIndex == 7) {
                return true;
            }
            return recursiveMove(rows, rowIndex + 1);
        } else {
            if (rowIndex == 0) {
                return false;
            }
            return recursiveMove(rows, rowIndex - 1);
        }
    }

    private boolean move(int[] rows, int rowIndex) {
        int pos = rows[rowIndex];
        for (int nextPos = pos + 1; nextPos < 8; nextPos++) {
            if (isNextPositionOK(rows, rowIndex, nextPos)) {
                rows[rowIndex] = nextPos;
                return true;
            }
        }
        rows[rowIndex] = -1;
        return false;
    }

    private boolean isNextPositionOK(int[] rows, int rowIndex, int nextPos) {
        for (int preRowIndex = 0; preRowIndex < rowIndex; preRowIndex++) {
            if (rows[preRowIndex] == nextPos) {
                return false;
            }
            int obliqueLeftPos = nextPos - (rowIndex - preRowIndex);
            int obliqueRightPos = nextPos + (rowIndex - preRowIndex);
            if (obliqueLeftPos >= 0 && rows[preRowIndex] == obliqueLeftPos ||
                    obliqueRightPos <= 7 && rows[preRowIndex] == obliqueRightPos) {
                return false;
            }
        }
        return true;
    }
}
