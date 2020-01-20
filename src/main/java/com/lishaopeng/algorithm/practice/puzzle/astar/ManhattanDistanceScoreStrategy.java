package com.lishaopeng.algorithm.practice.puzzle.astar;

public class ManhattanDistanceScoreStrategy implements ScoreStrategy {
    private byte column;
    private byte row;
    public ManhattanDistanceScoreStrategy(byte column, byte row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public int getHeuristicScore(byte[] state, byte[] endState) {
        byte[] axisX = new byte[state.length];
        byte[] axisY = new  byte[state.length];

        for (byte y = 0; y < row; y++) {
            for (byte x = 0; x < column; x++) {
                int index = y * column + x;
                axisX[state[index]] = x;
                axisY[state[index]] = y;
            }
        }
        int score = 0;
        for (byte y = 0; y < row; y++) {
            for (byte x = 0; x < column; x++) {
                int index = y * column + x;
                int deltaX = axisX[endState[index]] - x;
                int deltaY = axisY[endState[index]] - y;
                score += (deltaX >= 0 ? deltaX : -deltaX) + (deltaY >= 0 ? deltaY : -deltaY);
            }
        }
        return score;
    }
}
