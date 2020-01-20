package com.lishaopeng.algorithm.practice.puzzle.astar;

public class MisplacedTileScoreStrategy implements ScoreStrategy {
    @Override
    public int getHeuristicScore(byte[] state, byte[] endState) {
        int h = 0;
        for (int i = 0; i < endState.length; i++) {
            if (endState[i] != state[i]) {
                h++;
            }
        }
        return h;
    }
}
