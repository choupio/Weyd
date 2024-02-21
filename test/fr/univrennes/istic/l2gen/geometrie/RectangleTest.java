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
        IForme rectangleDeplace = r.deplacer(8, 5);
        assertEquals(13, rectangleDeplace.centre().x(), 0.0001);
        assertEquals(11, rectangleDeplace.centre().y(), 0.0001);
    }

    @Test
    public void testDescription() {
        assertEquals(" Rectangle Centre=" + r.centre().x() + "," + r.centre().y() + " L=" + r.largeur() + " H="
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
        Rectangle r3 =  (Rectangle) r.redimmensioner(9, 8);
        assertEquals(r2.centre(), r3.centre());
        assertEquals(r2.largeur(), r3.largeur(),0.0001);
        assertEquals(r2.hauteur(),r3.hauteur(),0.0001);
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

    @Test
    public void testAlignement(){
        Rectangle r2 = new Rectangle(8,7,12,9);
        Rectangle r3 = r.aligner(Alignement.HAUT, r2.centre().y()); //je comprends pas comment faire le test, mais il faut le faire avant la fonction
    }
}
