package com.lishaopeng.algorithm.practice.puzzle;

import com.lishaopeng.algorithm.hash.SimpleHashMap;
import com.lishaopeng.algorithm.linear.array.SimpleArrayList;
import com.lishaopeng.algorithm.linear.queue.ArrayQueue;
import com.lishaopeng.algorithm.linear.stack.ArrayStack;

import java.util.Arrays;
import java.util.Random;

public abstract class SlidePuzzle {
    protected static Object object = new Object();
    protected PuzzleState endPuzzleState;
    private byte column;
    private byte row;
    private byte blankNum;

    public SlidePuzzle(byte row, byte column) {
        this(row, column, null, (byte)-1);
    }

    public SlidePuzzle(byte row, byte column, byte[] endState, byte blankNum) {
        this.row = row;
        this.column = column;
        if (blankNum == -1) {
            blankNum = (byte)(column * row - 1);
        }
        this.blankNum = blankNum;
        if (endState == null) {
            endState = new byte[column * row];
            for (byte i = 0; i < column * row; i++) {
                endState[i] = i;
            }
        }
        this.endPuzzleState = PuzzleState.of(endState);
    }

    public abstract byte[][] resolve(byte[] state);

    public abstract PuzzleState createPuzzleState(byte[] state);

    public byte[] shuffle() {
        byte[][] states = listAllStates();
        return states[new Random().nextInt(states.length)];
    }

    public byte[][] listAllStates() {
        SimpleHashMap<PuzzleState, Object> stateMap = new SimpleHashMap<>(1048576);
        ArrayQueue<PuzzleState> queue = new ArrayQueue<>(1048576);
        queue.offer(endPuzzleState);
        while (queue.size() > 0) {
            PuzzleState puzzleState = queue.poll();
            if (stateMap.containsKey(puzzleState)) {
                continue;
            }
            stateMap.put(puzzleState, object);
            SimpleArrayList<PuzzleState> nextPuzzleStates = getNextPuzzleStates(puzzleState);
            for (PuzzleState nextPuzzleState : nextPuzzleStates) {
                queue.offer(nextPuzzleState);
            }
        }
        byte[][] keys = new byte[stateMap.size()][];
        int i = 0;
        for (PuzzleState puzzleState : stateMap.keySet()) {
            keys[i++] = puzzleState.getState();
        }
        return keys;
    }

    protected SimpleArrayList<PuzzleState> getNextPuzzleStates(PuzzleState puzzleState) {
        SimpleArrayList<PuzzleState> nextPuzzleStates = new SimpleArrayList<PuzzleState>();
        byte[] currentState = puzzleState.getState();
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                int index = y * column + x;
                if (currentState[index] == blankNum) {
                    if (x - 1 >= 0) {
                        appendNextPuzzleStates(nextPuzzleStates, currentState, y * column + x - 1, index);
                    }
                    if (x + 1 < column) {
                        appendNextPuzzleStates(nextPuzzleStates, currentState, y * column + x + 1, index);
                    }
                    if (y - 1 >= 0) {
                        appendNextPuzzleStates(nextPuzzleStates,currentState, (y - 1) * column + x, index);
                    }
                    if (y + 1 < row) {
                        appendNextPuzzleStates(nextPuzzleStates, currentState, (y + 1) * column + x, index);
                    }
                    return nextPuzzleStates;
                }
            }
        }
        return nextPuzzleStates;
    }

    protected byte[][] getVisitedStates(SimpleArrayList<? extends PuzzleState> visitedPuzzleStates) {
        if (visitedPuzzleStates.size() == 0) {
            return null;
        }
        ArrayStack<PuzzleState> puzzleStateStack = new ArrayStack<PuzzleState>();
        PuzzleState visitePuzzleState = visitedPuzzleStates.get(visitedPuzzleStates.size() - 1);
        if (!visitePuzzleState.equals(endPuzzleState)) {
            return null;
        }
        while (visitePuzzleState != null) {
            puzzleStateStack.push(visitePuzzleState);
            if (visitePuzzleState.getBackIndex() < 0) {
                break;
            }
            visitePuzzleState = visitedPuzzleStates.get(visitePuzzleState.getBackIndex());
        }
        puzzleStateStack.size();
        byte[][] states = new byte[puzzleStateStack.size()][];
        int i = 0;
        while (puzzleStateStack.size() > 0) {
            visitePuzzleState = puzzleStateStack.pop();
            states[i++] = visitePuzzleState.getState();
        }
        return states;
    }

    private void appendNextPuzzleStates(
            SimpleArrayList<PuzzleState> puzzleStates,
            byte[] currentState,
            int swapIndex,
            int blankIndex) {
        byte[] nextState = getNextState(currentState, swapIndex, blankIndex);
        puzzleStates.add(createPuzzleState(nextState));
    }

    private byte[] getNextState(final byte[] state, int swapIndex, int blankIndex) {
        byte[] nextState = Arrays.copyOf(state, state.length);
        nextState[blankIndex] = state[swapIndex];
        nextState[swapIndex] = state[blankIndex];
        return nextState;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getBlankNum() {
        return blankNum;
    }


}
