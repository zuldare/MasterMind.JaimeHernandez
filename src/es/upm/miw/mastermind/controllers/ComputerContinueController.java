package es.upm.miw.mastermind.controllers;
 

public class ComputerContinueController extends ContinueController {
    
    public ComputerContinueController(IOController ioController){
        super(ioController);
    } 
    
    @Override
    public boolean keepPlaying() {
       return false;
    }
    

}
