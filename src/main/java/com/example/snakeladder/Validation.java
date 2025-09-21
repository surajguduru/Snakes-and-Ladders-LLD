package com.example.snakeladder;

import com.example.snakeladder.Game.GameBuilder;

public class Validation {
    public static boolean validateGameBuilder(GameBuilder gameBuilder) {
        if (gameBuilder.getBoard() == null) {
            throw new IllegalStateException("Board is not set");
        }
        if (gameBuilder.getPlayers() == null || gameBuilder.getPlayers().size() < 2) {
            throw new IllegalStateException("At least two players are required to start the game");
        }
        if (gameBuilder.getDiceService() == null) {
            throw new IllegalStateException("DiceService is not set");
        }
        if (gameBuilder.getWinStrategy() == null) {
            throw new IllegalStateException("WinStrategy is not set");
        }
        if (gameBuilder.getStartStrategy() == null) {
            throw new IllegalStateException("StartStrategy is not set");
        }
        if (gameBuilder.getKillStrategy() == null) {
            throw new IllegalStateException("KillStrategy is not set");
        }
        if (gameBuilder.getGameStrategy() == null) {
            throw new IllegalStateException("GameStrategy is not set");
        }
        return true;
    }
}
