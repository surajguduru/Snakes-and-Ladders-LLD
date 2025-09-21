package com.example.snakeladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.snakeladder.Game.GameBuilder;

public class Main {
    public static void main(String[] args) {

        List<Entity> entities = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("A"));
        players.add(new BotPlayer("B"));
        entities.add(new Snake(14, 7));
        entities.add(new Ladder(3, 22));
        entities.add(new Ladder(5, 8));
        entities.add(new Snake(17, 4));
        entities.add(new Snake(60, 21));
        entities.add(new Ladder(27, 81));
        Board board = new Board(10, entities);
        Game game = new Game.GameBuilder()
                .setBoard(board)
                .setPlayers(players)
                .setDiceService(new DiceService(2, List.of(1, 2, 3, 4, 5, 6)))
                .setWinStrategy(new ExactWinStrategy())
                .setStartStrategy(new SixStartStrategy())
                .setKillStrategy(new EliminateKillStrategy())
                .setGameStrategy(new DefaultGameStrategy())
                .build();

        game.start();
        System.out.println("The game has ended.");
        System.out.println("Final Positions: ");
        for(Player player : players) {
            System.out.println("Player " + player.getSymbol() + " has ended at position " + player.getPosition());
            System.out.println("Prev Moves: " + player.getLastMoves());
        }
        System.out.println("Thank you for playing :)");

        // Restart or exit game
        System.out.println("Wanna play again? :D");
        System.out.println("Enter 'yes' to play again or 'no' to exit.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("yes")) {
            main(args);
        } else {
            System.out.println("Exiting the game, bye!");
        }
    }
}
