package es.upm.miw.mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.mastermind.models.Combination;
import es.upm.miw.mastermind.utils.Color;
import es.upm.miw.mastermind.utils.Message;

public class ManualColorCombinationGenerator extends ColorCombinationGeneratorController {

    public ManualColorCombinationGenerator(int dimension, IOController ioController, String patternPlay) {
        super(dimension, ioController, patternPlay);
    }

    @Override
    public Combination generateCombination() {
        String combination = "";
        boolean ok = false;
        do {
            combination = ioController.readString(String.format(Message.READ_PLAY.toString(), this.dimension)).toUpperCase();
            ok = isOkPlayerPlayCombination(combination);
        } while (!ok);
        return new Combination(this.dimension, getListOfColors(combination));
    }

    private List<Color> getListOfColors(String combination) {
        List<Color> colors = new ArrayList<Color>();
        colors.clear();
        for (int i = 0; i < combination.length(); i++) {
            Color c = Color.getByStringCode(combination.substring(i, i + 1));
            colors.add(c);
        }
        return colors;
    }

}
