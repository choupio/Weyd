package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Cette classe représente un secteur de cercle.
 */
public class Secteur implements IForme {

    private double arc; // L'angle d'ouverture du secteur en degrés
    private double angle; // L'angle du secteur en degrés par rapport à l'axe horizontal
    private Point centre; // Le centre du secteur
    private double rayon; // Le rayon du secteur
    public String couleur = "white"; // La couleur du secteur en "white"
    private double larg; // La largeur du secteur
    private double haut; // La hauteur du secteur

    /**
     * Constructeur de la classe Secteur prenant les coordonnées x et y du centre,
     * le rayon, l'angle et l'arc du secteur.
     * 
     * @param x     La coordonnée x du centre.
     * @param y     La coordonnée y du centre.
     * @param rayon Le rayon du secteur.
     * @param angle L'angle du secteur.
     * @param arc   L'arc du secteur.
     */
    public Secteur(double x, double y, double rayon, double angle, double arc) {
        this.centre = new Point(x, y);
        this.rayon = rayon;
        this.angle = angle;
        this.arc = arc;
    }

    /**
     * Constructeur de la classe Secteur prenant un Point comme centre, le rayon,
     * l'angle et l'arc du secteur.
     * 
     * @param f     Le point central du secteur.
     * @param rayon Le rayon du secteur.
     * @param angle L'angle du secteur.
     * @param arc   L'arc du secteur.
     */
    public Secteur(Point f, double rayon, double angle, double arc) {
        this.centre = f;
        this.rayon = rayon;
        this.angle = angle;
        this.arc = arc;
    }

    /**
     * Calcule la hauteur du secteur.
     * 
     * @return La hauteur du secteur.
     */
    @Override
    public double hauteur() {
        if (arc <= 180) {
            return rayon;
        } else {
            return 2 * rayon;
        }
    }

    /**
     * Rotates the shape by the specified angle.
     * 
     * @param angle the angle (in degrees) by which the shape should be rotated
     * @return the rotated shape
     */
    @Override
    public IForme tourner(int angle) {
        this.angle = (double) angle;
        return this;
    }

    /**
     * Aligns the shape based on the specified alignment and target value.
     *
     * @param alignement The alignment to apply.
     * @param cible      The target value for alignment.
     * @return The aligned shape.
     */
    @Override
    public IForme aligner(Alignement alignement, double cible) {
        switch (alignement) {
            case HAUT:
                centre = new Point(centre.x(), cible + rayon);
                break;
            case BAS:
                centre = new Point(centre.x(), cible - rayon);
                break;
            case DROITE:
                centre = new Point(cible + rayon, centre.y());
                break;
            case GAUCHE:
                centre = new Point(cible - rayon, centre.y());
                break;
        }
        return this;
    }

    /**
     * Calcule la largeur du secteur.
     * 
     * @return La largeur du secteur.
     */
    @Override
    public double largeur() {
        if (arc <= 180) {
            return 2 * rayon * Math.sin(Math.toRadians(arc / 2));
        } else {
            return 2 * rayon;
        }
    }

    /**
     * Redimensionne le secteur.
     * 
     * @param largeur La nouvelle largeur.
     * @param hauteur La nouvelle hauteur.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        if (h <= 0 || l <= 0) {
            throw new IllegalArgumentException("Les dimensions doivent être positives");
        }
        larg *= l;
        haut *= h;
        return this;
    }

    /**
     * Retourne le point central du secteur.
     * 
     * @return Le point central du secteur.
     */
    public Point getPoint() {
        return centre;
    }

    /**
     * Retourne l'arc du secteur.
     * 
     * @return L'arc du secteur.
     */
    public double getArc() {
        return arc;
    }

    /**
     * Définit l'arc du secteur.
     * 
     * @param arc Le nouvel arc.
     */
    public IForme setArc(double arc) {
        this.arc = arc;
        return this;
    }

    /**
     * Retourne l'angle du secteur.
     * 
     * @return L'angle du secteur.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Retourne le rayon du secteur.
     * 
     * @return Le rayon du secteur.
     */
    public double getRayon() {
        return rayon;
    }

    /**
     * Définit l'angle du secteur.
     * 
     * @param angle Le nouvel angle.
     */
    public IForme setAngle(double angle) {
        this.angle = angle;
        return this;
    }

    /**
     * Retourne le centre du secteur.
     * 
     * @return Le centre du secteur.
     */
    public Point centre() {
        return centre;
    }

    /**
     * Génère une description du secteur.
     * 
     * @param indentation L'indentation pour la description.
     * @return Une chaîne de caractères décrivant le secteur.
     */
    @Override
    public String description(int indentation) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            indent.append("  ");
        }
        return indent + "Secteur " + "centre=" + centre.x() + "," + centre.y() + " Angle=" + getAngle()
                + " Arc=" + getArc() + " de couleur " + couleur + " et de rotation " + angle;
    }

    /**
     * Déplace le secteur selon les coordonnées spécifiées.
     * 
     * @param dx Le déplacement horizontal.
     * @param dy Le déplacement vertical.
     */
    public IForme deplacer(double dx, double dy) {
        this.centre = this.centre.plus(dx, dy);
        return this;
    }

    /**
     * Duplique le secteur.
     * 
     * @return Une copie du secteur.
     */
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Secteur nouvelleForme = new Secteur(centre, rayon, angle, arc);
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    /**
     * Génère la représentation SVG du secteur.
     * 
     * @return La représentation SVG du secteur.
     */
    public String enSVG() {
        double startAngle = Math.toRadians(getAngle());
        double endAngle = Math.toRadians(getAngle() + getArc());

        double startX = centre.x() + getRayon() * Math.cos(startAngle);
        double startY = centre.y() - getRayon() * Math.sin(startAngle);

        double endX = centre.x() + getRayon() * Math.cos(endAngle);
        double endY = centre.y() - getRayon() * Math.sin(endAngle);

        int largeArcFlag = (getArc() > 180) ? 1 : 0;

        return "<path d=\"M " + startX + " " + startY + " A " + getRayon() + " " + getRayon()
                + " 0 " + largeArcFlag + " 0 " + endX + " " + endY + " L " + centre.x() + " " + centre.y() + " Z\"\n"
                + "\t" + "fill=\"" + couleur + "\"" + " stroke=\"black\" transform=\"rotate(" + getAngle() + ")\"/>";
    }

    /**
     * Colors the shape with the specified colors.
     * 
     * @param couleurs the colors to be applied to the shape
     * @return the updated shape
     */
    public IForme colorier(String... couleurs) {
        couleur = (couleurs.length > 0) ? couleurs[0] : couleur;
        return this;
    }

    /**
     * Returns the color of the sector.
     *
     * @return the color of the sector
     */
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }


    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Secteur.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

  
}
