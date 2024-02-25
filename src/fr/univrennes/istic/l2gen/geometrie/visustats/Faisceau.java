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

    public String getCouleur() {
        return couleur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Rectangle> getBarres() {
            return barres;
        }
    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.barres = new ArrayList<Rectangle>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(0, 0, 1, h[i]);
            this.barres.add(r);
        }
    }

    public Faisceau(Faisceau faisceau) {
        this.nom = faisceau.nom;
        this.barres = new ArrayList<>();
        for (Rectangle rect : faisceau.barres) {
            this.barres.add(rect); // Réutilise le même objet Rectangle sans créer une nouvelle copie
        }
    }
    public void agencer(double x, double y, double largeur, double hauteur, boolean vertical) {
        // Vérification des paramètres
        if (largeur <= 0 || hauteur <= 0) {
            throw new IllegalArgumentException("Largeur et hauteur doivent être positifs");
        }
        // Création du rectangle
        Rectangle rectangle = new Rectangle(x + largeur / 2, y + hauteur / 2, largeur, hauteur);
        // Ajout du rectangle à la liste des barres
        barres.add(rectangle);
        // Agencement vertical ou horizontal
        if (vertical) {
            for (int i = 1; i < barres.size(); i++) {
                double newX = barres.get(i - 1).centre().x();
                double newY = barres.get(i - 1).centre().y() + barres.get(i - 1).hauteur() / 2 + hauteur / 2;
                barres.get(i).deplacer(newX, newY);
            }
        } else {
            for (int i = 1; i < barres.size(); i++) {
                double newX = barres.get(i - 1).centre().x() + barres.get(i - 1).largeur() / 2 + largeur / 2;
                double newY = barres.get(i - 1).centre().y();
                barres.get(i).deplacer(newX, newY);
            }
        }
    }
    

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

    @Override
    public IForme dupliquer() {
        Faisceau faisceau = new Faisceau(this);
        return faisceau;
    }

}
