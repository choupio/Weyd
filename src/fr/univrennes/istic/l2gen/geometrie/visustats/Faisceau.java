package fr.univrennes.istic.l2gen.geometrie.visustats;

<<<<<<< HEAD
public class Faisceau {
    
=======
import java.util.List;
import java.util.ArrayList;

import fr.univrennes.istic.l2gen.geometrie.Rectangle;

public class Faisceau {
    private String nom;
    private List<Rectangle> barres;

    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.barres = new ArrayList<Rectangle>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(0, 0, 1, h[i]);
            this.barres.add(r);
        }
    }

>>>>>>> a68f303cf4073c37a6f482354f751412897a5eb9
}
