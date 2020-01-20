package com.lishaopeng.algorithm.practice.puzzle;

import com.lishaopeng.algorithm.practice.puzzle.astar.AstarSlidePuzzle;

public final class SlidePuzzleApp {
    public static void main(String[] args) {
        byte row = 4, column = 4;
        byte inputBlankNum = (byte)(row * column);

        SlidePuzzle puzzle = new AstarSlidePuzzle(row, column, null, (byte)(inputBlankNum - 1));
        // SlidePuzzle puzzle = new BfsSlidePuzzle(row, row, null, inputBlankNum - 1);

        if (args.length > 0) {
            if ("printAllStates".equals(args[0])) {
                printAllStates(puzzle);
            } else if ("printResolvePath".equals(args[0])) {
                printResolvePath(puzzle, INPUT_START_STATE_4x4_normal);
            }
        }
    }

    public static final byte[] INPUT_START_STATE_3x3_hard = new byte[] { 8, 6, 7, 2, 5, 4, 3, 9, 1 };
    public static final byte[] INPUT_START_STATE_3x3_normal = new byte[] { 3 ,5 ,4 ,7 ,1 ,8 ,2 ,6 ,9 };

    public static final byte[] INPUT_START_STATE_4x4_hard = new byte[] { 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16 };
    public static final byte[] INPUT_START_STATE_4x4_normal = new byte[] { 16, 2, 4, 8, 1, 5, 7, 3, 14, 9, 10, 11, 13, 6, 15, 12 };
    private static void printAllStates(SlidePuzzle puzzle) {
        System.out.println("== all states ==");
        byte[][] allStates = puzzle.listAllStates();
        for (byte[] state : allStates) {
            printStateLine(state);
        }
        System.out.format("total=%2d\n", allStates.length);
    }

    private static void printResolvePath(SlidePuzzle puzzle, byte[] inputStartState) {
        System.out.println("== path ==");
        long start = System.currentTimeMillis();
        byte[] startState = new byte[inputStartState.length];
        for (int i = 0; i < inputStartState.length; i++) {
            startState[i] = (byte)(inputStartState[i] - 1);
        }
        byte[][] path = puzzle.resolve(startState);
        long elapsed = System.currentTimeMillis() - start;
        if (path == null) {
            System.out.println("no resolution");
            return;
        }
        for (byte[] state : path) {
            printStateRectange(puzzle, state);
        }
        System.out.format("%d steps, elapsed %d ms\n", path.length - 1, elapsed);
    }

    private static void printStateLine(byte[] state) {
        String comma = "";
        for (byte num : state) {
            System.out.print(comma);
            System.out.print(num);
            comma = "  ";
        }
        System.out.println();
    }

    private static void printStateRectange(SlidePuzzle puzzle, byte[] state) {
        int i = 0;
        for (int num : state) {
            if (num == puzzle.getBlankNum()) {
                System.out.print("__");
            } else {
                System.out.format("%2d", num + 1);
            }
            i++;
            if (i % puzzle.getColumn() == 0) {
                System.out.println();
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
        System.out.println("     |");
        System.out.println("     |");
        System.out.println("    \\'/");
        System.out.println();
    }

}
