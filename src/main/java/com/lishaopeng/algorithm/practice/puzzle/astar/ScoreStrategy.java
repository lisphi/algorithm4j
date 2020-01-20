package com.lishaopeng.algorithm.practice.puzzle.astar;

public interface ScoreStrategy {
    int getHeuristicScore(byte[] state, byte[] endState);
}
