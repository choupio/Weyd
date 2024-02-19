package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cercle implements IForme {
    private Point point;
    private double rayon;
    private String couleur;

    {
        couleur = "white";
    }

    public Cercle(double x, double y, double rayon) {
        this.point = new Point(x, y);
        this.rayon = rayon; // TODO gestion du cas rayon négatif
    }

    public Cercle(Point point, double rayon) {
        this.point = point;
        this.rayon = rayon; // TODO gestion du cas rayon négatif
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
        // Au lieu d'appeler la fonction colorier j'ai juste mis couleur pcq la fonction
        // renvoyait une place en mémoire (celle de l'objet je suppose)
        return (indentation + "Cercle centre= " + point.x() + ", " + point.y() + " r= " + rayon + " de couleur "
                + couleur);
    }

    @Override
    public double hauteur() {
        return rayon * 2;
    }

    @Override
    public double largeur() {
        return rayon * 2;
    }

    public IForme deplacer(double x, double y) {
        point.plus(x, y);
        return this;
    }

    @Override
    public String enSVG() {
        return "<circle cx=\"" + centre().x() + "\" cy=\"" + centre().y() + "\" r=\"" + hauteur() / 2 + "\"" + '\n'
                + " fill=\"" + couleur + "\" stroke=\"black\"/>";
    }

    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Cercle nouvelleForme = new Cercle(point, rayon);
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

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

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

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
