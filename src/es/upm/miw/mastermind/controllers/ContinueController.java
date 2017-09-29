package es.upm.miw.mastermind.controllers;

public abstract class ContinueController {

    protected final String YES = "S";

    protected final String NO = "N";

    protected IOController ioController;

    public ContinueController(IOController ioController) {
        assert ioController != null;
        this.ioController = ioController;
    }

    public abstract boolean keepPlaying();
}
