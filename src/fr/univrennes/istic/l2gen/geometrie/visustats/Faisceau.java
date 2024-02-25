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

    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.barres = new ArrayList<Rectangle>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(0, 0, 1, h[i]);
            this.barres.add(r);
        }
    }

    public Faisceau(Faisceau faisceau) {
        // TODO
    }

    public void agencer(double axeX, double axeY, double largeur, double echelle, boolean verticalement) {
        this.alignerElements(Alignement.GAUCHE, axeX);
        this.alignerElements(Alignement.BAS, axeY);
        // faisceau vertical
        if (verticalement) {

        }
        // faisceau horizontal
        else {

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
