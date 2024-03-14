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
    private String couleur = "black"; // La couleur du cercle en "black"
    private int angle = 0;

    /**
     * Constructeur pour initialiser un cercle avec les coordonnées du centre et le
     * rayon.
     *
     * @param x     La coordonnée x du centre du cercle.
     * @param y     La coordonnée y du centre du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(double x, double y, double rayon) {
        if (rayon < 0 || x < 0 || y < 0) {
            throw new IllegalArgumentException("Le rayon et coordonnées du centre doivent être positifs.");
        }
        this.point = new Point(x, y);
        this.rayon = rayon;
    }

    /**
     * Constructeur pour initialiser un cercle avec un point central et le rayon.
     *
     * @param point Le point central du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(Point point, double rayon) {
        this(point.x(), point.y(), rayon);
    }

    @Override
    public Point centre() {
        if (point.x() < 0 || point.y() < 0) {
            throw new IllegalStateException("Le centre ne peut pas avoir de coordonnée inférieur à 0.");
        }
        return point;
    }

    @Override
    public String description(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("L'identation ne doit pas être négative.");
        }
        String indentation = "";
        for (int i = 0; i < x; i++) {
            indentation += " ";
        }
        if (angle != 0) {
            return (indentation + "Cercle centre= " + point.x() + ", " + point.y() + " r= " + rayon + " de couleur "
                    + couleur + " angle=" + angle);
        }
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

    @Override
    public IForme deplacer(double x, double y) {
        if (x < 0 && (this.centre().x() + x) < 0) {
            throw new IllegalArgumentException("Le point x du cercle ne peut pas être négatif.");
        } else if (y < 0 && (this.centre().y() + y) < 0) {
            throw new IllegalArgumentException("Le point y du cercle ne peut pas être négatif.");
        }
        point.plus(x, y);
        return this;
    }

    @Override
    public String enSVG() {
        if (angle != 0) {
            return "<circle cx=\"" + centre().x() + "\" cy=\"" + centre().y() + "\" r=\"" + hauteur() / 2 + "\"" + '\n'
                    + " fill=\"" + couleur + "\" stroke=\"black\" transform=\"rotate(" + angle + ")\"/>";
        }
        return "<circle cx=\"" + centre().x() + "\" cy=\"" + centre().y() + "\" r=\"" + hauteur() / 2 + "\"" + '\n'
                + " fill=\"" + couleur + "\" stroke=\"black\"/>";
    }

    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Cercle nouvelleForme = new Cercle(point, rayon);
        nouvelleForme.angle = angle;
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    @Override
    public IForme redimmensioner(double i, double j) {
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Le rayon ne doit pas être négative.");
        } else if (i == j) {
            rayon *= i;
        } else if (i == 0) {
            rayon *= j;
        } else if (j == 0) {
            rayon *= i;
        } else {
            rayon *= i * j;
        }
        if (rayon < 0) {
            throw new IllegalStateException("Le rayon ne peut pas être négatif.");
        }
        return this;

    }

    @Override
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    @Override
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

    @Override
    public IForme tourner(int angle) {
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle ne peut pas être négatif.");
        }
        this.angle = angle;
        return this;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        if (cible < 0) {
            throw new IllegalArgumentException("Cible ne peut pas être négative.");
        }
        switch (alignement) {
            case HAUT:
                point = new Point(point.x(), cible + rayon);
                break;
            case BAS:
                if((cible-rayon)<0){
                    throw new IllegalStateException("Les coordonnées du centre ne peuvent pas être négatives.");
                }
                point = new Point(point.x(), cible - rayon);
                break;
            case DROITE:
                if((cible-rayon)<0){
                    throw new IllegalStateException("Les coordonnées du centre ne peuvent pas être négatives.");
                }
                point = new Point(cible - rayon, point.y());
                break;
            case GAUCHE:
                point = new Point(cible + rayon, point.y());
                break;
        }
        return this;
    }

}
