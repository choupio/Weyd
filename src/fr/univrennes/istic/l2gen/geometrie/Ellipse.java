package fr.univrennes.istic.l2gen.geometrie;

public class Ellipse implements IForme{

    private Point centre; 
    private double hauteur;
    private double largeur;

    
    public Ellipse(double centre1, double centre2, double hauteur, double largeur) {
        this.centre = new Point(centre1, centre2);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public Ellipse(Point centre, double hauteur, double largeur) {
        this.centre = centre;
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
            description += "C'est une ellipse particulière.";
        } else {
            description += "C'est une ellipse standard.";
        }
        return description;
    }
}