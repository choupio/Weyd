package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CercleTest {
    private Cercle cercleTest;
    private Point pointCerc;
    private double rayonCerc;

    @Before
    public void initCerc() {
        double rayonCerc = 25;
        Point pointCerc = new Point(50, 40);
        Cercle cercleTest = new Cercle(pointCerc, rayonCerc);
        this.cercleTest = cercleTest;
        this.pointCerc = pointCerc;
        this.rayonCerc = rayonCerc;
    }

    @Test
    public void testCentre() {
        assertEquals(pointCerc, cercleTest.centre());
    }

    @Test
    public void testDeplacer() {
        double x = 5;
        double y = 10;
        cercleTest.deplacer(x, y);
        assertEquals(55, pointCerc.x(), 0.0001);
        assertEquals(50, pointCerc.y(), 0.0001);
    }

    @Test
    public void testDescription() {
        assertEquals(cercleTest.description(3), "   Cercle centre= 50.0, 40.0 r= 25.0");
    }

    @Test
    public void testDupliquer() {
        IForme cercleDup = cercleTest.dupliquer();
        // Utilisation de centre pour vérifier les valeurs du point
        assertEquals(cercleTest.centre(), cercleDup.centre());
        assertEquals(rayonCerc, cercleDup.largeur()/2, 0.0001);
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
}
