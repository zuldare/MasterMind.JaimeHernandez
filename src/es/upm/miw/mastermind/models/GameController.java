package es.upm.miw.mastermind.models;
  
import es.upm.miw.mastermind.controllers.Game; 
import es.upm.miw.mastermind.controllers.IOController;  

public class GameController { 
    
    private Game game;   
    
    public GameController(int dimension, IOController ioController, int numberOfPlayers, String patternPlay) {
        assert dimension > 0;
        assert ioController != null; 
        this.game = new Game(dimension, ioController, patternPlay);    
    } 
  
    public void launch() {
        boolean keepPlaying = true;
         do {
            game.play(); 
            keepPlaying = game.keepPlaying();
        } while (keepPlaying);
        System.exit(1);
    }  
    
} 