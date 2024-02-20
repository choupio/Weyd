package fr.univrennes.istic.l2gen.geometrie;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;


public class LigneTest {

    Ligne ligne;
    @Before
    public void setUp() {
        ligne = new Ligne(10, 20, 30, 40, 50, 60);
    }


    @Test
    public void testAjouterSommet() {
        ligne.ajouterSommet(new Point(70, 80));
        assertEquals(70, ligne.centre().x(), 0.001);
        assertEquals(80, ligne.centre().y(), 0.001);
    }

    @Test
    public void testAjouterSommet2() {
        ligne.ajouterSommet(70, 80);
        assertEquals(70, ligne.centre().x(), 0.001);
        assertEquals(80, ligne.centre().y(), 0.001);
    }

    @Test
    public void testCentre() {
        Point centre = ligne.centre();
        assertNotNull(centre);
        assertEquals(50, centre.x(), 0.001);
        assertEquals(60, centre.y(), 0.001);
    }

    @Test
    public void testColorier() {
        ligne.colorier("red");
        assertEquals("<polyline points=\"10.0 20.0 40.0 40.0 60.0 60.0 \" fill=\"white\" stroke=\"red\"/>", ligne.enSVG());
    }

    @Test
    public void testDeplacer() {
        IForme formeDeplacee = ligne.deplacer(5, 10);
        assertEquals(55, formeDeplacee.centre().x(), 0.001);
    }

    @Test
    public void testDescription() {
        setUp();
        assertEquals("  Ligne 10.0,20.0 30.0,40.0 50.0,60.0 de couleur black", ligne.description(1));
    }

    @Test
    public void testDupliquer() {
        Ligne l2=(Ligne) ligne.dupliquer();
        assertEquals(ligne.getSommets(), l2.getSommets());
    }

    @Test
    public void testEnSVG() {
        assertEquals("<polyline points=\"10.0 20.0 40.0 40.0 60.0 60.0 \" fill=\"white\" stroke=\"black\"/>",ligne.enSVG());
    }


    @Test
    public void testGetSommets() {
        List<Double> sommets = ligne.getSommets();
        assertEquals(10, sommets.get(0), 0.001);
        assertEquals(20, sommets.get(1), 0.001);
        assertEquals(30, sommets.get(2), 0.001);
        assertEquals(40, sommets.get(3), 0.001);
        assertEquals(50, sommets.get(4), 0.001);
        assertEquals(60, sommets.get(5), 0.001);
    }

    @Test
    public void testHauteur() {
        assertEquals(40, ligne.hauteur(), 0.001);
    }

    @Test
    public void testLargeur() {
        assertEquals(40, ligne.largeur(), 0.001);
    }

    @Test
    public void testRedimmensioner() {
        IForme formeRedimensionnee = ligne.redimmensioner(10, 20);
        assertEquals(60, formeRedimensionnee.hauteur(), 0.001);
        assertEquals(50, formeRedimensionnee.largeur(), 0.001);
    }
}
