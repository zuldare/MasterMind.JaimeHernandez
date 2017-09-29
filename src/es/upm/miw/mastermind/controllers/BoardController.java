package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Board;
import es.upm.miw.mastermind.models.Combination;

public class BoardController {

    public Board board;

    public BoardController(int dimension, IOController ioController, String COMBINATION_PATTERN) {
        assert dimension > 0;
        this.board = new Board(new RandomSecretColorCombinationGenerator(dimension, ioController, COMBINATION_PATTERN));
    }

    public int getKilled(Combination combination) {
        assert (combination != null);
        return board.getKilled(combination);
    }

    public int getInjured(Combination combination) {
        assert (combination != null);
        return board.getInjured(combination);
    }

    public String getPlainSecretBoardCombination() {
        return board.getSecretBoardCombination().toString();
    }

    public void setSecretBoardCombination() {
        board.setSecretBoardCombination();
    }

    public boolean isVictory(Combination combination) {
        return board.matchesWithSecretCombination(combination);
    }

}
