package es.upm.miw.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.mastermind.controllers.ColorCombinationGeneratorController;
import es.upm.miw.mastermind.utils.Color;

public class Board {

    private Combination secretCombination;

    private ColorCombinationGeneratorController colorCombinationGeneratorController;

    private int[] killedInjured = new int[2];

    public Board(ColorCombinationGeneratorController colorCombinationGeneratorController) {
        assert colorCombinationGeneratorController != null;
        this.colorCombinationGeneratorController = colorCombinationGeneratorController;
        this.secretCombination = null;
    }

    public void setSecretBoardCombination() {
        this.secretCombination = colorCombinationGeneratorController.generateCombination();
    }

    public Combination getSecretBoardCombination() {
        return this.secretCombination;
    }

    public boolean matchesWithSecretCombination(Combination combination) {
        assert (combination != null);
        return secretCombination.equals(combination);
    }

    public int getKilled(Combination combination) {
        calculateResultCombination(combination);
        return killedInjured[0];
    }

    public int getInjured(Combination combination) {
        calculateResultCombination(combination);
        return killedInjured[1];
    }

    private void calculateResultCombination(Combination combination) {
        assert (combination != null);

        int injured = 0;
        int killed = 0;

        List<Color> colorAlreadyChecked = new ArrayList<Color>();
        for (int i = 0; i < combination.dimension; i++) {
            Color color = combination.getColorAtPosition(i);

            if (this.secretCombination.equalsColorAtPosition(color, i)) {
                killed++;
            } else {
                if (secretCombination.containsColor(color) && !colorAlreadyChecked.contains(color)) {
                    injured++;
                }
                colorAlreadyChecked.add(color);
            }
        }
        this.killedInjured[0] = killed;
        this.killedInjured[1] = injured;
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
