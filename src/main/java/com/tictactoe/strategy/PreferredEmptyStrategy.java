package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.List;
import java.util.Map;

public class PreferredEmptyStrategy implements AiStrategy {
    private static final List<Integer> preferredMoves =
            List.of(4, 0, 2, 6, 8, 1, 3, 5, 7);

    @Override
    public int getMove(Map<Integer, Sign> field) {
        for (Integer index: preferredMoves) {
            if (field.get(index) == Sign.EMPTY)
                return index;
        }

        return -1;
    }
}
