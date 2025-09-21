package com.example.snakeladder;

public class Snake implements Entity {
    private final int start;
    private final int end;

    public Snake(int start, int end) {
        if (start <= end) {
            throw new IllegalArgumentException("Snake's start must be greater than end.");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public boolean isLadder() {
        return false;
    }

    @Override
    public boolean isSnake() {
        return true;
    }

    @Override
    public int getEnd() {
        return end;
    }
    
}
