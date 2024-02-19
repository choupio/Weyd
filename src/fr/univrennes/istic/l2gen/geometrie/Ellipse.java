package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ellipse implements IForme {

    private Point centre;
    private double hauteur;
    private double largeur;
    private double rayon;
    String couleur;

    // Bloc d'initialisation
    {
        couleur = "white";
    }

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

    public IForme redimmensioner(double largeur, double hauteur) {
        this.rayon = rayon * largeur;
        return this;
    }

    public IForme deplacer(double dx, double dy) {
        this.centre = centre.plus(dx,dy);
        return this;
    }

    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Ellipse nouvelleForme = new Ellipse(centre, hauteur, largeur);
        nouvelleForme.couleur = this.couleur;  // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    public String enSVG() {
        return "<ellipse cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" rx=\"" + hauteur + "\" ry=\""
                + largeur
                + "\" fill=\"" + couleur + "\"" + " stroke=\"black\"/>";
    }

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

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
}