
/*import fr.univrennes.istic.l2gen.geometrie.*;
import fr.univrennes.istic.l2gen.station.Station;
import fr.univrennes.istic.l2gen.station.StationParCarb;*/
<<<<<<< HEAD
import java.util.ArrayList;

import fr.univrennes.istic.l2gen.station.StationAPI;
=======
import fr.univrennes.istic.l2gen.rapport.Fonction;
>>>>>>> 92c603ac811002aa6c77991b1340eba8faa59ba1
import fr.univrennes.istic.l2gen.visustats.*;

/*import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;*/

/**
 * Cette classe représente l'application principale.
 * 
 * Pour tester et afficher des éléments d'autres classes, il suffit de
 * décommenter les lignes de code correspondantes.
 * Ne pas oublier de remettre les imports sans les slashs pour pouvoir réaliser
 * les autres tests.
 */
public class App {

    public static void main(String[] args) throws Exception {

        StationAPI s = new StationAPI();
        ArrayList<String> d = new ArrayList<>();
        d.add("Morbihan");
        ArrayList<String> c = new ArrayList<>();
        c.add("Gazole");
        ArrayList<String> sv = new ArrayList<>();
        sv.add("");
        s.filtreDep(d, c, c);
        System.out.println(s.getPrixMoyen());

        
        DiagCamemberts visualiseur = new DiagCamemberts(" Emissions de CO2 ( en Mt ) ");
        visualiseur.legender(" Afrique ", " Amerique ", " Asie ", " Europe ", " Oceanie ");
        visualiseur.ajouterDonnees(" 2010 ", 1600, 6800, 16000, 4300, 300);
        visualiseur.ajouterDonnees(" 2015 ", 1900, 6600, 17500, 3800, 330);
        visualiseur.ajouterDonnees(" 2020 ", 2100, 6200, 17800, 3600, 340);
        visualiseur.colorier(" Blue ", " Green ", " Red ", " Yellow ", " Maroon ");
        visualiseur.agencer().createSvgFile();

        Fonction.createHTMLFile("Ouais", visualiseur.enSVG(), "TEst", "rapport");

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

        /*
         * Faisceau fg = new Faisceau(" Exemple de Faisceau vertical ", 100, 200, 500);
         * fg.colorier(" cyan ", " purple ", " yellow ");
         * fg.agencer(20, 250, 100, 0.2, true);
         * fg.createSvgFile();
         */

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

        // Création d'un Faisceau
        /*
         * Faisceau f = new Faisceau("Exemple", 100, 200, 500);
         * f.agencer(200, 250, 100, 0.2, false);
         * f.createSvgFile();
         */

        // Affichage du diagramme en colonnes
        /*
         * DiagColonnes d = new DiagColonnes("test");
         * d.legender("samax", "samax", "samax");
         * d.ajouterDonnees("2010", 1600, 6800, 16000);
         * d.ajouterDonnees("2015", 1600, 6800, 16000);
         * d.colorier("Red", "Black", "Blue");
         * d.agencer().createSvgFile();
         */

        // AccueilSwing s1 = new AccueilSwing();

        // Création d'un camembert

        /*
         * Camembert camembert = new Camembert(110, 110, 100);
         * camembert.ajouterSecteur("red", 0.15);
         * camembert.ajouterSecteur("blue", 0.2);
         * camembert.ajouterSecteur("green", 0.65);
         * System.out.println(camembert.description(0));
         * camembert.createSvgFile();
         * 
         * // Créez un ObjectMapper
         * ObjectMapper objectMapper = new ObjectMapper();
         * 
         * // Spécifiez le chemin vers votre fichier JSON
         * String cheminFichier =
         * "ressources/prix-carburants-fichier-quotidien-test-ods.json";
         * 
         * // Essayez d'ouvrir et de mapper le fichier JSON en un objet Java
         * try {
         * // Utilisez la méthode readValue() de l'ObjectMapper pour mapper le fichier
         * JSON
         * // en un objet Java.
         * List<StationParCarb> stations = objectMapper.readValue(new
         * File(cheminFichier),
         * new TypeReference<List<StationParCarb>>() {
         * });
         * 
         * // Faites ce que vous voulez avec votre objet ici
         * HashMap<String, Station> stations2 = new HashMap<>();
         * for (StationParCarb station : stations) {
         * if (!stations2.containsKey(station.getId())) {
         * stations2.put(station.getId(),
         * new Station(station.getServices_service(), station.getDep_name(),
         * station.getVille(),
         * station.getAdresse(),
         * station.getReg_name(), station.getDep_code(), station.getReg_code()));
         * }
         * 
         * stations2.get(station.getId()).ajoutCarburant(station.getPrix_nom(),
         * station.getPrix_valeur());
         * }
         * 
         * } catch (IOException e) {
         * // Gérez les erreurs d'entrée/sortie ici
         * e.printStackTrace();
         * }
         * 
         * // Autre manière de faire le camembert
         * /*
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
    }
}
