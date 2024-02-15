package fr.univrennes.istic.l2gen.geometrie;

import java.awt.Point;

public class Ellipse implements IForme {

    private Point centre;
    private double hauteur;
    private double largeur;
    private double rayon;

    public Ellipse(double x, double y, double hauteur, double largeur) {
        this.centre = new Point(x, y);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Ellipse(Point p, double hauteur, double largeur) {
        this.centre = p;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public double hauteur() {
        return hauteur;
    }

    @Override
    public double largeur() {
        return largeur;
    }

    @Override
    public String description(int entier) {
        String description = "";
        for (int i = 0; i < entier; i++) {
            description += " ";
        }
        description += "Ellipse avec centre en " + centre +
                ", hauteur " + hauteur +
                ", largeur " + largeur + ". ";
        if (entier > 0) {
            description += "C'est une ellipse particuliere.";
        } else {
            description += "C'est une ellipse standard.";
        }
        return description;
    }

    public void redimmensioner(double largeur, double hauteur) {
        this.rayon = rayon * largeur;
    }

    public void deplacer(double dx, double dy) {
        this.centre = this.centre.plus(dx, dy);
    }

   
    public IForme dupliquer() {
        return new Ellipse(centre, hauteur, largeur);
    }

    public String enSVG() {
        return "<ellipse cx= " + centre.x + " cy= " + centre.y + " rx= " + hauteur + " ry= " + largeur + "fill=\"white\"" + " stroke=\"black\"/>";
    }

    public void colorier(String... couleurs) {
    }
}