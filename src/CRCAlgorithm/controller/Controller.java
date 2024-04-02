package CRCAlgorithm.controller;

import CRCAlgorithm.handlers.CRCHandler;
import CRCAlgorithm.model.CRC;
import CRCAlgorithm.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mateo092
 */
public class Controller implements ActionListener{
    
    private View view;
    private CRCHandler crcHandler;

    public Controller(View view, CRCHandler crcHandler) {
        this.view = view;
        this.crcHandler = crcHandler;
    }
    
    
    private void initCRCAlgorithm() {
        CRC crc = view.getDataCRCAlgorithm();
        crcHandler.setCrc(crc);
        Thread thread = new Thread(crcHandler);
        thread.start();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand) {
            case "initCRCAlgorithmCmd": initCRCAlgorithm();
        }
    }
   
    
}
