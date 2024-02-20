package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

    Triangle triangle;
    @Before
    public void setUp() {
        triangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
    }


    @Test
    public void testCentre() {
        Point centre = triangle.centre();
        assertEquals(1.0/3, centre.x(), 0.001);
        assertEquals(1.0/3, centre.y(), 0.001);
    }

    @Test
    public void testDescription() {
        String description = triangle.description(2);
        assertEquals("  Triangle 0.0, 0.0 1.0, 0.0 0.0, 1.0 de couleur white", description);
    }

    @Test
    public void testCote() {
        double cote = triangle.cote(new Point(0, 0), new Point(1, 1));
        assertEquals(Math.sqrt(2), cote, 0.001);
    }

    @Test
    public void testDeplacer() {
        triangle.deplacer(1, 1);
        assertEquals(1.0, triangle.point1.x(), 0.001);
        assertEquals(1.0, triangle.point1.y(), 0.001);
        assertEquals(2.0, triangle.point2.x(), 0.001);
        assertEquals(1.0, triangle.point2.y(), 0.001);
        assertEquals(1.0, triangle.point3.x(), 0.001);
        assertEquals(2.0, triangle.point3.y(), 0.001);
    }

    @Test
    public void testColorier() {
        triangle.colorier("red");
        assertEquals("red", triangle.couleur);
    }

    @Test
    public void testDupliquer() {
        Triangle copie = (Triangle) triangle.dupliquer();
        assertEquals(triangle.centre().x(), copie.centre().x(), 0.001);
        assertEquals(triangle.centre().y(), copie.centre().y(), 0.001);
    }

    @Test
    public void testEnSVG() {
        String svg = triangle.enSVG();
        assertEquals("<polygon points=\"0.0,0.0 1.0,0.0 0.0,1.0\" fill=\"white\" stroke=\"black\"/>", svg);
    }

    @Test
    public void testHauteur() {
        double hauteur = triangle.hauteur();
        assertEquals(1.0, hauteur, 0.001);
    }

    @Test
    public void testLargeur() {
        double largeur = triangle.largeur();
        assertEquals(1.0, largeur, 0.001);
    }

    @Test
    public void testRedimmensioner() {
        triangle.redimmensioner(2, 2);
        assertEquals(2.0, triangle.hauteur(), 0.001);
        assertEquals(2.0, triangle.largeur(), 0.001);
    }
}
