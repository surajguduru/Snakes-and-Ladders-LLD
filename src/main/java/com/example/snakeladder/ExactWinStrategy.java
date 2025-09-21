package com.example.snakeladder;

public class ExactWinStrategy implements WinStrategy {
    @Override
    public boolean hasWon(int currentPosition, int diceValue, int boardSize) {
        return currentPosition + diceValue == boardSize;
    }
}
