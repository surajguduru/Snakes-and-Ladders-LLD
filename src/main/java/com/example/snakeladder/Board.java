package com.example.snakeladder;

import java.util.List;

public class Board {
    int n;
    int[][] board;
    List<Entity> entities;

    public Board(int n, List<Entity> entities) {
        this.n = n;
        this.board = new int[n][n];
        this.entities = entities;
    }
}