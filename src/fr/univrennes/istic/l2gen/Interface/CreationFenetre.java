package fr.univrennes.istic.l2gen.Interface;

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
     * @param x           coordonnée x de l'emplacement de l'image
     * @param y           coordonnée y de l'emplacement de l'image
     * @param width       largeur de l'image
     * @param height      hauteur de l'image
     */
    public void ajouterImage(JComponent composant, String cheminImage, int x, int y, int width, int height) {
        // On charge l'image
        ImageIcon imageDeFond = new ImageIcon(cheminImage);
        // JLabel pour contenir l'image
        JLabel imageLabel = new JLabel(imageDeFond);
        // On définit l'emplacement et la taille du JLabel
        imageLabel.setBounds(x, y, width, height);
        // On désactive le LayoutManager
        composant.setLayout(null);
        // On ajoute le JLabel au composant
        composant.add(imageLabel);
        composant.revalidate();
        composant.repaint();
    }
}
