package es.upm.miw.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.mastermind.controllers.ColorCombinationGeneratorController;
import es.upm.miw.mastermind.controllers.IOController;
import es.upm.miw.mastermind.utils.Color; 
import es.upm.miw.mastermind.utils.Message;

public class Board {
    private Combination secretCombination; 
    private IOController ioController;
    private ColorCombinationGeneratorController colorCombinationGeneratorController;

    public Board(IOController ioController, ColorCombinationGeneratorController colorCombinationGeneratorController){
        assert ioController != null;
        assert colorCombinationGeneratorController != null; 
        this.ioController = ioController; 
        this.colorCombinationGeneratorController = colorCombinationGeneratorController;
        this.secretCombination = null;
    } 
    
    public void setSecretBoardCombination() {
        this.secretCombination = colorCombinationGeneratorController.generateCombination();
    }
    
    public Combination getSecretBoardCombination(){
        return this.secretCombination;
    }
    
    public boolean matchesWithSecretCombination(Combination combination){
        assert(combination != null);
        return secretCombination.equals(combination);
    } 
     
    public void writeResultCombination(Combination combination) {
        assert(combination != null); 
        
        int injured = 0;
        int killed = 0;
        
        List<Color> colorAlreadyChecked = new ArrayList<Color>();
        for (int i=0;i<combination.dimension;i++){
            Color color = combination.getColorAtPosition(i);
            
            if (this.secretCombination.equalsColorAtPosition(color,i)){
              killed++;  
            } else {
                if (secretCombination.containsColor(color) && !colorAlreadyChecked.contains(color)){
                    injured++;
                } 
                colorAlreadyChecked.add(color);
            } 
        }
        printResultMessage(killed, injured); 
    }
    
    
    
    private void printResultMessage(int killed, int injured){ 
        ioController.writeln(this.getKilledMessage(killed) + this.getInjuredMessage(injured)); 
    } 
    
    private String getKilledMessage(int killed) {
        return String.format(Message.DEAD.toString(), killed) ;
    }
    
    private String getInjuredMessage(int injured) {
        return String.format(Message.INJURED.toString(), injured) ;
    }
    
    @Override
    public String toString() {
        if (this.secretCombination != null) {
            return this.secretCombination.toString();
        } else {
            return super.toString();
        }
    }
}
