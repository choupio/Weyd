package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe Rectangle représente un rectangle défini par sa largeur, sa hauteur
 * et son centre.
 */
public class Rectangle implements IForme {

    private double largeur; // Largeur du rectangle
    private double hauteur; // Hauteur du rectangle
    private Point coin; // coin supérieur gauche
    private String couleur = "white"; // Couleur du rectangle en "white"

    private int angle = 0; // angle du rectangle, à 0 de base

    public String getCouleur() {
        return couleur;
    }

    /**
     * Retourne le centre du rectangle.
     *
     * @return Le centre du rectangle.
     */
    public Point centre() {
        return new Point(coin.x() + largeur()/2, coin.y() + hauteur()/2); // TODO Le point qui est nommé cente n'est pas le cnetre du rectangle mais le coin supérieur gauche
    }

    /**
     * Retourne la largeur du rectangle.
     *
     * @return La largeur du rectangle.
     */
    public double largeur() {
        return largeur;
    }

    /**
     * Retourne la hauteur du rectangle.
     *
     * @return La hauteur du rectangle.
     */
    public double hauteur() {
        return hauteur;
    }

    /**
     * Définit la largeur du rectangle.
     *
     * @param largeur La largeur du rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme setLargeur(double largeur) {
        this.largeur = largeur;
        return this;
    }

    /**
     * Définit la hauteur du rectangle.
     *
     * @param hauteur La hauteur du rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme setHauteur(double hauteur) {
        this.hauteur = hauteur;
        return this;
    }

    /**
     * Constructeur de la classe Rectangle.
     *
     * @param x       La coordonnée x du centre du rectangle.
     * @param y       La coordonnée y du centre du rectangle.
     * @param largeur La largeur du rectangle.
     * @param hauteur La hauteur du rectangle.
     */
    public Rectangle(double x, double y, double largeur, double hauteur) {
        this.coin = new Point(x - (largeur / 2), y - (hauteur / 2));
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Constructeur de la classe Rectangle.
     *
     * @param p       Le centre du rectangle.
     * @param largeur La largeur du rectangle.
     * @param hauteur La hauteur du rectangle.
     */
    public Rectangle(Point p, double largeur, double hauteur) {
        this.coin = new Point(p.x()- (largeur / 2),p.y() - (hauteur / 2));
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Retourne une description du rectangle avec une indentation spécifiée.
     *
     * @param indentation Le niveau d'indentation pour la description.
     * @throws IllegalArgumentException si l'indentation est inférieure à 0.
     * @return Une chaîne de caractères décrivant le rectangle.
     */
    @Override
    public String description(int indentation) {
        if (indentation < 0) {
            throw new IllegalArgumentException("L'indentation ne doit pas être inférieure à 0.");
        } else {
            StringBuilder indent = new StringBuilder();
            for (int i = 0; i < indentation; i++) {
                indent.append(" ");
            }
            return indent + "Rectangle" + indent + "Centre=" + (coin.x() + largeur/2) + "," + (coin.y() + hauteur/2) + " L=" + largeur() + " H="
                    + hauteur() + " de couleur " + couleur + " angle=" + angle;
        }

    }

    /**
     * Déplace le centre du rectangle selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @throws IllegalStateException si x ou y devient négatif
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme deplacer(double dx, double dy) {
        if (dx < 0 && (this.centre().x() + dx) < 0) {
            throw new IllegalStateException("Le point x du rectangle ne peut pas être négatif.");
        } else if (dy < 0 && (this.centre().y() + dy) < 0) {
            throw new IllegalStateException("Le point y du rectangle ne peut pas être négatif.");
        } else {
            this.coin.plus(dx, dy);
            return this;
        }
    }

    /**
     * Duplique le rectangle.
     *
     * @return Une nouvelle instance du rectangle avec les mêmes propriétés.
     */
    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Rectangle nouvelleForme = new Rectangle(this.centre(), this.largeur(), this.hauteur());
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    /**
     * Ré-ajuste la hauteur et la largeur du rectangle.
     *
     * @param hauteur La hauteur de redimmensionement
     * @param largeur La largeur de redimmensionement
     * @throws IllegalArgumentException si la hauteur ou largeur de red. est égale à
     *                                  0 ou moins.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne. La hauteur du rectangle va être multipliée par
     *         celle de redimmensionnement,
     *         pareil pour la largeur.
     */
    public IForme redimmensioner(double hauteur, double largeur) {
        if (hauteur <= 0) {
            throw new IllegalArgumentException("La hauteur de redimmensionement ne doit pas être inférieure à 0.");
        }
        if (largeur <= 0) {
            throw new IllegalArgumentException("La largeur de redimmensionement ne doit pas être inférieure à 0.");
        } else {
            this.setHauteur(this.hauteur * hauteur);
            this.setLargeur(this.largeur * largeur);
            return this;
        }
    }

    /**
     * Génère une représentation SVG du rectangle.
     *
     * @return Une chaîne de caractères représentant le rectangle en format SVG.
     */
    public String enSVG() {
        return "<rect x=\"" + coin.x() + "\" y=\"" + coin.y() + "\" height=\"" + hauteur() + "\" width=\""
                + largeur()
                + "\"\n" + "\t" + "fill=\"" + couleur + "\"" + " stroke=\"black\" transform=\"rotate(" + angle
                + ")\"/>";
    }

    /**
     * Change la couleur du rectangle.
     *
     * @param couleurs Un tableau de couleurs à appliquer au rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    /**
     * Crée un fichier SVG représentant le rectangle.
     */
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("Rectangle.svg"));
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
            }
        }
    }

    /**
     * @param angle un entier qui représente l'angle.
     * @throws IllegalArgumentException si l'angle est négatif.
     * @return le nouveau rectangle tourné avec l'angle.
     */
    public IForme tourner(int angle) {
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle ne peut pas être négatif");
        } else {
            this.angle = angle;
            return this;
        }

    }

    public IForme aligner(Alignement alignement, double cible) {
        if (cible < 0) {
            throw new IllegalArgumentException("La cible ne peut pas être négative.");
        }
        switch (alignement) {
            case HAUT:
                if ((cible) < 0) {
                    throw new IllegalArgumentException("Y ne peut pas être négatif.");
                }
                coin = new Point(coin.x(), cible);
                break;
            case BAS:
                if ((cible - hauteur) < 0) {
                    throw new IllegalArgumentException("Y ne peut pas être négatif.");
                }
                coin = new Point(coin.x(), cible - hauteur);
                break;
            case DROITE:
                if ((cible - largeur) < 0) {
                    throw new IllegalArgumentException("X ne peut pas être négatif.");
                }
                coin = new Point(cible - largeur , coin.y());
                break;
            case GAUCHE:
                if ((cible) < 0) {
                    throw new IllegalArgumentException("X ne peut pas être négatif.");
                }
                coin = new Point(cible , coin.y());
                break;
        }
        return this;
    }
}
