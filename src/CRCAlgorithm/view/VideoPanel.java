package CRCAlgorithm.view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author C.Mateo
 */
public class VideoPanel extends JPanel {

    public VideoPanel() {
        // Crea un JLabel para mostrar el GIF
        ImageIcon gifIcon = new ImageIcon(getClass().getResource(""));
        
        JLabel gifLabel = new JLabel(gifIcon);

        // Agrega el JLabel al JPanel
        add(gifLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja el JPanel
    }
}
