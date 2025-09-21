package com.example.snakeladder;

import java.util.List;

public class SixStartStrategy implements StartStrategy {
    @Override
    public boolean canStart(Player player) {
        List<Integer> lastMoves = player.getLastMoves();
        return !lastMoves.isEmpty() && lastMoves.get(lastMoves.size() - 1) == 6;
    }
}
