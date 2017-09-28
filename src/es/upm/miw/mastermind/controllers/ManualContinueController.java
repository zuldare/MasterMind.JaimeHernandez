package es.upm.miw.mastermind.controllers;

import es.upm.miw.mastermind.utils.Message;

public class ManualContinueController extends ContinueController { 
    
    public ManualContinueController(IOController ioController){
        super(ioController);
    } 
    
    @Override
    public boolean keepPlaying() {
        String playerYesNo;
        boolean ok = false;
        do {
            playerYesNo = ioController.readString(Message.PLAY_AGAIN.toString()).toUpperCase();
            ok = ( YES.equals(playerYesNo) || NO.equals(playerYesNo));
        } while(!ok);
        
        return YES.equals(playerYesNo);
    }
    
     
    
    

}
