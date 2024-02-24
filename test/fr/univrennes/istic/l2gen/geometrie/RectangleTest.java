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
                + "\"\n" + "\t" + "fill=\"" + "rouge" + "\"" + " stroke=\"black\"" + " transform=\"rotate(0)\"/>", r.enSVG());
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
                + r.hauteur() + " de couleur white" + " angle=0", r.description(1));
    }

    @Test(expected = IllegalArgumentException.class) // On teste pour vérifier que la fonction renvoie IllegalArgumentException si l'indentation est négative.
    public void testDescriptionIndentationNeg(){
        r.description(-1);
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
                + "\"\n" + "\t" + "fill=\"" + "white" + "\"" + " stroke=\"black\"" + " transform=\"rotate(0)\"/>", r.enSVG());
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
        Rectangle r3 = (Rectangle) r.redimmensioner(0.5, 2);
        assertEquals(r.centre(), r3.centre());
        assertEquals(r3.largeur(), 10, 0.0001);
        assertEquals(r.hauteur(), 4, 0.0001);
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
    public void testTourner() { // en modifiant l'angle
        r.tourner(38);
        assertEquals(" Rectangle Centre=5.0,6.0 L=5.0 H=8.0 de couleur white angle=38", r.description(1));
    }

    @Test(expected = IllegalArgumentException.class) // pareil que le précédent mais quand l'angle est négatif
    public void testTournerNegatif(){
        r.tourner(-10);
    }

    @Test
    public void testTournerPasModif() { // sans modifier l'angle
        assertEquals(" Rectangle Centre=5.0,6.0 L=5.0 H=8.0 de couleur white angle=0", r.description(1));
    }
}
