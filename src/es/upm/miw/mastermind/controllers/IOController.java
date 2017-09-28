package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.views.IOView;

public abstract class IOController {

    protected IOView ioView;

    public IOController(IOView ioView) {
        assert ioView != null;
        this.ioView = ioView;
    }

    public abstract String readString(String title);

    public abstract String readStringYesNo(String title);

    public abstract int readInt(String title);

    public abstract void writeln();

    public abstract void write(String title);

    public abstract void writeln(String title);

}
