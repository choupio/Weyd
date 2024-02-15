import fr.univrennes.istic.l2gen.geometrie.Cercle;
import fr.univrennes.istic.l2gen.geometrie.Ellipse;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.Hexagone;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Polygone;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Secteur;
import fr.univrennes.istic.l2gen.geometrie.Triangle;

public class App {
    public static void main(String[] args) throws Exception {
        Polygone r1 = new Polygone(128, 128, 128, 256, 256, 256, 256, 128);
        r1.colorier("red");
        System.out.println(r1.enSVG());
        Groupe tableau = new Groupe ();
        tableau . ajouter ( new Cercle (256 , 256 , 128));
        tableau . ajouter ( new Ellipse (256 , 256 , 128 , 64));
        tableau . ajouter ( new Ligne (128 , 128 , 128 , 256 , 256 , 128 , 256 , 256));
        tableau . ajouter ( new Polygone (128 , 128 , 128 , 256 , 256 , 128 , 256 , 256));
        tableau . ajouter ( new Rectangle (256 , 256 , 256 , 128));
        tableau . ajouter ( new Secteur (256 , 256 , 128 , 0 , 60));
        tableau . ajouter ( new Triangle (192 , 128 , 256 , 128 , 256 , 256));
        tableau.createSvgFile();
    }
}
