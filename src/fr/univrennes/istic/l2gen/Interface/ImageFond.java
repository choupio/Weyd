package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import java.awt.*;

public class ImageFond extends JPanel {
    private Image imageDeFond;

    public ImageFond(String imagePath) {
        // On charge l'image
        imageDeFond = new ImageIcon(getClass().getResource(imagePath)).getImage();
        // TODO laissez moi gérer Signé le J
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // On met en arrière plan
        g.drawImage(imageDeFond, 0, 0, getWidth(), getHeight(), this);
    }
}
