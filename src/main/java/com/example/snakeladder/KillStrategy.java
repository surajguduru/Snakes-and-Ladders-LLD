package com.example.snakeladder;

import java.util.List;

public interface KillStrategy {
    void handle(int currentPosition, List<Player> players);
}
