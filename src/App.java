
import fr.univrennes.istic.l2gen.geometrie.*;
import fr.univrennes.istic.l2gen.visustats.*;
import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {

        DiagCamemberts diag = new DiagCamemberts("test", 3);
        diag.ajouterDonnees("2010", 6800, 10020, 62020, 2500, 10000);
        diag.colorier("orange", "red", "yellow", "blue", "green");
        System.out.println(diag.description(0));
        diag.createSvgFile();
        
        
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

        /*Cercle cercleTest = new Cercle(50, 40, 25);
        Cercle cercleTest2 = new Cercle(50, 40, 25);
        Polygone polygone = new Polygone();
        polygone.ajouterSommet(128, 128);
        polygone.ajouterSommet(128, 256);
        polygone.ajouterSommet(256, 128);
        polygone.ajouterSommet(256, 256);
        Groupe groupe = new Groupe(cercleTest, polygone, cercleTest2);
        System.out.println(groupe.description(3));*/

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
        /*Faisceau fg = new Faisceau(" Exemple de Faisceau vertical ", 100, 200, 500);
        fg.colorier(" cyan ", " purple ", " yellow ");
        fg.agencer(20, 250, 100, 0.2, true);
        fg.createSvgFile();*/

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
        /*Faisceau f = new Faisceau("Exemple", 100, 200, 500);
        f.agencer(200, 250, 100, 0.2, false);
        f.createSvgFile();

        DiagColonnes d = new DiagColonnes("test");

        d.legender("samax", "samax", "samax");
        d.ajouterDonnees("2010", 1600, 6800, 16000);
        d.ajouterDonnees("2015", 1600, 6800, 16000);
        d.colorier("Red", "Black", "Blue");
        d.agencer().createSvgFile();

        AccueilSwing s1 = new AccueilSwing();
        Camembert testCam = new Camembert(50, 50, 150);
        testCam.ajouterSecteur("green", 0.3);
        testCam.ajouterSecteur("black", 0.3);
        testCam.ajouterSecteur("yellow", 0.1);
        testCam.ajouterSecteur("white", 0.2);
        testCam.ajouterSecteur("red", 0.1);
        testCam.createSvgFile();*/
    }
}
