
import fr.univrennes.istic.l2gen.geometrie.*;
import fr.univrennes.istic.l2gen.geometrie.visustats.*;
import javax.swing.*;

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

<<<<<<< HEAD
        Cercle cercleTest = new Cercle(50, 40, 25);
        Cercle cercleTest2 = new Cercle(50, 40, 25);
        Polygone polygone = new Polygone();
        polygone.ajouterSommet(128, 128);
        polygone.ajouterSommet(128, 256);
        polygone.ajouterSommet(256, 128);
        polygone.ajouterSommet(256, 256);
        Groupe groupe = new Groupe(cercleTest, polygone, cercleTest2);
        System.out.println(groupe.description(3));
        
=======
        // Autre manière de faire le camembert
        /*
         * Groupe secteurs = new Groupe();
         * secteurs.ajouter(new Secteur(new Point(256, 256), 128, 0,
         * 60).colorier("red").deplacer(800, 0.0));
         * secteurs.ajouter(new Secteur(new Point(256, 256), 128, 60,
         * 120).colorier("green").deplacer(800, 0.0));
         * secteurs.ajouter(new Secteur(new Point(256, 256), 128, 120,
         * 240).colorier("blue").deplacer(800, 0.0));
         * secteurs.createSvgFile();
         * System.out.println(secteurs.description(3));
         */
>>>>>>> b9332462b45fabd54185b061cd71880f6096c8c6

        /*
         * Groupe g = new Groupe();
         * g.ajouter(new Rectangle(256,256, 100, 50));
         * g.ajouter(new Rectangle(400,400, 100, 50));
         * g.ajouter(new Rectangle(600,600, 100, 50));
         * g.ajouter(new Rectangle(800,800, 100, 50));
         * g.alignerElements(Alignement.BAS, 500);
         * g.empilerElements(Alignement.GAUCHE, 500,10);
         * g.ajouter(new Cercle(500, 500, 10));
         * g.createSvgFile();
         */
        Faisceau fg = new Faisceau(" Exemple de Faisceau vertical ", 100, 200, 500);
        fg.colorier(" cyan ", " purple ", " yellow ");
        fg.agencer(20, 250, 100, 0.2, true);
        fg.createSvgFile();

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

        // Affichage du camembert
        Faisceau f = new Faisceau("Exemple", 100, 200, 500);
        f.agencer(200, 250, 100, 0.2, false);
        f.createSvgFile();

        DiagColonnes d = new DiagColonnes("test");

        d.legender("caca", "pipi", "proute");
        d.ajouterDonnees("2010", 1600, 6800, 16000);
        d.ajouterDonnees("2015", 1600, 6800, 16000);
        d.colorier("Red", "Black", "Blue");
        d.agencer().createSvgFile();

        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);
    }
}
