package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GroupeTest {
    private Cercle cercleTest;
    private Polygone polygone;
    private IForme groupe;

    @Before
    public void initCerc() {
        double rayonCerc = 25;
        Point pointCerc = new Point(50, 40);
        cercleTest = new Cercle(pointCerc, rayonCerc);
        polygone = new Polygone();
		polygone.ajouterSommet(128, 128);
		polygone.ajouterSommet(128, 256);
		polygone.ajouterSommet(256, 128);
		polygone.ajouterSommet(256, 256);
        this.groupe = new Groupe(cercleTest,polygone);
    }

    @Test
    public void testAjouter() {
        Cercle nouveauCercle = new Cercle(new Point(30, 30), 20);
        groupe.ajouter(nouveauCercle);
        assertEquals(3, ((Groupe) groupe).getListFormes().size()); // Assuming appropriate getter for listFormes
    }

    @Test
    public void testCentre() {
        Point centre = groupe.centre();
        assertEquals(65.0, centre.x(), 0.001);
        assertEquals(68.0, centre.y(), 0.001);
    }

    @Test
    public void testColorier() {
        groupe.colorier("red", "green");
        // Assuming appropriate assertions for verifying color changes in each shape
    }

    @Test
    public void testDeplacer() {
        groupe.deplacer(10, 20);
        Point newCentre = groupe.centre();
        assertEquals(75.0, newCentre.x(), 0.001);
        assertEquals(88.0, newCentre.y(), 0.001);
    }

    @Test
    public void testDescription() {
        String expectedDescription = "Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n"
                + "      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white\n";
        assertEquals(expectedDescription, groupe.description(3));
    }

    @Test
    public void testDupliquer() {
        IForme groupeDuplique = groupe.dupliquer();
        assertEquals(groupe.description(0), groupeDuplique.description(0));
    }

    @Test
    public void testEnSVG() {

    }

    @Test
    public void testHauteur() {
        double hauteur = groupe.hauteur();
        // Adjust the expected value based on your correct logic
        assertEquals(128.0, hauteur, 0.001);
    }

    @Test
    public void testLargeur() {
        double largeur = groupe.largeur();
        assertEquals(128.0, largeur, 0.001);
    }

    @Test
    public void testRedimmensioner() {
        groupe.redimmensioner(2, 1);
        assertEquals(432.0, groupe.hauteur(), 0.001);
        assertEquals(128.0, groupe.largeur(), 0.001);
    }
    @Test
    public void testTourner() {
        assertEquals("Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white\n", groupe.description(3));
    }
    @Test
    public void testTourner2() {
        groupe.tourner(180); // Rotation de 180 degrés
        assertEquals("Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black angle=180\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white angle=180\n", groupe.description(3));
    }
}
