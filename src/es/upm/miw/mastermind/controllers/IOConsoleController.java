package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.utils.IO;
import es.upm.miw.mastermind.views.IOView;

public class IOConsoleController extends IOController implements IOView {

    public IOConsoleController() {
        super(new IO());
    }

    @Override
    public String readString(String title) {
        return ioView.readString(title);
    }

    @Override
    public String readStringYesNo(String title) {
        return ioView.readStringYesNo(title);
    }

    @Override
    public int readInt(String title) {
        return ioView.readInt(title);
    }

    @Override
    public void writeln() {
        ioView.writeln();
    }

    @Override
    public void write(String title) {
        ioView.write(title);
    }

    @Override
    public void writeln(String title) {
        ioView.writeln(title);
    }

}
