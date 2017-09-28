package es.upm.miw.mastermind.views;

public abstract class IOView {
    
    public abstract String readString(String title);

    public abstract String readStringYesNo(String title);

    public abstract int readInt(String title);

    public abstract void writeln();

    public abstract void write(String title);

    public abstract void writeln(String title);

}
