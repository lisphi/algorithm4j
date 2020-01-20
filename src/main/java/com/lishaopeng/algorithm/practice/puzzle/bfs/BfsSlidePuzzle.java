package com.lishaopeng.algorithm.practice.puzzle.bfs;

import com.lishaopeng.algorithm.hash.SimpleHashMap;
import com.lishaopeng.algorithm.linear.array.SimpleArrayList;
import com.lishaopeng.algorithm.linear.queue.ArrayQueue;
import com.lishaopeng.algorithm.practice.puzzle.PuzzleState;
import com.lishaopeng.algorithm.practice.puzzle.SlidePuzzle;

public class BfsSlidePuzzle extends SlidePuzzle {
    public BfsSlidePuzzle(byte row, byte column) {
        super(row, column);
    }

    public BfsSlidePuzzle(byte row, byte column, byte[] endState) {
        this(row, column, endState, (byte)-1);
    }

    public BfsSlidePuzzle(byte row, byte column, byte[] endState, byte blankNum) {
        super(row, column, endState, blankNum);
    }

    @Override
    public byte[][] resolve(byte[] state) {
        SimpleHashMap<PuzzleState, Object> puzzleStateSet = new SimpleHashMap<>();
        ArrayQueue<PuzzleState> queue = new ArrayQueue<>();
        queue.offer(PuzzleState.of(state));
        SimpleArrayList<PuzzleState> visitedPuzzleStates = new SimpleArrayList<PuzzleState>();

        while (queue.size() > 0) {
            PuzzleState puzzleState = queue.poll();
            if (puzzleStateSet.containsKey(puzzleState)) {
                continue;
            }
            puzzleStateSet.put(puzzleState, object);
            visitedPuzzleStates.add(puzzleState);
            if (endPuzzleState.equals(puzzleState)) {
                break;
            }
            int fromIndex = visitedPuzzleStates.size() - 1;
            SimpleArrayList<PuzzleState> nextPuzzleStates = getNextPuzzleStates(puzzleState);
            for (PuzzleState nextPuzzleState : nextPuzzleStates) {
                nextPuzzleState.setBackIndex(fromIndex);
                queue.offer(nextPuzzleState);
            }
        }

        return getVisitedStates(visitedPuzzleStates);
    }



    @Override
    public PuzzleState createPuzzleState(byte[] state) {
        return PuzzleState.of(state);
    }

}
