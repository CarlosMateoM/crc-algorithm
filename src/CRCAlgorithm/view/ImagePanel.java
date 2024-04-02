package CRCAlgorithm.view;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImagePanel extends javax.swing.JPanel {
    
    private Image image;
    
    public ImagePanel(){
        
    }

    
    
    
    public void setImage(String path) {
         
        URL imageUrl = getClass().getResource(path);
        System.out.println(imageUrl.getPath());
        
        
        if (imageUrl != null) {
            image = new ImageIcon(imageUrl).getImage();
        } else {
            System.err.println("No se pudo cargar la imagen de fondo.");
        }
    }

    

   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja el GIF de fondo
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }


}
