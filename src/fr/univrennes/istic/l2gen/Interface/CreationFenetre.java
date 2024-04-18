package fr.univrennes.istic.l2gen.Interface;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.*;

/**
 * Cette classe représente un créateur de fenêtre pour l'interface utilisateur.
 * Elle permet de créer une fenêtre avec un titre spécifié et d'y ajouter une image.
 */
public class CreationFenetre {

    /**
     * Fenêtre créée par le créateur de fenêtre.
     */
    private JFrame fenetre;

    /**
     * Constructeur de la classe CreationFenetre.
     * Ce constructeur crée une fenêtre avec le titre spécifié et la rend visible.
     * La fenêtre se ferme lorsque l'utilisateur la ferme.
     *
     * @param nomFenetre Le titre de la fenêtre.
     */
    public CreationFenetre(String nomFenetre) {
        JFrame frame = new JFrame(nomFenetre);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.fenetre = frame;
    }

    /**
     * Méthode pour récupérer la fenêtre créée.
     *
     * @return La fenêtre créée.
     */
    public JFrame getFenetre() {
        return fenetre;
    }

    /**
     * Ajoute une image à un composant spécifié avec une taille spécifiée.
     *
     * @param composant   Le composant auquel ajouter l'image.
     * @param cheminImage Le chemin de l'image à ajouter.
     * @param width       La largeur de l'image.
     * @param height      La hauteur de l'image.
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
    }
}
