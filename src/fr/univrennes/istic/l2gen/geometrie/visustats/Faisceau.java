package fr.univrennes.istic.l2gen.geometrie.visustats;

import java.util.List;
import java.util.ArrayList;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;

public class Faisceau extends Groupe {
    private String nom;
    private List<Rectangle> barres;
    private String couleur = "red";

    /**
     * Retourne la couleur du faisceau.
     *
     * @return La couleur du faisceau.
     */
    public String getCouleur() {
        return couleur;
    }
    /**
     * Retourne le nom du faisceau.
     *
     * @return Le nom du faisceau.
     */
    public String getNom() {
        return nom;
    }
     /**
     * Retourne la liste des rectangles du faisceau.
     *
     * @return La liste des rectangles du faisceau.
     */
    public List<Rectangle> getBarres() {
            return barres;
    }

    /**
     * Constructeur de la classe Faisceau.
     *
     * @param nom Le nom du faisceau.
     * @param h   Un tableau de hauteurs pour créer les rectangles du faisceau.
     */
    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.barres = new ArrayList<Rectangle>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(0, 0, 1, h[i]);
            this.barres.add(r);
        }
    }
    /**
     * Constructeur de copie de la classe Faisceau.
     *
     * @param faisceau Le faisceau à copier.
     */
    public Faisceau(Faisceau faisceau) {
        this.nom = faisceau.nom;
        this.barres = new ArrayList<>();
        for (Rectangle rect : faisceau.barres) {
            this.barres.add(rect); // Réutilise le même objet Rectangle sans créer une nouvelle copie
        }
    }
    /**
     * Agence les rectangles du faisceau en fonction des paramètres spécifiés.
     *
     * @param x        La coordonnée x du point de départ.
     * @param y        La coordonnée y du point de départ.
     * @param largeur  La largeur des rectangles.
     * @param hauteur  La hauteur des rectangles.
     * @param vertical Indique si les rectangles doivent être alignés verticalement (true) ou horizontalement (false).
     */
    public void agencer(double x, double y, double largeur, double hauteur, boolean vertical) {
        // Création du rectangle
        Rectangle rectangle = new Rectangle(x + largeur / 2, y + hauteur / 2, largeur, hauteur);
        // Ajout du rectangle à la liste des barres
        barres.add(rectangle);
        // Agencement vertical ou horizontal
        if (vertical) {
            for (int i = 1; i < barres.size(); i++) {
                double newX = barres.get(i+1).centre().x();
                double newY = barres.get(i+1).centre().y() + barres.get(i+1).hauteur() / 2 + hauteur / 2;
                barres.get(i).deplacer(newX, newY);
            }
        } else {
            for (int i = 1; i < barres.size(); i++) {
                double newX = barres.get(i+1).centre().x() + barres.get(i+1).largeur() / 2 + largeur / 2;
                double newY = barres.get(i+1).centre().y();
                barres.get(i).deplacer(newX, newY);
            }
        }
    }
    
    /**
     * Colore chaque rectangle du faisceau avec les couleurs spécifiées.
     *
     * @param couleurs Un tableau de couleurs à appliquer aux rectangles du faisceau.
     * @return Une référence à l'instance actuelle du faisceau, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme colorier(String... couleurs) {
        int i = 0;
        for (Rectangle rect : barres) {
            rect.colorier(couleurs[i]);
            i++;
            if (i >= barres.size()) {
                i = 0;
            }
        }
        return this;
    }
    /**
     * Duplique le faisceau.
     *
     * @return Un nouveau faisceau contenant des copies des rectangles du faisceau actuel.
     */
    @Override
    public IForme dupliquer() {
        Faisceau faisceau = new Faisceau(this);
        return faisceau;
    }

}
