package CRCAlgorithm.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class GifPanel extends javax.swing.JPanel {

    private Image image;

    public GifPanel() {
        super();
        setBackground(Color.WHITE);
        init();
    }

    private void init() {
        URL imageUrl = getClass().getResource("/CRCAlgorithm/resources/initial.gif");
        image = new ImageIcon(imageUrl).getImage();
    }

    public void setImage(String path) {

        URL imageUrl = getClass().getResource(path);

        if (imageUrl != null) {

            image = new ImageIcon(imageUrl).getImage();

            MediaTracker mediaTracker = new MediaTracker(this);
            
            mediaTracker.addImage(image, 0);
            
            try {
                mediaTracker.waitForID(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(GifPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            repaint();

            new Thread(() -> {
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GifPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                init();
            }).start();
        } else {
            System.err.println("No se pudo cargar la imagen de fondo.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
