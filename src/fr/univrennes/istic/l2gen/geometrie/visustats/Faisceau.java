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
        this.nom = faisceau.nom;
        this.barres = new ArrayList<>();
        for (Rectangle rect : faisceau.barres) {
            this.barres.add(rect); // Réutilise le même objet Rectangle sans créer une nouvelle copie
        }
    }

    public void agencer(double axeX, double axeY, double largeur, double echelle, boolean verticalement) {
        this.aligner(Alignement.GAUCHE, axeX);
        this.aligner(Alignement.BAS, axeY);
        double offset = 0;
        if (verticalement) {
            for (Rectangle rect : barres) {
                rect.deplacer(0, offset);
                offset += rect.hauteur() + 5; // Ajustez selon l'espacement souhaité entre les barres verticales
            }
        } else {
            for (Rectangle rect : barres) {
                rect.deplacer(offset, 0);
                offset += rect.largeur() + 5; // Ajustez selon l'espacement souhaité entre les barres horizontales
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
