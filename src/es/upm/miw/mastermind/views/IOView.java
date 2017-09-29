package es.upm.miw.mastermind.views;

public interface IOView {

    public String readString(String title);

    public String readStringYesNo(String title);

    public int readInt(String title);

    public void writeln();

    public void write(String title);

    public void writeln(String title);

}
