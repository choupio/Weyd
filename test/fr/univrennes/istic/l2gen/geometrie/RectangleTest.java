package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    Rectangle r;

    @Before
    public void setUp() {
        Point c = new Point(5, 6);
        r = new Rectangle(c, 5, 8);
    }

    @Test
    public void testCentre() {
        setUp();
        Point c = new Point(5, 6);
        Point centre = r.centre();
        assertEquals(c.x(), centre.x(), 0.0001);
        assertEquals(c.y(), centre.y(), 0.0001);
    }

    @Test
    public void testColorier() {
        r.colorier("rouge");
        assertEquals("<rect x=\"" + r.centre().x() + "\" y=\"" + r.centre().y() + "\" height=\"" + r.hauteur()
                + "\" width=\""
                + r.largeur()
                + "\"\n" + "\t" + "fill=\"" + "rouge" + "\"" + " stroke=\"black\"/>", r.enSVG());
    }

    @Test
    public void testDeplacer() {
        IForme rectangleDeplace = r.deplacer(8,5);
        assertEquals(13, rectangleDeplace.deplacer(8, 5).centre().x(), 0.0001);
        assertEquals(11, rectangleDeplace.centre().y(), 0.0001);
    }

    @Test
    public void testDescription() {
        assertEquals("  Rectangle Centre=" + r.centre().x() + "," + r.centre().y() + " L=" + r.largeur() + " H="
                + r.hauteur() + " de couleur white", r.description(1));
    }

    @Test
    public void testDupliquer() {
        setUp();
        Rectangle r2 = (Rectangle) r.dupliquer();
        assertEquals(r.centre(), r2.centre());
        assertEquals(r.hauteur(), r2.hauteur(), 0.0001);
        assertEquals(r.largeur(), r2.largeur(), 0.0001);
    }

    @Test
    public void testEnSVG() {
        assertEquals("<rect x=\"" + r.centre().x() + "\" y=\"" + r.centre().y() + "\" height=\"" + r.hauteur()
                + "\" width=\""
                + r.largeur()
                + "\"\n" + "\t" + "fill=\"" + "white" + "\"" + " stroke=\"black\"/>", r.enSVG());
    }

    @Test
    public void testHauteur() {
        assertEquals(8, r.hauteur(), 0.0001);
    }

    @Test
    public void testLargeur() {
        assertEquals(5, r.largeur(), 0.0001);
    }

    @Test
    public void testRedimmensioner() {
        Rectangle r2 = new Rectangle(r.centre(), 8, 9);
        assertEquals(true, r2.equals(r.redimmensioner(9, 8)));
    }

    @Test
    public void testSetHauteur() {
        r.setHauteur(3);
        assertEquals(3, r.hauteur(), 0.0001);
    }

    @Test
    public void testSetLargeur() {
        r.setLargeur(3);
        assertEquals(3, r.largeur(), 0.0001);
    }
}
