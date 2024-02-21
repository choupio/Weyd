package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cette classe représente une ellipse dans un espace bidimensionnel.
 */
public class Ellipse implements IForme {

    private Point centre; // Le centre de l'ellipse
    private double hauteur; // La hauteur de l'ellipse
    private double largeur; // La largeur de l'ellipse
    private double rayon; // Le rayon de l'ellipse
    private int angle =0;
    String couleur = "white"; // La couleur de l'ellipse en "white"


    /**
     * Constructeur pour initialiser une ellipse avec les coordonnées du centre, la hauteur et la largeur.
     *
     * @param x       La coordonnée x du centre de l'ellipse.
     * @param y       La coordonnée y du centre de l'ellipse.
     * @param hauteur La hauteur de l'ellipse.
     * @param largeur La largeur de l'ellipse.
     */
    public Ellipse(double x, double y, double hauteur, double largeur) {
        this.centre = new Point(x, y);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    /**
     * Constructeur pour initialiser une ellipse avec un point central, la hauteur et la largeur.
     *
     * @param p       Le point central de l'ellipse.
     * @param hauteur La hauteur de l'ellipse.
     * @param largeur La largeur de l'ellipse.
     */
    public Ellipse(Point p, double hauteur, double largeur) {
        this.centre = p;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Retourne le centre de l'ellipse.
     *
     * @return Le centre de l'ellipse.
     */
    @Override
    public Point centre() {
        return centre;
    }

    /**
     * Retourne la hauteur de l'ellipse.
     *
     * @return La hauteur de l'ellipse.
     */
    @Override
    public double hauteur() {
        return hauteur;
    }

    /**
     * Retourne la largeur de l'ellipse.
     *
     * @return La largeur de l'ellipse.
     */
    @Override
    public double largeur() {
        return largeur;
    }

    /**
     * Retourne une description de l'ellipse.
     *
     * @param entier Le niveau d'indentation.
     * @return Une chaîne de caractères décrivant l'ellipse.
     */
    @Override
public String description(int entier) {
    String description = "";
    for (int i = 0; i < entier; i++) {
        description += " ";
    }
    description += "Ellipse avec centre en " + centre +
            ", hauteur " + hauteur +
            ", largeur " + largeur + ". ";
    
    if (angle != 0) {
        description += "Ellipse tournée de " + angle + " degrés. ";
    }

    if (entier > 0) {
        description += "C'est une ellipse particuliere.";
    } else {
        description += "C'est une ellipse standard.";
    }

    return description;
}

    /**
     * Redimensionne l'ellipse en modifiant sa largeur et sa hauteur.
     *
     * @param largeur La nouvelle largeur de l'ellipse.
     * @param hauteur La nouvelle hauteur de l'ellipse.
     * @return Une référence à l'instance actuelle de l'ellipse, pour permettre les opérations en chaîne.
     */
    public IForme redimmensioner(double largeur, double hauteur) {
        this.rayon = rayon * largeur;
        return this;
    }

    /**
     * Déplace l'ellipse selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance actuelle de l'ellipse, pour permettre les opérations en chaîne.
     */
    public IForme deplacer(double dx, double dy) {
        this.centre = centre.plus(dx, dy);
        return this;
    }

    /**
     * Duplique l'ellipse avec les mêmes propriétés.
     *
     * @return Une nouvelle instance de la classe Ellipse avec les mêmes propriétés.
     */
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Ellipse nouvelleForme = new Ellipse(centre, hauteur, largeur);
        nouvelleForme.couleur = this.couleur;  // Copie de la couleur, ajustez selon vos besoins
        nouvelleForme.angle = this.angle;      // Copie de l'angle de rotation
        return nouvelleForme;
    }

    /**
     * Retourne une représentation SVG de l'ellipse.
     *
     * @return Une chaîne de caractères représentant l'ellipse en format SVG.
     */
    @Override
    public String enSVG() {
        StringBuilder svg = new StringBuilder("<ellipse cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" rx=\"" + hauteur + "\" ry=\"" + largeur + "\"");
        if (angle != 0) {
            svg.append(" transform=\"rotate(").append(angle).append(" ").append(centre.x()).append(" ").append(centre.y()).append(")\"");
        }
        svg.append(" fill=\"" + couleur + "\" stroke=\"black\"/>");
        return svg.toString();
    }

    /**
     * Change la couleur de l'ellipse.
     *
     * @param couleurs Un tableau de chaînes de caractères représentant les couleurs possibles.
     * @return Une référence à l'instance actuelle de l'ellipse, pour permettre les opérations en chaîne.
     */
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    /**
     * Crée un fichier SVG représentant l'ellipse.
     */
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Ellipse.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        double nouveauX = centre.x();
        double nouveauY = centre.y();
        switch (alignement) {
            case HAUT:
                nouveauY = cible + hauteur / 2;
                break;
            case BAS:
                nouveauY = cible + hauteur / 2;
                break;
            case DROITE:
                nouveauX = cible - largeur / 2;
                break;
            case GAUCHE:
                nouveauX = cible - largeur / 2;
                break;
            default:
                break;
        }   
        centre = new Point(nouveauX, nouveauY);
        return this;
    }

    @Override
	public IForme tourner(int angle) {
		this.angle = angle;
		return this;
	}
}
