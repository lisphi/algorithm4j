package com.lishaopeng.algorithm.practice.puzzle.astar;

import com.lishaopeng.algorithm.practice.puzzle.PuzzleState;

public class AstarPuzzleState extends PuzzleState implements Comparable<AstarPuzzleState> {
    private int g = Integer.MAX_VALUE;
    private int h = Integer.MAX_VALUE;
    private int f = Integer.MAX_VALUE;

    public AstarPuzzleState(byte[] state) {
        super(state);
    }

    public AstarPuzzleState(byte[] state, int g) {
        super(state);
        this.g = g;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
        this.f = h + this.g;
    }

    public int getF() {
        return this.f;
    }

    @Override
    public int compareTo(AstarPuzzleState o) {
        if (this == o) {
            return 0;
        }
        return Integer.compare(this.getF(), o.getF());
    }
}

