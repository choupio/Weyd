package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Rectangle implements IForme {

    private double largeur;
    private double hauteur;
    private Point centre;
    private String couleur;

    // Bloc d'initialisation
    {
        couleur = "white";
    }

    public Point centre() {
        return centre;
    }

    public double largeur() {
        return largeur;
    }

    public double hauteur() {
        return hauteur;
    }

    public IForme setLargeur(double largeur) {
        this.largeur = largeur;
        return this;
    }

    public IForme setHauteur(double hauteur) {
        this.hauteur = hauteur;
        return this;
    }

    public Rectangle(double x, double y, double largeur, double hauteur) {
        this.centre = new Point(x - (largeur / 2), y - (hauteur / 2));
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Rectangle(Point p, double largeur, double hauteur) {
        this.centre = p;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * On prend en paramètre un entier indentation, et on doit retourner une
     * description de Rectangle préfixée de cette indentation (un cran vaut 2
     * caractères blanc)
     * 
     * @param indentation
     * @return
     */
    public String description(int indentation) {
        String ind = "";
        for (int i = 0; i < indentation; i++) {
            ind += "  ";
        }
        return ind + "Rectangle Centre=" + centre().x() + "," + centre().y() + " L=" + largeur() + " H=" + hauteur() + " de couleur" + colorier(couleur);
    }

    /**
     * Déplace le centre en fonction de dx et dy
     * 
     * @param dx
     * @param dy
     * @return rien
     */
    public IForme deplacer(double dx, double dy) {
        this.centre = new Point(dx, dy);
        return this;
    }

    /**
     * duplique le rectangle.
     */
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Rectangle nouvelleForme = new Rectangle(this.centre(), this.largeur(), this.hauteur());
        nouvelleForme.couleur = this.couleur;  // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    /**
     * On ré-ajuste la hauteur et la largeur du Rectangle.
     * 
     * @param h la hauteur
     * @param l la largeur
     */
    public IForme redimmensioner(double h, double l) {
        this.setHauteur(h);
        this.setLargeur(l);
        return this;
    }

    public String enSVG() {
        return "<rect x=\"" + centre().x() + "\" y=\"" + centre().y() + "\" height=\"" + hauteur() + "\" width=\""
                + largeur()
                + "\"\n" + "\t" + "fill=\"" + couleur + "\"" + " stroke=\"black\"/>";
    }

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("Rectangle.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
}
