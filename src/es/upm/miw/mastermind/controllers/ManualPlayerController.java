package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.models.Combination;

public class ManualPlayerController extends PlayerController {

    public ManualPlayerController(int dimension, IOController ioController, String patternPlay) {
        super(dimension, new ManualColorCombinationGenerator(dimension, ioController, patternPlay));
    }

    @Override
    public Combination generateCombination() {
        return colorCombinationGeneratorController.generateCombination();
    }

}
