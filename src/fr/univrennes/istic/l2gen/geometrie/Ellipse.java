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
    private int angle = 0;
    String couleur = "white"; // La couleur de l'ellipse en "white"

    /**
     * Constructeur avec coordonnées et dimensions.
     *
     * @param x       La coordonnée x du centre de l'ellipse.
     * @param y       La coordonnée y du centre de l'ellipse.
     * @param hauteur La hauteur de l'ellipse.
     * @param largeur La largeur de l'ellipse.
     * @pre x et y doivent être des nombres réels valides.
     * @pre hauteur et largeur doivent être des nombres réels positifs.
     * @post Un objet Ellipse est créé avec le centre aux coordonnées (x, y) et les
     *       dimensions spécifiées.
     * @throws IllegalArgumentException Si x, y, hauteur ou largeur sont négatifs.
     */
    public Ellipse(double x, double y, double hauteur, double largeur) {
        if (hauteur < 0 || largeur < 0 || x < 0 || y < 0) {
            throw new IllegalArgumentException("Les coordonnées et dimensions ne peuvent pas être négatives.");
        }
        this.centre = new Point(x, y);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    /**
     * Constructeur avec un point central et dimensions.
     *
     * @param p       Le point central de l'ellipse.
     * @param hauteur La hauteur de l'ellipse.
     * @param largeur La largeur de l'ellipse.
     * @pre Le point p doit être non nul.
     * @pre hauteur et largeur doivent être des nombres réels positifs.
     * @post Un objet Ellipse est créé avec le centre défini par le point p et les
     *       dimensions spécifiées.
     * @throws IllegalArgumentException Si hauteur ou largeur sont négatifs.
     */
    public Ellipse(Point p, double hauteur, double largeur) {
        if (hauteur < 0 || largeur < 0) {
            throw new IllegalArgumentException("Les dimensions ne peuvent pas être négatives.");
        }
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
        if (entier < 0) {
            throw new IllegalArgumentException("L'indentation ne doit pas être inférieure à 0.");
        } else {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < entier; i++) {
                indent.append(" ");
            }
            return indent + "Ellipse" + indent + "Centre=" + centre.x() + "," + centre.y() + " L=" + largeur() + " H="
                    + hauteur() + " de couleur " + couleur + " angle=" + angle;
        }
    }

    @Override
    public IForme redimmensioner(double largeur, double hauteur) {
        if (hauteur < 0 || largeur < 0) {
            throw new IllegalArgumentException("Les dimensions ne peuvent pas être négatives.");
        }
        this.rayon = rayon * largeur;
        return this;
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        if (hauteur < 0 || largeur < 0) {
            throw new IllegalArgumentException("Les dimensions ne peuvent pas être négatives.");
        }
        this.centre = centre.plus(dx, dy);
        return this;
    }

    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle ne peut pas être négatif.");
        }
        Ellipse nouvelleForme = new Ellipse(centre, hauteur, largeur);
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        nouvelleForme.angle = this.angle; // Copie de l'angle de rotation
        return nouvelleForme;
    }

    @Override
    public String enSVG() {
        StringBuilder svg = new StringBuilder("<ellipse cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" rx=\""
                + hauteur + "\" ry=\"" + largeur + "\"");
        if (angle != 0) {
            svg.append(" transform=\"rotate(").append(angle).append(" ").append(centre.x()).append(" ")
                    .append(centre.y()).append(")\"");
        }
        svg.append(" fill=\"" + couleur + "\" stroke=\"black\"/>");
        return svg.toString();
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
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Ellipse.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

    /**
     * Retourne l'angle de rotation de l'ellipse.
     *
     * @return L'angle de rotation de l'ellipse.
     * @post Retourne l'angle de rotation de l'ellipse.
     */
    public int getAngle() {
        return angle;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        if (cible < 0) {
            throw new IllegalArgumentException("La cible ne peut pas être négative.");
        }
        double nouveauX = centre.x();
        double nouveauY = centre.y();
        switch (alignement) {
            case HAUT:
                nouveauY = cible + hauteur / 2;
                break;
            case BAS:
                nouveauY = cible - hauteur / 2;
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
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle ne peut pas être négatif.");
        }
        this.angle = angle;
        return this;
    }
}
