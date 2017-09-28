package es.upm.miw.mastermind.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.upm.miw.mastermind.models.Combination;

public abstract class ColorCombinationGeneratorController {
    
    protected int dimension; 
    protected IOController ioController;
    protected String patternPlay;
    
    public ColorCombinationGeneratorController(int dimension, IOController ioController, String patternPlay){
        assert dimension > 0;
        assert ioController != null;
        assert patternPlay != null;
        this.dimension = dimension;
        this.ioController = ioController;
        this.patternPlay = patternPlay;
    }
    
    public abstract Combination generateCombination();
    
    
    protected boolean isOkPlayerPlayCombination(String string) {
        assert(string != null);
        Pattern pattern = Pattern.compile( String.format(patternPlay, dimension));
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
