package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PreferredWithRandomStrategy implements AiStrategy {
    private static final List<Integer> preferredMoves1 =
            List.of(4);
    private static final List<Integer> preferredMoves2 =
            List.of(0, 2, 6, 8);
    private static final List<Integer> preferredMoves3 =
            List.of(1, 3, 5, 7);

    @Override
    public int getMove(Map<Integer, Sign> field) {
        int result;

        result = getMove(field, preferredMoves1);
        if (result >= 0) return result;
        result = getMove(field, preferredMoves2);
        if (result >= 0) return result;
        result = getMove(field, preferredMoves3);

        return result;
    }

    private int getMove(Map<Integer, Sign> field, List<Integer> preferredMoves) {
        List<Integer> emptyFieldKeys = preferredMoves
                .stream()
                .filter(index -> field.get(index) == Sign.EMPTY)
                .toList();

        if (emptyFieldKeys.isEmpty()) return -1;

        Random random = new Random();
        return emptyFieldKeys.get(random.nextInt(emptyFieldKeys.size()));
    }
}
