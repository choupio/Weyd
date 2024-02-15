package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PolygoneTest {
    private Polygone polygone;

    @Before
    public void setUp() {
        polygone = new Polygone();
    }

    @Test
    public void testAjouterSommet() {
        assertEquals(Collections.emptyList(), polygone.getSommets());
        double d1, d2;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            d1 = random.nextInt(200);
            d2 = random.nextInt(200);
            polygone.ajouterSommet(d1, d2);
            assertEquals(i + 1, polygone.getSommets().size());
            assertTrue(polygone.getSommets().get(i).equals(new Point(d1, d2)));
        }
    }

    @Test
    public void testAjouterSommet2() {
        assertEquals(Collections.emptyList(), polygone.getSommets());
        double d1, d2;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            d1 = random.nextInt(200);
            d2 = random.nextInt(200);
            polygone.ajouterSommet(new Point(d1, d2));
            assertEquals(i + 1, polygone.getSommets().size());
            assertTrue(polygone.getSommets().get(i).equals(new Point(d1, d2)));
        }
    }

    @Test
    public void testCentre() {

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
    public void testGetSommets() {
        assertEquals(Collections.emptyList(), polygone.getSommets());
        double d1, d2;
        Random random = new Random();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            d1 = random.nextInt(200);
            d2 = random.nextInt(200);
            points.add(new Point(d1, d2));
            polygone.ajouterSommet(new Point(d1, d2));
        }

        for (int i = 0; i < points.size(); i++) {
            assertTrue(points.get(i).equals(polygone.getSommets().get(i)));
        }
    }

    @Test
    public void testHauteur() {
        polygone.ajouterSommet(0, 0);
        polygone.ajouterSommet(0, 56);
        assertEquals(56.0, polygone.hauteur(), 0.00001);
    }

    @Test
    public void testHauteur2() {
        polygone.ajouterSommet(10, 32);
        polygone.ajouterSommet(12, 56);
        assertEquals(24, polygone.hauteur(), 0.00001);
    }

    @Test
    public void testLargeur() {
        polygone.ajouterSommet(0, 0);
        polygone.ajouterSommet(0, 56);
        assertEquals(0, polygone.largeur(), 0.00001);
    }

    @Test
    public void testLargeur2() {
        polygone.ajouterSommet(10, 32);
        polygone.ajouterSommet(12, 56);
        assertEquals(2, polygone.largeur(), 0.00001);
    }

    @Test
    public void testRedimmensioner() {
        
    }
}
