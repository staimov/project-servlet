package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomEmptyStrategy implements AiStrategy {
    @Override
    public int getMove(Map<Integer, Sign> field) {
        List<Integer> emptyFieldKeys = field
                .keySet()
                .stream()
                .filter(key -> field.get(key) == Sign.EMPTY)
                .toList();

        if (emptyFieldKeys.isEmpty()) return -1;

        Random random = new Random();
        return emptyFieldKeys.get(random.nextInt(emptyFieldKeys.size()));
    }
}
