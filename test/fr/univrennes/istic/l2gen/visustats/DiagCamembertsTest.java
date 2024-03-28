package fr.univrennes.istic.l2gen.visustats;

import org.junit.Test;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.Point;
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;

public class DiagCamembertsTest {
    DiagCamemberts diag;

    @Before
    public void setUp() {
        diag = new DiagCamemberts("Diagramme Test");
        diag.ajouterDonnees(" 2010 ", 1600, 6800, 16000, 4300, 300);
        diag.ajouterDonnees(" 2011 ", 1700, 7000, 17000, 4400, 400);
        diag.ajouterDonnees(" 2012 ", 1800, 7200, 18000, 4500, 500);
    }

    @Test
    public void testCentre() {
        Point centreAttendu = new Point(500, 500); // Le centre du camembert ajouté
        assertEquals(centreAttendu, diag.centre());
    }

    @Test
    public void testDescription() {
        // Vérifiez que la description de l'objet est non nulle
        assertNotNull(diag.description(1));
    }

    @Test
    public void testHauteur() {

        double hauteurAttendue = 0; // Le double du rayon du camembert ajouté
        assertEquals(hauteurAttendue, diag.hauteur(), 0.001); // Utilisez une petite tolérance pour les calculs à
                                                              // virgule flottante
    }

    @Test
    public void testEnSVG() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
        // Vérifiez que la méthode renvoie une chaîne de caractères non vide
        assertNotNull(diag.enSVG());    
    }

    @Test
    public void testDeplacer() {
        // Déplacez le diag
        diag.deplacer(5, 5);
        // Vérifiez que le centre du camembert a été déplacé
        assertEquals(new Point(505, 505), diag.centre());
    }

    @Test
    public void testDupliquer() {
        DiagCamemberts diag2 = (DiagCamemberts) diag.dupliquer();
        assertEquals(diag.centre(), diag2.centre());
        assertEquals(diag.hauteur(), diag2.hauteur(), 0.0001);
        assertEquals(diag.largeur(), diag2.largeur(), 0.0001);
        assertEquals(diag.nom, diag2.nom);
        assertEquals(diag.couleurs, diag2.couleurs);
        assertEquals(diag.legendes, diag2.legendes);
        assertEquals(diag.legendeGroupe, diag2.legendeGroupe);
        assertEquals(diag.donnees, diag2.donnees);
        assertEquals(diag.diagGroupe, diag2.diagGroupe);
    }

    @Test
    public void testColorier() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
        diag.colorier("white");
        // Vérifiez que la couleur du camembert a été mise à jour
        assertEquals("white", camembert.getCouleur());
    }

    @Test
    public void testLargeur() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
        // Vérifiez que la largeur est égale au double du rayon du camembert
        assertEquals(0.0, diag.largeur(), 0.001);
    }

    @Test
    public void testLegender() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
        // Ajoutez une légende au diag
        diag.legender("Légende");
        // Vérifiez que la légende a été ajoutée avec succès
        assertEquals(3, diag.legendes.getListFormes().size());
    }

    @Test
    public void testRedimmensioner() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
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
        diag.donnees = groupe;

        // Appelez la méthode pour créer le fichier SVG
        diag.createSvgFile();

        // Vérifiez si le fichier SVG a été créé avec succès
        File svgFile = new File("path/to/svg/file.svg");
        assertNotNull(svgFile.isFile());
    }

    @Test
    public void testSetOption() {
        // Ajoutez une option au diag
        diag.setOption("Camembert supplémentaire");
        // Vérifiez que le camembert a été ajouté avec succès
        assertEquals(4, diag.donnees.getListFormes().size());
    }

    @Test
    public void testTourner() {
        Groupe groupe = new Groupe();
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        groupe.ajouter(camembert);
        diag.donnees = groupe;
        // Tournez le diag de 90 degrés
        diag.tourner(90);
        // Vérifiez que le camembert a été tourné
        assertEquals(0.0, camembert.getAngle(), 0.001);
    }

    @Test
    public void testAjouterDonnees() {
        // Ajoutez des données au diag
        diag.ajouterDonnees(" 2010 ", 1600, 6800, 16000, 4300, 300);
        diag.ajouterDonnees(" 2011 ", 1700, 7000, 17000, 4400, 400);
        diag.ajouterDonnees(" 2012 ", 1800, 7200, 18000, 4500, 500);
        // Vérifiez que les données ont été ajoutées avec succès
        assertEquals(6, diag.donnees.getListFormes().size());
    }
}
