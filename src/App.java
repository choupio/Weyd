import org.junit.Before;

import fr.univrennes.istic.l2gen.geometrie.Cercle;
import fr.univrennes.istic.l2gen.geometrie.Ellipse;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Polygone;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Secteur;
import fr.univrennes.istic.l2gen.geometrie.Triangle;

public class App {
    private Cercle cercleTest;
    private Polygone polygone;
    private IForme groupe;

    public static void main(String[] args) throws Exception {

        // L'enlevez pas svp c'est pour debug
        Triangle debug = new Triangle(0, 0, 1, 0, 0, 1);
        debug.tourner(38);

        Groupe tableau = new Groupe();
        tableau.ajouter(new Cercle(256, 256, 128));
        tableau.ajouter(new Ellipse(256, 256, 128, 64));
        tableau.ajouter(new Ligne(128, 128, 128, 256, 256, 128, 256, 256));
        tableau.ajouter(new Polygone(128, 128, 128, 256, 256, 128, 256, 256));
        tableau.ajouter(new Rectangle(256, 256, 256, 128));
        tableau.ajouter(new Secteur(256, 256, 128, 0, 60));
        tableau.ajouter(new Triangle(192, 128, 256, 128, 256, 256));
        tableau.createSvgFile();

        Cercle cercleTest = new Cercle(50, 40, 25);
        Cercle cercleTest2 = new Cercle(50, 40, 25);
        Polygone polygone = new Polygone();
        polygone.ajouterSommet(128, 128);
        polygone.ajouterSommet(128, 256);
        polygone.ajouterSommet(256, 128);
        polygone.ajouterSommet(256, 256);
        Groupe groupe = new Groupe(cercleTest, polygone, cercleTest2);
        System.out.println(groupe.description(3));

    }
}
