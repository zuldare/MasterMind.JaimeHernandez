package es.upm.miw.mastermind.utils;

public enum GameOption { 
    NUMBER_OF_PLAYS(10),
    NUMBER_OF_PLAY_MODES(2),
    NUMBER_OF_PLAYERS(2),
    DEFAULT_PLAY_MODE(1);    
    
    private int value;
    
    private GameOption(int value) {
        this.value = value; 
    }
    
    public int getIntValue(){
        return value;
    }
}
