package com.example.snakeladder;

public interface Entity {
    int getStart();
    int getEnd();

    boolean isLadder();
    boolean isSnake();

}