package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Combination;

public class ComputerPlayerController extends PlayerController {
     
    
    public ComputerPlayerController(int dimension, ColorCombinationGeneratorController colorCombinationGeneratorController){
        super(dimension,colorCombinationGeneratorController);
    }

    @Override
    public Combination generateCombination() {
        return colorCombinationGeneratorController.generateCombination();
    }  

    
    
}
