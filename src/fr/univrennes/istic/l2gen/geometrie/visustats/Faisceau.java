package fr.univrennes.istic.l2gen.geometrie.visustats;

import java.util.List;
import java.util.ArrayList;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;

public class Faisceau implements IForme {
    private String nom;
    private List<Rectangle> barres;
    private String couleur = "white";

    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.barres = new ArrayList<Rectangle>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(0, 0, 1, h[i]);
            this.barres.add(r);
        }
    }

    public void agencer(double axeX, double axeY, double largeur, double echelle, boolean verticalement) {

    }

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    public IForme dupliquer() {
        return this;
    }

    public Point centre() {
        throw new UnsupportedOperationException("Unimplemented method 'centre'");
    }

    public String description(int indentation) {
        throw new UnsupportedOperationException("Unimplemented method 'description'");
    }

    public double hauteur() {
        throw new UnsupportedOperationException("Unimplemented method 'hauteur'");
    }

    public double largeur() {
        throw new UnsupportedOperationException("Unimplemented method 'largeur'");
    }

    public IForme redimmensionner() {
        throw new UnsupportedOperationException("Unimplemented method 'redimensionner'");
    }

    public String enSVG() {
        throw new UnsupportedOperationException("Unimplemented method 'enSVG'");
    }

    public IForme tourner(int angle) {
        throw new UnsupportedOperationException("Unimplemented method 'tourner'");
    }

    public IForme aligner(Alignement alignement, double cible) {
        throw new UnsupportedOperationException("Unimplemented method 'aligner'");
    }

    public void createSvgFile() {
        throw new UnsupportedOperationException("Unimplemented method 'createSvgFile'");
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        throw new UnsupportedOperationException("Unimplemented method 'deplacer'");
    }

}
