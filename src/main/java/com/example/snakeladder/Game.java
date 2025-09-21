package com.example.snakeladder;

import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final DiceService diceService;

    private final WinStrategy winStrategy;
    private final StartStrategy startStrategy;
    private final KillStrategy killStrategy;
    private final GameStrategy gameStrategy;

    private int currentPlayerIndex;

    private Game(Board board, List<Player> players, DiceService diceService, WinStrategy winStrategy, StartStrategy startStrategy, KillStrategy killStrategy, GameStrategy gameStrategy) {
        this.board = board;
        this.players = players;
        this.diceService = diceService;
        this.currentPlayerIndex = 0;
        this.winStrategy = winStrategy;
        this.startStrategy = startStrategy;
        this.killStrategy = killStrategy;
        this.gameStrategy = gameStrategy;
    }

    public void start() {
        while(true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            int diceValue = diceService.rollDice();
            currentPlayer.addLastMove(diceValue);

            if(!startStrategy.canStart(currentPlayer)) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                continue;
            }

            int newPosition = Math.min(currentPlayer.getPosition() + diceValue, board.n * board.n);
            for(Entity entity : board.entities) {
                if(entity.getStart() == newPosition) {
                    newPosition = entity.getEnd();
                    break;
                }
            }
            currentPlayer.setPosition(newPosition);

            killStrategy.handle(newPosition, players);

            if(winStrategy.hasWon(currentPlayer.getPosition(), diceValue, board.n * board.n)) {
                System.out.println("Player " + currentPlayer.getSymbol() + " has won the game!");
                break;
            }

            if(diceValue != 6) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players;
        private DiceService diceService;
        private WinStrategy winStrategy;
        private StartStrategy startStrategy;
        private KillStrategy killStrategy;
        private GameStrategy gameStrategy;

        public GameBuilder setWinStrategy(WinStrategy winStrategy) {
            this.winStrategy = winStrategy;
            return this;
        }

        public GameBuilder setStartStrategy(StartStrategy startStrategy) {
            this.startStrategy = startStrategy;
            return this;
        }

        public GameBuilder setKillStrategy(KillStrategy killStrategy) {
            this.killStrategy = killStrategy;
            return this;
        }

        public GameBuilder setGameStrategy(GameStrategy gameStrategy) {
            this.gameStrategy = gameStrategy;
            return this;
        }

        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public GameBuilder setDiceService(DiceService diceService) {
            this.diceService = diceService;
            return this;
        }

        public Board getBoard() {
            return board;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public DiceService getDiceService() {
            return diceService;
        }

        public WinStrategy getWinStrategy() {
            return winStrategy;
        }

        public StartStrategy getStartStrategy() {
            return startStrategy;
        }

        public KillStrategy getKillStrategy() {
            return killStrategy;
        }

        public GameStrategy getGameStrategy() {
            return gameStrategy;
        }

        public Game build() {
            Validation.validateGameBuilder(this);
            return new Game(board, players, diceService, winStrategy, startStrategy, killStrategy, gameStrategy);
        }
    }
}