package com.example.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer implements Player {
    private String symbol;
    private int position;
    private List<Integer> lastMoves = new ArrayList<>();

    public HumanPlayer(String symbol) {
        this.symbol = symbol;
        this.position = 0;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public java.util.List<Integer> getLastMoves() {
        return lastMoves;
    }

    @Override
    public void clearLastMoves() {
        lastMoves.clear();
    }

    @Override
    public void addLastMove(int move) {
        // Keeping only last 3 moves
        if (lastMoves.size() == 3) {
            lastMoves.remove(0);
        }
        lastMoves.add(move);
    }
}
