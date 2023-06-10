package com.tictactoe.strategy;

import com.tictactoe.Sign;

import java.util.Map;

public interface AiStrategy {
    int getMove(Map<Integer, Sign> field);
}
