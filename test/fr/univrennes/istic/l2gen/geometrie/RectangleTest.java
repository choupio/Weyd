package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    Rectangle r;
    @Before
    public void setUp(){
        r=new Rectangle(5, 6,5,8);
    }

    @Test
    public void testCentre() {
        Point c=new Point(5,6);
        Point centre=r.centre();
        assertEquals(c, centre);
    }

    @Test
    public void testColorier() {
        r.colorier("rouge");
        assertEquals("<rect x=\"" + r.centre().x() + "\" y=\"" + r.centre().y() + "\" height=\"" + r.hauteur() + "\" width=\""
        + r.largeur()
        + "\"\n" + "\t" + "fill=\"" + "rouge" + "\"" + " stroke=\"black\"/>", r.enSVG());
    }

    @Test
    public void testDeplacer() {
        Point c=new Point(r.centre().x()+8, r.centre().y()+5);
        r.deplacer(8, 5);
        assertEquals(c, r.centre());
    }

    @Test
    public void testDescription() {
        assertEquals("  Rectangle Centre=" + r.centre().x()+","+r.centre().y()+" L="+r.largeur()+" h="+r.hauteur(), r.description(1));
    }

    @Test
    public void testDupliquer() {
        Rectangle r2=(Rectangle) r.dupliquer();
        assertEquals(r, r2);
    }

    @Test
    public void testEnSVG() {


    }

    @Test
    public void testHauteur() {
        assertEquals(8, r.hauteur(),0.0001);
    }

    @Test
    public void testLargeur() {
        assertEquals(5, r.largeur(),0.0001);
    }

    @Test
    public void testRedimmensioner() {

    }

    @Test
    public void testSetHauteur() {
        r.setHauteur(3);
        assertEquals(3,r.hauteur(),0.0001);
    }

    @Test
    public void testSetLargeur() {
        r.setLargeur(3);
        assertEquals(3,r.largeur(),0.0001);
    }
}