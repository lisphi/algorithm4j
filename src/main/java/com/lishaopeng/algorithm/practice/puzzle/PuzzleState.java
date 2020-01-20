package com.lishaopeng.algorithm.practice.puzzle;

import java.util.Arrays;

public class PuzzleState {
    protected byte[] state;
    private int backIndex = -1;

    public PuzzleState(byte[] state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        return 0x0369a877 ^ Arrays.hashCode(state);
    }

    public byte[] getState() {
        return state;
    }

    public int getBackIndex() {
        return backIndex;
    }

    public void setBackIndex(int backIndex) {
        this.backIndex = backIndex;
    }

    public int getValue() {
        int value = 0;
        for (int i = 0; i < state.length; i++) {
            value += state[i] * Math.pow(10, i);
        }
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PuzzleState)) {
            return false;
        }
        PuzzleState objPuzzleState = (PuzzleState)obj;
        if (objPuzzleState.state == this.state) {
            return true;
        }
        if (objPuzzleState.state.length != this.state.length) {
            return false;
        }
        for (int i = 0; i < objPuzzleState.state.length; i++) {
            if (objPuzzleState.state[i] != this.state[i]) {
                return false;
            }
        }
        return true;
    }

    public static PuzzleState of(byte[] state) {
        return new PuzzleState(state);
    }
}