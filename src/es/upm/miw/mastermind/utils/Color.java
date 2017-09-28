package es.upm.miw.mastermind.utils;

public enum Color {

    YELLOW("A"), 
    RED("R"), 
    GRREN("V"), 
    BLUE("Z"), 
    WHITE("B"), 
    BLACK("N");

    private String value;

    private Color(String value) {
        this.value = value; 
    }

    public String toString() {
        return value;
    }

    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
    
    public static Color getByStringCode(String code) { 
        for(Color c : Color.values()){
            if(code.equals(c.value)) {
                return Color.valueOf(c.name());
            }
        }
        return null;
    } 
}
