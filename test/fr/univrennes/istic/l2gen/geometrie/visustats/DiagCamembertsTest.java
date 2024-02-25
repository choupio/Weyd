package fr.univrennes.istic.l2gen.geometrie.visustats;

import org.junit.Assert;
import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import static org.junit.Assert.*;

public class DiagCamembertsTest {

    @Test
    public void testCentre() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme", 42);
        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);
        Point centreAttendu = new Point(0, 0); // Le centre du camembert ajouté
        assertEquals(centreAttendu, diag.centre());
    }

    @Test
    public void testDescription() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme", 42);
        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);

        String descriptionAttendue = "Groupe :\n Camembert:\n Centre: (0.0, 0.0)\n Rayon: 10.0\n Secteurs:\n  Secteur: Secteur 1, Proportion: 0,50\n  Secteur: Secteur 2, Proportion: 0,30\n"; // La description du camembert ajouté
        assertEquals(descriptionAttendue, diag.description(0)); // L'indentation est 0 pour cet exemple
    }

    @Test
    public void testHauteur() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme", 42);

        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);

        double hauteurAttendue = 20; // Le double du rayon du camembert ajouté
        assertEquals(hauteurAttendue, diag.hauteur(), 0.001); // Utilisez une petite tolérance pour les calculs à virgule flottante
    }

    // Ajoutez des tests similaires pour les autres méthodes de DiagCamemberts

    @Test
    public void testEnSVG() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme", 42);

        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);

        String svgAttendu = "<svg width=\"500\" height=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                            "  <circle cx=\"0.0\" cy=\"0.0\" r=\"10.0\" fill=\"lightblue\" />\n" +
                            "</svg>"; // Le SVG du camembert ajouté
        assertEquals(svgAttendu, diag.enSVG());
    }


    @Test
    public void testDeplacer() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme", 42);
        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);
        Point ancienCentre = diag.centre();
        double dx = 5.0;
        double dy = -3.0;
        diag.deplacer(dx, dy);

        Point nouveauCentreAttendu = new Point(ancienCentre.x() + dx, ancienCentre.y() + dy);
        assertEquals(nouveauCentreAttendu, diag.centre());
    }

    @Test
    public void testLargeur() {

    }

    @Test
    public void testLegender() {

    }

    @Test
    public void testRedimmensioner() {

    }

    @Test
    public void testSetOption() {

    }

    @Test
    public void testTourner() {

    }
}
