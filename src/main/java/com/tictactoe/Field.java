package com.tictactoe;

import com.tictactoe.strategy.AiStrategy;
import com.tictactoe.strategy.WinPossibilities;

import java.util.*;
import java.util.stream.Collectors;

public class Field {
    private final Map<Integer, Sign> field = new HashMap<>();
    private final AiStrategy strategy;

    public Field(AiStrategy strategy) {
        for (int i = 0; i < 9; i++) {
            field.put(i, Sign.EMPTY);
        }

        this.strategy = strategy;
    }

    public Map<Integer, Sign> getField() {
        return field;
    }

    public int getAiMove() {
        return strategy.getMove(field);
    }

    public List<Sign> getFieldData() {
        return field.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Sign checkWin() {
        return WinPossibilities.checkWin(field);
    }
}
