package es.upm.miw.mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.mastermind.models.Combination;
import es.upm.miw.mastermind.utils.Color;
import es.upm.miw.mastermind.utils.Message;

public class RandomColorCombinationGenerator extends ColorCombinationGeneratorController {

    public RandomColorCombinationGenerator(int dimension, IOController ioController, String patternPlay) { 
        super(dimension, ioController, patternPlay); 
    }

    @Override
    public Combination generateCombination() {
        List<Color> colors = new ArrayList<Color>();
        for(int i=0;i<this.dimension;i++) {
             colors.add(Color.getRandom());
        }
        Combination combination = new Combination(dimension, colors);
        return combination;
    }  
}
