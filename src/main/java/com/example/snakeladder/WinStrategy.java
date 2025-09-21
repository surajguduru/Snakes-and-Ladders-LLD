package com.example.snakeladder;

public interface WinStrategy {
    boolean hasWon(int currentPosition, int diceValue, int boardSize);
}
