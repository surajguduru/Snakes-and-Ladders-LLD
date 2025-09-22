# Snake and Ladder - Class Diagram

```mermaid
classDiagram
    class Game {
        -Board board
        -List<Player> players
        -DiceService diceService
        -WinStrategy winStrategy
        -StartStrategy startStrategy
        -KillStrategy killStrategy
        -GameStrategy gameStrategy
        +start()
        +makeMove(int diceRoll)
        +checkWinner(Player): boolean
    }

    class GameBuilder {
        +build(): Game
    }

    class Board {
        -int size
        -List<Entity> entities
        +display(): void
    }

    class Player {
        <<interface>>
        +makeMove(int diceRoll): void
        +getLastMoves(): List<Integer>
    }

    class HumanPlayer {
        -String name
        -String symbol
        -int position
        -List<Integer> lastMoves
    }

    class BotPlayer {
        -String name
        -String symbol
        -int position
        -List<Integer> lastMoves
    }

    class Entity {
        -int start
        -int end
        +apply(Player): void
    }

    class Snake
    class Ladder

    class DiceService {
        -int diceCount
        -List<Integer> faces
        +roll(): int
    }

    class WinStrategy {
        <<interface>>
        +hasWon(Player, int): boolean
    }

    class ExactWinStrategy
    class ExceedWinStrategy

    class StartStrategy {
        <<interface>>
        +canStart(Player, int): boolean
    }

    class SixStartStrategy

    class KillStrategy {
        <<interface>>
        +handle(Player, List<Player>): void
    }

    class CoExistKillStrategy
    class EliminateKillStrategy

    class GameStrategy {
        <<interface>>
        +nextPlayer(List<Player>, Player): Player
    }

    class DefaultGameStrategy

    %% Relationships
    Game *-- Board
    Game *-- Player
    Game *-- DiceService
    Game --> WinStrategy
    Game --> StartStrategy
    Game --> KillStrategy
    Game --> GameStrategy
    GameBuilder --> Game
    Board *-- Entity
    Entity <|-- Snake
    Entity <|-- Ladder
    Player <|.. HumanPlayer
    Player <|.. BotPlayer
    WinStrategy <|.. ExactWinStrategy
    WinStrategy <|.. ExceedWinStrategy
    StartStrategy <|.. SixStartStrategy
    KillStrategy <|.. CoExistKillStrategy
    KillStrategy <|.. EliminateKillStrategy
    GameStrategy <|.. DefaultGameStrategy
