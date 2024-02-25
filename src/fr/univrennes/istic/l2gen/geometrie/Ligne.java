package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Ligne représente une ligne polygonale définie par une série de
 * sommets.
 */
public class Ligne implements IForme {

    private List<Point> ligne; // Tableau des sommets de la ligne
    private String couleur = "black"; // Couleur de la ligne en "black"
    private int angle = 0;

    /**
     * Constructeur de la classe Ligne prenant en paramètre les coordonnées des
     * sommets de la ligne.
     *
     * @param l Les coordonnées des sommets de la ligne. Chaque paire de valeurs
     *          consécutives représente les coordonnées x et y d'un sommet.
     */
    public Ligne(double... l) {
        if (l.length % 2 == 0) {
            ligne = new ArrayList<>();
            for (int i = 0; i < l.length; i = i + 2) {
                ligne.add(new Point(l[i], l[i + 1]));
            }
        }

    }

    /**
     * Ajoute un sommet à la ligne.
     *
     * @param p Le sommet à ajouter à la ligne.
     * @return Une référence à l'instance actuelle de la ligne, pour permettre les
     *         opérations en chaîne.
     */
    public IForme ajouterSommet(Point p) {
        ligne.add(p);
        return this;
    }

    /**
     * Ajoute un sommet à la ligne en spécifiant ses coordonnées.
     *
     * @param x La coordonnée x du sommet à ajouter.
     * @param y La coordonnée y du sommet à ajouter.
     * @return Une référence à l'instance actuelle de la ligne, pour permettre les
     *         opérations en chaîne.
     */
    public IForme ajouterSommet(double x, double y) {
        ajouterSommet(new Point(x, y));
        return this;
    }

    /**
     * Retourne le centre de la ligne, qui est défini comme étant le dernier sommet
     * de la ligne.
     *
     * @return Le centre de la ligne.
     */
    public Point centre() {
        return ligne.get(ligne.size() - 1);
    }

    /**
     * Retourne une description de la ligne avec une indentation spécifiée.
     *
     * @param identation Le niveau d'indentation pour la description.
     * @return Une chaîne de caractères décrivant la ligne.
     */
    public String description(int identation) {
        String result;
        String identa = "";
        for (int i = 0; i < identation; i++) {
            identa += "  ";
        }
        result = identa + "Ligne";
        for (int i = 0; i < ligne.size(); i++) {
            result = result + " " + ligne.get(i).x() + ',' + ligne.get(i).y();
        }
        result += " de couleur " + couleur + " angle=" + angle;
        return result;
    }

    /**
     * Retourne une liste des coordonnées des sommets de la ligne.
     *
     * @return Une liste des coordonnées des sommets de la ligne.
     */
    public List<Double> getSommets() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < ligne.size(); i++) {
            result.add(ligne.get(i).x());
            result.add(ligne.get(i).y());
        }
        return result;
    }

    /**
     * Retourne la hauteur de la ligne, calculée comme la différence entre la
     * coordonnée y maximale et la coordonnée y minimale parmi tous les sommets.
     *
     * @return La hauteur de la ligne.
     */
    public double hauteur() {
        List<Double> dy = new ArrayList<Double>();
        for (int i = 0; i < ligne.size(); i++) {
            dy.add(ligne.get(i).y());
        }
        Double max = dy.get(0);
        Double min = dy.get(0);
        for (int i = 1; i < dy.size(); i++) {
            if (dy.get(i) > max) {
                min = max;
                max = dy.get(i);
            } else if (min > dy.get(i)) {
                min = dy.get(i);
            }
        }
        return max - min;
    }

    /**
     * Retourne la largeur de la ligne, calculée comme la différence entre la
     * coordonnée x maximale et la coordonnée x minimale parmi tous les sommets.
     *
     * @return La largeur de la ligne.
     */
    public double largeur() {
        List<Double> dx = new ArrayList<Double>();
        for (int i = 0; i < ligne.size(); i++) {
            dx.add(ligne.get(i).x());
        }
        Double max = dx.get(0);
        Double min = dx.get(0);
        for (int i = 1; i < dx.size(); i++) {
            if (dx.get(i) > max) {
                min = max;
                max = dx.get(i);
            } else if (min > dx.get(i)) {
                min = dx.get(i);
            }
        }
        return max - min;
    }

    /**
     * Retourne une représentation SVG de la ligne.
     *
     * @return Une chaîne de caractères représentant la ligne en format SVG.
     */
    public String enSVG() {
        String result = "<polyline ligne=\"";
        result = result + ligne.get(0).x() + ' ' + ligne.get(0).y() + ' ';
        for (int i = 1; i < ligne.size(); i++) {
            result = result + ligne.get(i).y() + ' ' + ligne.get(i).y() + ' ';
        }
        result = result + "\" fill=\"white\" stroke=\"" + couleur + "\" transform=\"rotate(" + angle + ")\"/>";
        return result;
    }

    /**
     * Déplace la ligne selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        for (int i = 0; i < ligne.size(); i++) {
            ligne.set(i, new Point(ligne.get(i).x() + dx, ligne.get(i).y() + dy));
        }
        return this;
    }

    /**
     * Duplique la ligne.
     *
     * @return Une nouvelle instance de la ligne avec les mêmes propriétés.
     */
    public IForme dupliquer() {
        Ligne ligne2 = new Ligne();
        for (int i = 0; i < ligne.size(); i++) {
            ligne2.ajouterSommet(ligne.get(i));
        }
        ligne2.colorier(this.couleur);
        ligne2.tourner(this.angle);
        return ligne2;
    }

    /**
     * Redimensionne la ligne selon les dimensions spécifiées.
     *
     * @param h La hauteur de redimensionnement.
     * @param l La largeur de redimensionnement.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        for (int i = 1; i < ligne.size(); i++) {
            ligne.set(i, new Point(ligne.get(i).x() + h, ligne.get(i).y() + l));
        }
        return this;
    }

    /**
     * Change la couleur de la ligne.
     *
     * @param couleurs Un tableau de couleurs à appliquer à la ligne.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme colorier(String... couleurs) {
        this.couleur = couleurs[0];
        return this;
    }

    public IForme tourner(int angle) {
        this.angle += angle;
        return this;
    }

    /**
     * Crée un fichier SVG représentant la ligne.
     */
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Ligne.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
    /**
     * Aligne les points de la ligne selon l'alignement spécifié et la cible.
     *
     * @param alignement L'alignement à appliquer (HAUT, BAS, DROITE, GAUCHE, etc.).
     * @param cible      La cible sur laquelle les points de la ligne doivent être alignés.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
     */
    @Override
    public IForme aligner(Alignement alignement, double cible) {
        double distanceY;
        double distanceX;
        switch (alignement) {
            case HAUT:
                double minY = ligne.get(0).y();
                for (Point point : ligne) {
                    if (minY > point.y()) {
                        minY = point.y();
                    }
                }

                distanceY = cible - minY;
                for (int i = 0; i < ligne.size(); i++) {
                    Point point = ligne.remove(i);
                    ligne.add(i, new Point(point.x(), point.y() + distanceY));
                }
                break;
            case BAS:
                double maxY = ligne.get(0).y();
                for (Point point : ligne) {
                    if (maxY < point.y()) {
                        maxY = point.y();
                    }
                }

                distanceY = cible - maxY;
                for (int i = 0; i < ligne.size(); i++) {
                    Point point = ligne.remove(i);
                    ligne.add(i, new Point(point.x(), point.y() + distanceY));
                }
                break;
            case DROITE:
                double maxX = ligne.get(0).x();
                for (Point point : ligne) {
                    if (maxX < point.x()) {
                        maxX = point.x();
                    }
                }

                distanceX = cible - maxX;
                for (int i = 0; i < ligne.size(); i++) {
                    Point point = ligne.remove(i);
                    ligne.add(i, new Point(point.x() + distanceX, point.y()));
                }
                break;
            case GAUCHE:
                double minX = ligne.get(0).x();
                for (Point point : ligne) {
                    if (minX > point.x()) {
                        minX = point.x();
                    }
                }

                distanceX = cible - minX;
                for (int i = 0; i < ligne.size(); i++) {
                    Point point = ligne.remove(i);
                    ligne.add(i, new Point(point.x() + distanceX, point.y()));
                }
                break;
            default:
                break;
        }
        return this;
    }
}
