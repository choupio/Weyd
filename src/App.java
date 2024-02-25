
import fr.univrennes.istic.l2gen.geometrie.*;
import fr.univrennes.istic.l2gen.geometrie.visustats.Camembert;

public class App {

    public static void main(String[] args) throws Exception {

        /*
         * Groupe tableau = new Groupe();
         * tableau.ajouter(new Cercle(256, 256, 128).colorier("white"));
         * tableau.ajouter(new Ellipse(256, 256, 128, 64));
         * tableau.ajouter(new Ligne(128, 128, 128, 256, 256, 128, 256, 256));
         * tableau.ajouter(new Polygone(128, 128, 128, 256, 256, 128, 256, 256));
         * tableau.ajouter(new Rectangle(256, 256, 256, 128));
         * tableau.ajouter(new Secteur(new Point(256, 256), 128, 30, 60));
         * tableau.ajouter(new Triangle(192, 128, 128, 256, 256, 256));
         * System.out.println(tableau.description(3));
         * System.out.println(tableau.enSVG());
         * tableau.createSvgFile();
         */

        Groupe secteurs = new Groupe();
        secteurs.ajouter(new Secteur(new Point(256, 256), 128, 30, 60).colorier("red").deplacer(800, 0.0));
        secteurs.ajouter(new Secteur(new Point(256, 256), 128, 90, 230).colorier("green").deplacer(800, 0.0));
        secteurs.ajouter(new Secteur(new Point(256, 256), 128, 320, 70).colorier("blue").deplacer(800, 0.0));
        secteurs.createSvgFile();
        System.out.println(secteurs.description(3));

        /*
         * Cercle cercleTest = new Cercle(50, 40, 25);
         * Cercle cercleTest2 = new Cercle(50, 40, 25);
         * Polygone polygone = new Polygone();
         * polygone.ajouterSommet(128, 128);
         * polygone.ajouterSommet(128, 256);
         * polygone.ajouterSommet(256, 128);
         * polygone.ajouterSommet(256, 256);
         * Groupe groupe = new Groupe(cercleTest, polygone, cercleTest2);
         * System.out.println(groupe.description(3));
         */

        Camembert c = new Camembert(110, 110, 100);
        c.ajouterSecteur("red", 0.15);
        c.ajouterSecteur("blue", 0.2);
        c.ajouterSecteur("green", 0.65);
        System.out.println(c.description(2));

    }
}
