package es.upm.miw.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.mastermind.utils.Color;

public class Combination {
    
    protected List<Color> colors = new ArrayList<Color>();
    protected int dimension;
    
    public Combination(int dimension, List<Color> colors){
        assert dimension > 0;
        this.dimension = dimension; 
        this.colors = new ArrayList<Color>(colors);
    }
    
    public void setCombination(Color... colors) {
        for(Color color: colors){
            this.colors.add(color);
        }
    } 

    public boolean equalsColorAtPosition(Color color, int position) {
        assert color != null;
        assert position >0 && position <= dimension; 
        return getColorAtPosition(position) == color;
    }
    
    public Color getColorAtPosition(int position){
        assert position >0 && position <= dimension;
        return colors.get(position);
    }
    
    public boolean containsColor(Color color){
        assert color != null;
        return colors.contains(color);
    }
     
    
    @Override
    public String toString() {
        String result = "";
        for(Color color: colors){
            result = result + color.toString();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.colors.equals(obj); 
    }
}
