package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.Map;

public class FirstEmptyStrategy implements AiStrategy {
    @Override
    public int getMove(Map<Integer, Sign> field) {
        return field.entrySet().stream()
                .filter(e -> e.getValue() == Sign.EMPTY)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }
}
