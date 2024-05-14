package fr.univrennes.istic.l2gen.Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Panel_Image extends JPanel {
    private BufferedImage image;

    public Panel_Image(String chemin) {
        try {
            image = ImageIO.read(new File(chemin));
        } catch (IOException ex) {
            // Gérer les exceptions
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            return new Dimension(image.getWidth(), image.getHeight());
        }
        return super.getPreferredSize();
    }
}
