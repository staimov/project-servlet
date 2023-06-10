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
        for (List<Integer> winPossibility : WinPossibilities.values) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                    && field.get(winPossibility.get(0)) == Sign.NOUGHT
                    && field.get(winPossibility.get(2)) == Sign.EMPTY) {
                return winPossibility.get(2);
            }

            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(0)) == Sign.NOUGHT
                    && field.get(winPossibility.get(1)) == Sign.EMPTY) {
                return winPossibility.get(1);
            }

            if (field.get(winPossibility.get(1)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(1)) == Sign.NOUGHT
                    && field.get(winPossibility.get(0)) == Sign.EMPTY) {
                return winPossibility.get(0);
            }

            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                    && field.get(winPossibility.get(0)) == Sign.CROSS
                    && field.get(winPossibility.get(2)) == Sign.EMPTY) {
                return winPossibility.get(2);
            }

            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(0)) == Sign.CROSS
                    && field.get(winPossibility.get(1)) == Sign.EMPTY) {
                return winPossibility.get(1);
            }

            if (field.get(winPossibility.get(1)) == field.get(winPossibility.get(2))
                    && field.get(winPossibility.get(1)) == Sign.CROSS
                    && field.get(winPossibility.get(0)) == Sign.EMPTY) {
                return winPossibility.get(0);
            }
        }

        return secondary.getMove(field);
    }
}
