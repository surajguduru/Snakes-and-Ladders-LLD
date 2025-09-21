package com.example.snakeladder;

import java.util.List;

public class EliminateKillStrategy implements KillStrategy {
    @Override
    public void handle(int currentPosition, List<Player> players) {
        for(Player player : players) {
            if(player.getPosition() == currentPosition) {
                player.setPosition(0);
            }
        }

        return;
    }
    
}
