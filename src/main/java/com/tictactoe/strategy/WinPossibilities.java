package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.List;
import java.util.Map;

public class WinPossibilities {
    public static final List<List<Integer>> values = List.of(
            List.of(0, 1, 2),
            List.of(3, 4, 5),
            List.of(6, 7, 8),
            List.of(0, 3, 6),
            List.of(1, 4, 7),
            List.of(2, 5, 8),
            List.of(0, 4, 8),
            List.of(2, 4, 6)
    );

    public static Sign checkWin(Map<Integer, Sign> field) {
        for (List<Integer> winPossibility : values) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                    && field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))) {
                return field.get(winPossibility.get(0));
            }
        }
        return Sign.EMPTY;
    }
}
