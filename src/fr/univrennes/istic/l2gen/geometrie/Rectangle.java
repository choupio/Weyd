package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe Rectangle représente un rectangle défini par sa largeur, sa hauteur
 * et son centre.
 */
public class Rectangle implements IForme {

    private double largeur; // Largeur du rectangle
    private double hauteur; // Hauteur du rectangle
    private Point centre; // Centre du rectangle
    private String couleur = "white"; // Couleur du rectangle en "white"
    private int angle = 0; // angle du rectangle, à 0 de base

    /**
     * Retourne le centre du rectangle.
     *
     * @return Le centre du rectangle.
     */
    public Point centre() {
        return centre;
    }

    /**
     * Retourne la largeur du rectangle.
     *
     * @return La largeur du rectangle.
     */
    public double largeur() {
        return largeur;
    }

    /**
     * Retourne la hauteur du rectangle.
     *
     * @return La hauteur du rectangle.
     */
    public double hauteur() {
        return hauteur;
    }

    /**
     * Définit la largeur du rectangle.
     *
     * @param largeur La largeur du rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme setLargeur(double largeur) {
        this.largeur = largeur;
        return this;
    }

    /**
     * Définit la hauteur du rectangle.
     *
     * @param hauteur La hauteur du rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme setHauteur(double hauteur) {
        this.hauteur = hauteur;
        return this;
    }

    /**
     * Constructeur de la classe Rectangle.
     *
     * @param x       La coordonnée x du centre du rectangle.
     * @param y       La coordonnée y du centre du rectangle.
     * @param largeur La largeur du rectangle.
     * @param hauteur La hauteur du rectangle.
     */
    public Rectangle(double x, double y, double largeur, double hauteur) {
        this.centre = new Point(x - (largeur / 2), y - (hauteur / 2));
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Constructeur de la classe Rectangle.
     *
     * @param p       Le centre du rectangle.
     * @param largeur La largeur du rectangle.
     * @param hauteur La hauteur du rectangle.
     */
    public Rectangle(Point p, double largeur, double hauteur) {
        this.centre = p;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Retourne une description du rectangle avec une indentation spécifiée.
     *
     * @param indentation Le niveau d'indentation pour la description.
     * @return Une chaîne de caractères décrivant le rectangle.
     */
    @Override
    public String description(int indentation) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            indent.append(" ");
        }
        return indent + "Rectangle" + indent + "Centre=" + centre.x() + "," + centre.y() + " L=" + largeur() + " H="
                + hauteur() + " de couleur " + couleur + " angle=" + angle;
    }

    /**
     * Déplace le centre du rectangle selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme deplacer(double dx, double dy) {
        this.centre.plus(dx, dy);
        return this;
    }

    /**
     * Duplique le rectangle.
     *
     * @return Une nouvelle instance du rectangle avec les mêmes propriétés.
     */
    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Rectangle nouvelleForme = new Rectangle(this.centre(), this.largeur(), this.hauteur());
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    /**
     * Ré-ajuste la hauteur et la largeur du rectangle.
     *
     * @param hauteur La nouvelle hauteur du rectangle.
     * @param largeur La nouvelle largeur du rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme redimmensioner(double hauteur, double largeur) {
        this.setHauteur(this.hauteur * hauteur);
        this.setLargeur(this.largeur * largeur);
        return this;
    }

    /**
     * Génère une représentation SVG du rectangle.
     *
     * @return Une chaîne de caractères représentant le rectangle en format SVG.
     */
    public String enSVG() {
        return "<rect x=\"" + centre().x() + "\" y=\"" + centre().y() + "\" height=\"" + hauteur() + "\" width=\""
                + largeur()
                + "\"\n" + "\t" + "fill=\"" + couleur + "\"" + " stroke=\"black\" transform=\"rotate(" + angle
                + ")\"/>";
    }

    /**
     * Change la couleur du rectangle.
     *
     * @param couleurs Un tableau de couleurs à appliquer au rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    /**
     * Crée un fichier SVG représentant le rectangle.
     */
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("Rectangle.svg"));
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
            }
        }
    }

    public IForme tourner(int angle) {
        this.angle = angle;
        return this;
    }

    public IForme aligner(Alignement alignement, double cible) {
        throw new UnsupportedOperationException("Unimplemented method 'aligner'");

    }
}
