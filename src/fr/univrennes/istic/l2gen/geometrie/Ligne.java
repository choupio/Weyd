package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Ligne représente une ligne polygonale définie par une série de sommets.
 */
public class Ligne implements IForme {

    private Point[] ligne; // Tableau des sommets de la ligne
    private String couleur = "black"; // Couleur de la ligne en "black"

    /**
     * Constructeur de la classe Ligne prenant en paramètre les coordonnées des sommets de la ligne.
     *
     * @param l Les coordonnées des sommets de la ligne. Chaque paire de valeurs consécutives représente les coordonnées x et y d'un sommet.
     */
    public Ligne(double... l) {
        ligne = new Point[l.length / 2];
        int j = 0;
        for (int i = 0; i < l.length; i = i + 2) {
            ligne[j] = new Point(l[i], l[i + 1]);
            j++;
        }
    }

    /**
     * Ajoute un sommet à la ligne.
     *
     * @param p Le sommet à ajouter à la ligne.
     * @return Une référence à l'instance actuelle de la ligne, pour permettre les opérations en chaîne.
     */
    public IForme ajouterSommet(Point p) {
        Point[] temp = ligne;
        ligne = new Point[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            ligne[i] = temp[i];
        }
        ligne[ligne.length - 1] = p;
        return this;
    }

    /**
     * Ajoute un sommet à la ligne en spécifiant ses coordonnées.
     *
     * @param x La coordonnée x du sommet à ajouter.
     * @param y La coordonnée y du sommet à ajouter.
     * @return Une référence à l'instance actuelle de la ligne, pour permettre les opérations en chaîne.
     */
    public IForme ajouterSommet(double x, double y) {
        ajouterSommet(new Point(x, y));
        return this;
    }

    /**
     * Retourne le centre de la ligne, qui est défini comme étant le dernier sommet de la ligne.
     *
     * @return Le centre de la ligne.
     */
    public Point centre() {
        return ligne[ligne.length - 1];
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
        for (int i = 0; i < ligne.length; i++) {
            result = result + " " + ligne[i].x() + ',' + ligne[i].y();
        }
        result += " de couleur " + couleur;
        return result;
    }

    /**
     * Retourne une liste des coordonnées des sommets de la ligne.
     *
     * @return Une liste des coordonnées des sommets de la ligne.
     */
    public List<Double> getSommets() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < ligne.length; i++) {
            result.add(ligne[i].x());
            result.add(ligne[i].y());
        }
        return result;
    }

    /**
     * Retourne la hauteur de la ligne, calculée comme la différence entre la coordonnée y maximale et la coordonnée y minimale parmi tous les sommets.
     *
     * @return La hauteur de la ligne.
     */
    public double hauteur() {
        List<Double> dy = new ArrayList<Double>();
        for(int i = 0; i < ligne.length; i++){
            dy.add(ligne[i].y());
        }
        Double max = dy.get(0);
        Double min = dy.get(0);
        for(int i = 1; i < dy.size(); i++){
            if(dy.get(i) > max){
                min = max;
                max = dy.get(i);
            } else if (min > dy.get(i)){
                min = dy.get(i);
            }
        }
        return max - min;
    }

    /**
     * Retourne la largeur de la ligne, calculée comme la différence entre la coordonnée x maximale et la coordonnée x minimale parmi tous les sommets.
     *
     * @return La largeur de la ligne.
     */
    public double largeur() {
        List<Double> dx = new ArrayList<Double>();
        for(int i = 0; i < ligne.length; i++){
            dx.add(ligne[i].x());
        }
        Double max = dx.get(0);
        Double min = dx.get(0);
        for(int i = 1; i < dx.size(); i++){
            if(dx.get(i) > max){
                min = max;
                max = dx.get(i);
            } else if (min > dx.get(i)){
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
        String result = "<polyline points=\"";
        result = result + ligne[0].x() + ' ' + ligne[0].y() + ' ';
        for (int i = 1; i < ligne.length; i++) {
            result = result + ligne[i].y() + ' ' + ligne[i].y() + ' ';
        }
        result = result + "\" fill=\"white\" stroke=\"" + couleur + "\"/>";
        return result;
    }

    /**
     * Déplace la ligne selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        for (int i = 0; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() + dx, ligne[i].y() + dy);
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
        for (int i = 0; i < ligne.length; i++) {
            ligne2.ajouterSommet(ligne[i]);
        }
        return ligne2;
    }

    /**
     * Redimensionne la ligne selon les dimensions spécifiées.
     *
     * @param h La hauteur de redimensionnement.
     * @param l La largeur de redimensionnement.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        for (int i = 1; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() + h, ligne[i].y() + l);
        }
        return this;
    }

    /**
     * Change la couleur de la ligne.
     *
     * @param couleurs Un tableau de couleurs à appliquer à la ligne.
     * @return Une référence à l'instance de la ligne, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme colorier(String... couleurs) {
        this.couleur = couleurs[0];
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
}
