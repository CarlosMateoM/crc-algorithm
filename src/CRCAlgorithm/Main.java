package CRCAlgorithm;

import CRCAlgorithm.controller.Controller;
import CRCAlgorithm.handlers.CRCHandler;
import CRCAlgorithm.view.View;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author mateo092
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FlatLightLaf.setup();
        
        View view = new View();
        CRCHandler crcHandler = new CRCHandler();
        Controller controller = new Controller(view, crcHandler);
        
        view.addActionListener(controller);
        crcHandler.setCycleInterationListener(view);
        
        java.awt.EventQueue.invokeLater(() -> {
            view.setVisible(true);
        });
        
    }

}

  /*
        String inputBitstring = "10011110"; //secuencia de datos D
        String polynomialBitstring = "1001"; // geneardor G

        System.out.println(String.format("D = %s and G = %s", inputBitstring, polynomialBitstring));

        // Calcula el CRC
        String crc = crcRemainder(inputBitstring, polynomialBitstring, "0".repeat(polynomialBitstring.length() - 1));
        System.out.println("\nCRC: " + crc + "\n");

        // Simula un error en la transmisión
        String corruptedInput = injectError(inputBitstring);
        //System.out.println("Datos corruptos: " + corruptedInput);

        //Verifica el CRC
        boolean isValid = crcCheck(inputBitstring, polynomialBitstring, crc);

        if (isValid) {
            System.out.println("Error detectado en la transmisión.");
        } else {
            System.out.println("Los datos recibidos son válidos.");
        }*/