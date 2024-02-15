package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cercle implements IForme {
    private Point point;
    private double rayon;
    private String couleur;

    {
        couleur = "black";
    }

    public Cercle(double x, double y, double rayon) {
        this.point = new Point(x, y);
        this.rayon = rayon;
    }

    public Cercle(Point point, double rayon) {
        this.point = point;
        this.rayon = rayon;
    }

    @Override
    public Point centre() {
        return point;
    }

    @Override
    public String description(int x) {
        String indentation = "";
        for (int i = 0; i < x; i++) {
            indentation += " ";
        }
        return (indentation + "Cercle centre=" + point.x() + "," + point.y() + " r=" + rayon);
    }

    @Override
    public double hauteur() {
        return rayon * 2;
    }

    @Override
    public double largeur() {
        return rayon * 2;
    }

    public void deplacer(double x, double y) {
        point = point.plus(x, y);
    }

    @Override
    public String enSVG() {
        return "<circle cx=\"" + centre().x() + "\" cy=\"" + centre().y() + "\" r=\"" + hauteur() / 2 + "\"" + '\n'
                + " fill=\"white\" stroke\"" + couleur + "\"/>";
    }

    @Override
    public IForme dupliquer() {
        return new Cercle(point, rayon);
    }

    public void redimmensioner(double i, double j) {
        if (i == j) {
            rayon *= i;
        } else if (i == 0) {
            rayon *= j;
        } else if (j == 0) {
            rayon *= i;
        } else
            rayon *= i * j;

    }

    public void colorier(String... couleurs) {
        couleur = couleurs[0];
    }
    public void createSvgFile() {
    String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";
    

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Cercle.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier Cercle.svg créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
}
