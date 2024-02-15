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
        couleur = "black";
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

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public Rectangle(double x, double y, double hauteur, double largeur) {
        this.centre = new Point(x, y);
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Rectangle(Point p, double hauteur, double largeur) {
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
        return ind + "Rectangle Centre=" + centre().x() + "," + centre().y() + " L=" + largeur() + " H=" + hauteur();
    }

    /**
     * Déplace le centre en fonction de dx et dy
     * 
     * @param dx
     * @param dy
     * @return rien
     */
    public void deplacer(double dx, double dy) {
        this.centre().setX(dx);
        this.centre().setY(dy);
    }

    /**
     * duplique le rectangle.
     */
    public IForme dupliquer() {
        return new Rectangle(this.centre(), this.hauteur(), this.largeur());
    }

    /**
     * On ré-ajuste la hauteur et la largeur du Rectangle.
     * 
     * @param h la hauteur
     * @param l la largeur
     */
    public void redimmensioner(double h, double l) {
        setHauteur(h);
        setLargeur(l);
    }

    public String enSVG() {
        return "<rect x=\"" + centre().x() + "\" y=\"" + centre().y() + "\" width=\"" + largeur() + "\" height=\""
                + hauteur()
                + "\"\n" + "\t" + "fill=\"white\"" + " stroke=\"" + couleur + "\"/>";
    }

    public void colorier(String... couleurs) {
        couleur = couleurs[0];
    }
        public void createSvgFile() {
    String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";
    

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Rectangle.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier Cercle.svg créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
}
