package es.upm.miw.mastermind;

import es.upm.miw.mastermind.controllers.IOConsoleController;
import es.upm.miw.mastermind.models.GameController;

public class Mastermind {

    private final static int DIMENSION = 4;

    private static final int NUMBER_OF_PLAYERS = 2;

    private static final String PATTERN_PLAY = "[ABNRVZ]{%d}";

    public static void main(String[] args) {
        new GameController(DIMENSION, new IOConsoleController(), NUMBER_OF_PLAYERS, PATTERN_PLAY).launch();
    }

}
