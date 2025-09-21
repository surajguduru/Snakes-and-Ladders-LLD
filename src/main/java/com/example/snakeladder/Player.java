package com.example.snakeladder;

import java.util.List;

public interface Player {
    String getSymbol();
    int getPosition();
    List<Integer> getLastMoves();
    
    void clearLastMoves();
    void addLastMove(int move);
    void setPosition(int position);
}
