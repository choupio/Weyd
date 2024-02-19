package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SecteurTest {
    Secteur s;
    @Before
    public void setUp(){
        s = new Secteur(256 , 256 , 128 , 0 , 60);
    }


    @Test
    public void testCentre() {
        assertEquals(256, s.centre().x(), 0.001);
        assertEquals(256, s.centre().y(), 0.001);
    }

    @Test
    public void testColorier() {
        s.colorier("red");
        assertEquals("red", s);
    }

    @Test
    public void testDeplacer() {
        IForme secteurDeplace = s.deplacer(5, 10);
        assertEquals(261, secteurDeplace.centre().x(), 0.001);
        assertEquals(266, secteurDeplace.centre().y(), 0.001);
    }
    

    @Test
    public void testDescription() {
        String descriptionAttendue = "Secteurcentre=256.0,256.0 Angle=30.0 Arc=60.0 de couleur white";
        assertEquals(descriptionAttendue, s.description(0));
    }

    @Test
    public void testDupliquer() {
        IForme secteurDuplique = s.dupliquer();
        assertEquals(s.getPoint().x(), ((Secteur) secteurDuplique).getPoint().x(), 0.001);
        assertEquals(s.getPoint().y(), ((Secteur) secteurDuplique).getPoint().y(), 0.001);
        assertEquals(s.getRayon(), ((Secteur) secteurDuplique).getRayon(), 0.001);
        assertEquals(60, ((Secteur) secteurDuplique).getAngle(), 0.001);
        assertEquals(s.getArc(), ((Secteur) secteurDuplique).getArc(), 0.001);
    }

    @Test
    public void testDupliquer2() {
        assertEquals(false, s.equals(s.dupliquer()));
    }

    @Test
    public void testEnSVG() {
        String svgAttendu = "<path d=\"M 366.85125168440817 192.0 A 128.0 128.0 0 0 0 256.0 128.0 L 256.0 256.0 Z\"\n" +
        "\t" + "fill=\"white\"" + " stroke=\"black\"/>";
        assertEquals(svgAttendu, s.enSVG());
    }

    @Test
    public void testGetAngle() {
        assertEquals(30, s.getAngle(), 0.001);
    }

    @Test
    public void testGetArc() {
        assertEquals(60, s.getArc(), 0.001);
    }

    @Test
    public void testGetPoint() {
        assertEquals(new Point(256, 256), s.getPoint());
    }

    @Test
    public void testGetRayon() {
        assertEquals(128, s.getRayon(), 0.001);
    }

    @Test
    public void testHauteur() {
        assertEquals(0, s.hauteur(), 0.001);
    }

    @Test
    public void testLargeur() {
        assertEquals(0, s.largeur(), 0.001);
    }

    @Test
    public void testRedimmensioner() {
        IForme secteurRedimensionne = s.redimmensioner(0, 0);
        assertEquals(0*0, secteurRedimensionne.hauteur() * secteurRedimensionne.largeur(), 0.001);
    }

    @Test 
    public void testRedimmensioner2(){
        Secteur s2 = new Secteur(s.centre(), 128, 0, 60);
        assertEquals(false,s2.equals(s.redimmensioner(0, 8)));
    }

    @Test
    public void testSetAngle() {
        s.setAngle(60);
        assertEquals(60, s.getAngle(), 0.001);
    }

    @Test
    public void testSetArc() {
        s.setArc(120);
        assertEquals(120, s.getArc(), 0.001);
    }
}
