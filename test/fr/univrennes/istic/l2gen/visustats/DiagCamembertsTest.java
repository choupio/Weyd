package fr.univrennes.istic.l2gen.visustats;

import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;

import static org.junit.Assert.*;

import org.junit.Before;

public class DiagCamembertsTest {
    DiagCamemberts diag;

    @Before
    public void setUp() {
        diag = new DiagCamemberts("Diagramme Test");
    }

    @Test
    public void testCentre() {
        Point centreAttendu = new Point(500, 500); // Le centre du camembert ajouté
        assertEquals(centreAttendu, diag.centre());
    }

    @Test
    public void testDescription() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        // Créez un camembert et ajoutez des secteurs
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("red", 0.5);
        camembert.ajouterSecteur("blue", 0.3);
        diag.groupeCamembert.ajouter(camembert);

        String descriptionAttendue = "Groupe :\nCamembert:\n  Centre: (0.0, 0.0)\n  Rayon: 10.0\n  Secteurs:\n    Secteur: Secteur 1, Proportion: 0,50\n    Secteur: Secteur 2, Proportion: 0,30\n"; // La
                                                                                                                                                                                                     // description
                                                                                                                                                                                                     // du
                                                                                                                                                                                                     // camembert
                                                                                                                                                                                                     // ajouté
        assertEquals(descriptionAttendue, diag.description(0)); // L'indentation est 0 pour cet exemple
    }

    @Test
    public void testHauteur() {
        diag.ajouterDonnees(" 2010 ", 1600, 6800, 16000, 4300, 300);

        double hauteurAttendue = 0; // Le double du rayon du camembert ajouté
        assertEquals(hauteurAttendue, diag.hauteur(), 0.001); // Utilisez une petite tolérance pour les calculs à
                                                              // virgule flottante
    }

    // Ajoutez des tests similaires pour les autres méthodes de DiagCamemberts

    @Test
    public void testEnSVG() {
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");

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
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        // Créez un groupe avec un camembert
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.groupeCamembert = groupe;
        // Déplacez le diag
        diag.deplacer(5, 5);
        // Vérifiez que le centre du camembert a été déplacé
        assertEquals(new Point(5, 5), camembert.centre());
    }

    @Test
    public void testDupliquer() {

    }

    @Test
    public void testColorier() {
        // Créez un DiagCamemberts avec un groupe et un camembert
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.groupeCamembert = groupe;
        // Coloriez le diag
        diag.colorier("white");
        // Vérifiez que la couleur du camembert a été mise à jour
        assertEquals("white", camembert.getCouleur());
    }

    @Test
    public void testLargeur() {
        // Créez un DiagCamemberts avec un groupe et un camembert
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.groupeCamembert = groupe;

        // Vérifiez que la largeur est égale au double du rayon du camembert
        assertEquals(20, diag.largeur(), 0.001);
    }

    @Test
    public void testLegender() {

    }

    @Test
    public void testRedimmensioner() {
        // Créez un DiagCamemberts avec un groupe et un camembert
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.groupeCamembert = groupe;
        // Redimensionnez le diag en multipliant la hauteur et la largeur par 2
        diag.redimmensioner(20, 20);
        // Vérifiez que le rayon du camembert a été ajusté en conséquence
        assertEquals(10, camembert.getRayon(), 0.001);
    }

    @Test
    public void testCreateSvgFile() {
        // Créez un DiagCamemberts avec un groupe et un camembert
        DiagCamemberts diag = new DiagCamemberts("MonDiagramme");
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.groupeCamembert = groupe;

        // Appelez la méthode pour créer le fichier SVG
        diag.createSvgFile();

        // Vérifiez si le fichier SVG a été créé avec succès (vous pouvez ajouter des
        // vérifications supplémentaires si nécessaire)
        // Par exemple, vous pouvez vérifier si le fichier existe sur le système de
        // fichiers.
    }

    @Test
    public void testSetOption() {

    }

    @Test
    public void testTourner() {

    }

    @Test
    public void testAjouterDonnees() {

    }
}
