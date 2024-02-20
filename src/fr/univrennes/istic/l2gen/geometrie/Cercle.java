package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cette classe représente un cercle dans un espace bidimensionnel.
 */
public class Cercle implements IForme {
    private Point point; // Le centre du cercle
    private double rayon; // Le rayon du cercle
    private String couleur; // La couleur du cercle en "black"

    /**
     * Constructeur pour initialiser un cercle avec les coordonnées du centre et le rayon.
     *
     * @param x     La coordonnée x du centre du cercle.
     * @param y     La coordonnée y du centre du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(double x, double y, double rayon) {
        this.point = new Point(x, y);
        this.rayon = rayon; // TODO gestion du cas rayon négatif
    }

    /**
     * Constructeur pour initialiser un cercle avec un point central et le rayon.
     *
     * @param point Le point central du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(Point point, double rayon) {
        this.point = point;
        this.rayon = rayon; // TODO gestion du cas rayon négatif
    }

    /**
     * Retourne le centre du cercle.
     *
     * @return Le centre du cercle.
     */
    @Override
    public Point centre() {
        return point;
    }

    /**
     * Retourne une description du cercle.
     *
     * @param x Le niveau d'indentation.
     * @return Une chaîne de caractères décrivant le cercle.
     */
    @Override
    public String description(int x) {
        String indentation = "";
        for (int i = 0; i < x; i++) {
            indentation += " ";
        }
        return (indentation + "Cercle centre= " + point.x() + ", " + point.y() + " r= " + rayon + " de couleur "
                + couleur);
    }

    /**
     * Retourne la hauteur du cercle, qui est égale à son diamètre.
     *
     * @return La hauteur du cercle.
     */
    @Override
    public double hauteur() {
        return rayon * 2;
    }

    /**
     * Retourne la largeur du cercle, qui est égale à son diamètre.
     *
     * @return La largeur du cercle.
     */
    @Override
    public double largeur() {
        return rayon * 2;
    }

    /**
     * Déplace le cercle selon les déplacements spécifiés.
     *
     * @param x Le déplacement en abscisse.
     * @param y Le déplacement en ordonnée.
     * @return Une référence à l'instance actuelle du cercle, pour permettre les opérations en chaîne.
     */
    public IForme deplacer(double x, double y) {
        point.plus(x, y);
        return this;
    }

    /**
     * Retourne une représentation SVG du cercle.
     *
     * @return Une chaîne de caractères représentant le cercle en format SVG.
     */
    @Override
    public String enSVG() {
        return "<circle cx=\"" + centre().x() + "\" cy=\"" + centre().y() + "\" r=\"" + hauteur() / 2 + "\"" + '\n'
                + " fill=\"" + couleur + "\" stroke=\"black\"/>";
    }

    /**
     * Duplique le cercle avec les mêmes propriétés.
     *
     * @return Une nouvelle instance de la classe Cercle avec les mêmes propriétés.
     */
    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Cercle nouvelleForme = new Cercle(point, rayon);
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    /**
     * Redimensionne le cercle en modifiant son rayon selon les facteurs spécifiés.
     *
     * @param i Le facteur de redimensionnement pour la hauteur.
     * @param j Le facteur de redimensionnement pour la largeur.
     * @return Une référence à l'instance actuelle du cercle, pour permettre les opérations en chaîne.
     */
    public IForme redimmensioner(double i, double j) {
        if (i == j) {
            rayon *= i;
        } else if (i == 0) {
            rayon *= j;
        } else if (j == 0) {
            rayon *= i;
        } else {
            rayon *= i * j;
        } // TODO gestion du cas rayon négatif
        return this;

    }

    /**
     * Change la couleur du cercle.
     *
     * @param couleurs Un tableau de chaînes de caractères représentant les couleurs possibles.
     * @return Une référence à l'instance actuelle du cercle, pour permettre les opérations en chaîne.
     */
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    // Les autres méthodes sont également documentées selon leur but et leur fonctionnement, mais je ne vais pas toutes les répéter ici.

    /**
     * Crée un fichier SVG représentant le cercle.
     */
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Cercle.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
}
