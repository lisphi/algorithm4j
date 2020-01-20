package com.lishaopeng.algorithm.practice.puzzle.astar;

import com.lishaopeng.algorithm.hash.SimpleHashMap;
import com.lishaopeng.algorithm.linear.array.SimpleArrayList;
import com.lishaopeng.algorithm.practice.puzzle.PuzzleState;
import com.lishaopeng.algorithm.practice.puzzle.SlidePuzzle;
import com.lishaopeng.algorithm.tree.binary.BinaryHeap;

public class AstarSlidePuzzle extends SlidePuzzle {
    private ScoreStrategy scoreStrategy;

    public AstarSlidePuzzle(byte row, byte column) {
        this(row, column, null, (byte)-1, null);
    }

    public AstarSlidePuzzle(byte row, byte column, ScoreStrategy scoreStrategy) {
        this(row, column, null, (byte)-1,  scoreStrategy);
    }

    public AstarSlidePuzzle(byte row, byte column, byte[] endState, byte blankNum) {
        this(row, column, endState, blankNum, null);
    }

    public AstarSlidePuzzle(byte row, byte column, byte[] endState, byte blankNum, ScoreStrategy scoreStrategy) {
        super(row, column, endState, blankNum);
        if (scoreStrategy == null) {
            scoreStrategy = new ManhattanDistanceScoreStrategy(row, column);
        }
        this.scoreStrategy = scoreStrategy;
    }

    public void setHScore(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    @Override
    public byte[][] resolve(byte[] state) {
        AstarPuzzleState startPuzzleState = createPuzzleState(state, 0);
        SimpleHashMap<AstarPuzzleState, Object> puzzleStateSet = new SimpleHashMap<>();
        SimpleArrayList<AstarPuzzleState> visitedPuzzleStates = new SimpleArrayList<>();

        BinaryHeap<AstarPuzzleState> openTable = new BinaryHeap<AstarPuzzleState>(1024, false);
        openTable.insert(startPuzzleState);
        while (openTable.size() > 0) {
            AstarPuzzleState puzzleState = openTable.removeTop();
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
            for (PuzzleState pState : nextPuzzleStates) {
                AstarPuzzleState nextPuzzleState = (AstarPuzzleState)pState;
                nextPuzzleState.setG(puzzleState.getG() + 1);
                updateHscore(nextPuzzleState);
                nextPuzzleState.setBackIndex(fromIndex);
                openTable.insert(nextPuzzleState);
            }
        }

        return getVisitedStates(visitedPuzzleStates);
    }

    @Override
    public AstarPuzzleState createPuzzleState(byte[] state) {
        return new AstarPuzzleState(state);
    }

    private AstarPuzzleState createPuzzleState(byte[] state, int g) {
        AstarPuzzleState puzzleState = new AstarPuzzleState(state, g);
        int h = scoreStrategy.getHeuristicScore(state, endPuzzleState.getState());
        puzzleState.setH(h);
        return puzzleState;
    }

    private void updateHscore(AstarPuzzleState pluzzleState) {
        pluzzleState.setH(scoreStrategy.getHeuristicScore(pluzzleState.getState(), endPuzzleState.getState()));
    }
}
