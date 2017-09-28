package es.upm.miw.mastermind.models;
 
import es.upm.miw.mastermind.controllers.IOConsoleController;
import es.upm.miw.mastermind.controllers.IOController;
import es.upm.miw.mastermind.controllers.ManualColorCombinationGenerator;
import es.upm.miw.mastermind.controllers.ManualContinueController;
import es.upm.miw.mastermind.controllers.ComputerContinueController;
import es.upm.miw.mastermind.controllers.ComputerPlayerController;
import es.upm.miw.mastermind.controllers.ContinueController;
import es.upm.miw.mastermind.controllers.PlayerController;
import es.upm.miw.mastermind.controllers.ManualPlayerController;
import es.upm.miw.mastermind.controllers.RandomColorCombinationGenerator;
import es.upm.miw.mastermind.utils.Message;
import es.upm.miw.mastermind.utils.State;

public class Game {
    
    private final static int DIMENSION = 4; 
    private static final int NUMBER_OF_PLAYS = 2;
    private static final int NUMBER_OF_PLAY_MODES = 2;
    private static final int DEFAULT_PLAY_MODE = 1;
    private static final int NUMBER_OF_PLAYERS = 2; 
    
    private static final String PATTERN_PLAY = "[ABNRVZ]{%d}";
    
    private int dimension; 
    private IOController ioController; 
    private PlayerController[] players;
    private ContinueController continueController;
    private Board board; 
    private State state;

    public static void main(String[] args) {
        new Game(DIMENSION, new IOConsoleController(),NUMBER_OF_PLAYERS).launch();
    }
    
    public Game(int dimension, IOController ioController, int numberOfPlayers) {
        assert dimension > 0;
        assert ioController != null;
        this.dimension = dimension;
        this.ioController = ioController;
        this.state = State.INITIAL;  
        this.players = new  PlayerController [numberOfPlayers];
        this.board = new Board(this.ioController, new RandomColorCombinationGenerator(this.dimension, this.ioController, PATTERN_PLAY)); 
    } 
  
    public void launch() {
        do {
            play();
            if (continueController.keepPlaying()){
                state = State.IN_GAME;
            } else {
                printGoodByeMessage();
                state = State.EXIT;
            }
        } while (state != State.EXIT);
        System.exit(1);
    } 
    
    private void play() { 
        printWellcomeMessage();         
        int playMode = readPlayMode();
        
        setPlayers(playMode);
        setContinueController(playMode);
        
        board.setSecretBoardCombination();
        printComputerPlayerSecretCombination();
        
        int numberOfRounds = 0;
        boolean victory = false;
        Combination playerCombination = null; 
        do {
            playerCombination = players[1].generateCombination();
            victory = board.matchesWithSecretCombination(playerCombination);
            if (!victory){
                numberOfRounds++;
                board.writeResultCombination(playerCombination);
            } 
        } while (numberOfRounds < NUMBER_OF_PLAYS && !victory);

        if (numberOfRounds == NUMBER_OF_PLAYS) {
            printNoMoreRoundsMessage();
            writeColorsToStringMessage(board.getSecretBoardCombination()); 
        }
    }
    
    private int readPlayMode(){ 
        int option = DEFAULT_PLAY_MODE;
        boolean ok = false;
        do {
            option = ioController.readInt(Message.OPTION.toString());
            ok = (option > 0 && option <= NUMBER_OF_PLAY_MODES);
        } while (!ok);
        return option;
    }
    
    private void setPlayers(int playMode) {
        players[0] = new ComputerPlayerController(dimension, new RandomColorCombinationGenerator(this.dimension, this.ioController, PATTERN_PLAY));  
        if (playMode == 1) { 
            players[1] = new ManualPlayerController(dimension, new ManualColorCombinationGenerator(this.dimension, this.ioController, PATTERN_PLAY)); 
        } else {
            players[1] = new ComputerPlayerController(dimension, new RandomColorCombinationGenerator(this.dimension, this.ioController, PATTERN_PLAY));
        }
    }
    
    private void setContinueController(int playMode){
        if (playMode == 1){
            this.continueController = new ManualContinueController(this.ioController);
        } else {
            this.continueController = new ComputerContinueController(this.ioController);
        }
    }
    
    private void printWellcomeMessage() {
        ioController.writeln(Message.WELLCOME.toString());
        ioController.writeln(Message.GAME_OPTION_HUMAN.toString());
        ioController.writeln(Message.GAME_OPTION_CPU.toString());
    }
     
    
    private void printComputerPlayerSecretCombination() {  
        for (int i = 0; i < this.dimension; i++) {
            ioController.write(Message.SECRET.toString());
        }
        ioController.writeln();
    } 
    
    private void printNoMoreRoundsMessage() {
        ioController.writeln(Message.CONTINUE.toString());
    }
    
    private void writeColorsToStringMessage(Combination combination) { 
        ioController.writeln(String.format(Message.SECRET_WAS.toString(), combination.toString()));
    }
    
    private void printGoodByeMessage() {
        ioController.writeln(Message.GOODBYE.toString());
    }

}
