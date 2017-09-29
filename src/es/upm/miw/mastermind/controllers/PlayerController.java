package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Combination;

public abstract class PlayerController {

    protected ColorCombinationGeneratorController colorCombinationGeneratorController;

    protected int dimension;

    public PlayerController(int dimension, ColorCombinationGeneratorController colorCombinationGeneratorController) {
        assert dimension > 0;
        assert colorCombinationGeneratorController != null;
        this.dimension = dimension;
        this.colorCombinationGeneratorController = colorCombinationGeneratorController;
    }

    public abstract Combination generateCombination();

}
