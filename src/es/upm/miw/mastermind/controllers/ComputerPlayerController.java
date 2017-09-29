package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Combination;

public class ComputerPlayerController extends PlayerController {

    public ComputerPlayerController(int dimension, IOController ioController, String patternPlay) {
        super(dimension, new RandomColorCombinationGenerator(dimension, ioController, patternPlay));
    }

    @Override
    public Combination generateCombination() {
        return colorCombinationGeneratorController.generateCombination();
    }

}
