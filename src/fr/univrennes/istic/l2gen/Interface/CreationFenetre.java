package fr.univrennes.istic.l2gen.Interface;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.*;

public class CreationFenetre {
    private JFrame fenetre;

    public CreationFenetre(String nomFenetre) {
        JFrame frame = new JFrame(nomFenetre);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.fenetre = frame;
    }

    public JFrame getFenetre() {
        return fenetre;
    }

    /**
     * Ajoute une image à la fenêtre à l'emplacement spécifié avec la taille
     * spécifiée.
     * 
     * @param cheminImage chemin de l'image
     * @param width       largeur de l'image
     * @param height      hauteur de l'image
     */
    public void ajouterImage(JComponent composant, String cheminImage, int width, int height) {

        // On charge l'image
        ImageIcon imageDeFond = new ImageIcon(
                new ImageIcon(cheminImage).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        // JLabel pour contenir l'image
        JLabel imageLabel = new JLabel(imageDeFond);

        // On définit le LayoutManager comme GridBagLayout pour centrer l'image
        composant.setLayout(new GridBagLayout());
        // On ajoute le JLabel au composant
        composant.add(imageLabel);
        composant.revalidate();
        composant.repaint();
        /*
         * // On charge l'image
         * ImageIcon imageDeFond = new ImageIcon(cheminImage);
         * // JLabel pour contenir l'image
         * JLabel imageLabel = new JLabel(imageDeFond);
         * // On définit l'emplacement et la taille du JLabel
         * imageLabel.setBounds(x, y, width, height);
         * // On désactive le LayoutManager
         * composant.setLayout(null);
         * // On ajoute le JLabel au composant
         * composant.add(imageLabel);
         * composant.revalidate();
         * composant.repaint();
         */
    }
}
