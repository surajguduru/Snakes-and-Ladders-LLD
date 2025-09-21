package com.example.snakeladder;
import java.util.List;
import java.util.Random;

public class DiceService {
    private int NO_OF_DICE;
    private List<Integer> diceValues;
    private final Random random;

    public DiceService(int noOfDice, List<Integer> diceValues) {
        this.random = new Random();
        NO_OF_DICE = noOfDice;
        this.diceValues = diceValues;
    }

    public int rollDice() {
        int total = 0;
        for (int i = 0; i < NO_OF_DICE; i++) {
            int index = random.nextInt(diceValues.size());
            total += diceValues.get(index);
        }
        return total;
    }
}
