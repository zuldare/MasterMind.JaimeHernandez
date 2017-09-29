package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Combination;
import es.upm.miw.mastermind.utils.Message;

public class Game {

    private IOController ioController;

    private BoardController boardController;

    private ContinueController continueController;

    private PlayerController[] players;

    private String patternPlay;

    private int dimension;

    private static final int NUMBER_OF_PLAYS = 10;

    private static final int NUMBER_OF_PLAY_MODES = 2;

    private static final int NUMBER_OF_PLAYERS = 2;

    private static final int DEFAULT_PLAY_MODE = 1;

    

    public Game(int dimension, IOController ioController, String pattern) {
        assert dimension > 0;
        assert ioController != null;
        assert pattern != null;
        
        this.dimension = dimension;
        this.ioController = ioController; 
        this.patternPlay = String.format(pattern, dimension);
        this.boardController = new BoardController(dimension, this.ioController, pattern);
        this.players = new PlayerController[NUMBER_OF_PLAYERS];
    }

    public void play() {
        writeWellcomeMessage();
        int playMode = readPlayMode();

        setPlayers(playMode);
        setContinueController(playMode);

        setSecretBoardCombination();
        writeHiddenComputerPlayerSecretCombination();

        int numberOfRounds = 0;
        boolean victory = false;
        Combination playerCombination = null;
        do {
            playerCombination = players[1].generateCombination();
            victory = isVictory(playerCombination);
            if (!victory) {
                numberOfRounds++;
                writeResultCombination(playerCombination);
            } else {
                writeVictory();
            }
        } while (numberOfRounds < NUMBER_OF_PLAYS && !victory);

        if (numberOfRounds == NUMBER_OF_PLAYS) {
            writeNoMoreRoundsMessage();
            writePlainComputerPlayerSecretCombination();
        }
    }

    private int readPlayMode() {
        int option = DEFAULT_PLAY_MODE;
        boolean ok = false;
        do {
            option = ioController.readInt(Message.OPTION.toString());
            ok = (option > 0 && option <= NUMBER_OF_PLAY_MODES);
        } while (!ok);
        return option;
    }

   private void setPlayers(int playMode) {
        players[0] = new ComputerPlayerController(this.dimension, this.ioController, this.patternPlay); 
        if (playMode == 1) {
            players[1] = new ManualPlayerController(this.dimension, this.ioController, this.patternPlay);
        } else {
            players[1] = new ComputerPlayerController(this.dimension, this.ioController, this.patternPlay);
        }
    }

    private void setContinueController(int playMode) {
        if (playMode == 1) {
            this.continueController = new ManualContinueController(this.ioController);
        } else {
            this.continueController = new ComputerContinueController(this.ioController);
        }
    }

    public boolean keepPlaying() {
        return this.continueController.keepPlaying();
    }

    public boolean isVictory(Combination combination) {
        return boardController.isVictory(combination);
    }

    private void writeWellcomeMessage() {
        ioController.writeln(Message.WELLCOME.toString());
        ioController.writeln(Message.GAME_OPTION_HUMAN.toString());
        ioController.writeln(Message.GAME_OPTION_CPU.toString());
    }

    private void writeResultCombination(Combination combination) {
        assert (combination != null);
        writeResultMessage(boardController.getKilled(combination), boardController.getInjured(combination));
    }

    private void writeHiddenComputerPlayerSecretCombination() {
        for (int i = 0; i < boardController.getPlainSecretBoardCombination().length(); i++) {
            ioController.write(Message.SECRET.toString());
        }
        ioController.writeln();
    }

    private void writePlainComputerPlayerSecretCombination() {
        ioController.writeln(String.format(Message.SECRET_WAS.toString(), boardController.getPlainSecretBoardCombination()));
    }
    
    private void writeVictory(){
        ioController.writeln(String.format(Message.VICTORY.toString(), this.dimension));
        
    }
    private void writeNoMoreRoundsMessage() {
        ioController.writeln(Message.CONTINUE.toString());
    }

    private void setSecretBoardCombination() {
        boardController.setSecretBoardCombination();
    }

    private void writeResultMessage(int killed, int injured) {
        ioController.writeln(this.getKilledMessage(killed) + this.getInjuredMessage(injured));
    }

    private String getKilledMessage(int killed) {
        return String.format(Message.DEAD.toString(), killed);
    }

    private String getInjuredMessage(int injured) {
        return String.format(Message.INJURED.toString(), injured);
    }
}
