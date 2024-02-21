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
        Groupe groupe = new Groupe(cercleTest,polygone);
    }

    @Test
    public void testAjouter() {

    }

    @Test
    public void testCentre() {

    }

    @Test
    public void testColorier() {

    }

    @Test
    public void testDeplacer() {

    }

    @Test
    public void testDescription() {

    }

    @Test
    public void testDupliquer() {

    }

    @Test
    public void testEnSVG() {

    }

    @Test
    public void testHauteur() {

    }

    @Test
    public void testLargeur() {

    }

    @Test
    public void testRedimmensioner() {

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
