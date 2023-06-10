package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.List;
import java.util.Map;

public class WinRuleStrategy implements AiStrategy {
    private final AiStrategy secondary;

    public WinRuleStrategy(AiStrategy secondary) {
        this.secondary = secondary;
    }

    @Override
    public int getMove(Map<Integer, Sign> field) {
        int result;

        result = getMove(field, Sign.NOUGHT);
        if (result >= 0) return result;
        result = getMove(field, Sign.CROSS);
        if (result >= 0) return result;
        result = secondary.getMove(field);

        return result;
    }

    private int getMove(Map<Integer, Sign> field, Sign sign) {
        for (List<Integer> winPossibility : WinPossibilities.values) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                    && field.get(winPossibility.get(0)) == sign
                    && field.get(winPossibility.get(2)) == Sign.EMPTY) {
                return winPossibility.get(2);
            }

            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(0)) == sign
                    && field.get(winPossibility.get(1)) == Sign.EMPTY) {
                return winPossibility.get(1);
            }

            if (field.get(winPossibility.get(1)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(1)) == sign
                    && field.get(winPossibility.get(0)) == Sign.EMPTY) {
                return winPossibility.get(0);
            }
        }

        return -1;
    }
}
