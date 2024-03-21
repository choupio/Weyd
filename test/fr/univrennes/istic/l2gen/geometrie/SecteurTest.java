package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SecteurTest {
    Secteur s;

    @Before
    public void setUp() {
        s = new Secteur(256, 256, 128, 0, 60);
    }

    @Test
    public void testCentre() {
        assertEquals(256, s.centre().x(), 0.001);
        assertEquals(256, s.centre().y(), 0.001);
    }

    @Test
    public void testColorier() {
        s.colorier("red");
        assertEquals("red", s.getCouleur());
    }

    @Test
    public void testDeplacer() {
        IForme secteurDeplace = s.deplacer(5, 10);
        assertEquals(261, secteurDeplace.centre().x(), 0.001);
        assertEquals(266, secteurDeplace.centre().y(), 0.001);
    }

    @Test
    public void testDescription() {
        String descriptionAttendue = "Secteur centre=256.0,256.0 Angle=0.0 Arc=60.0 de couleur white et de rotation 0.0";
        assertEquals(descriptionAttendue, s.description(0));
    }

    @Test
    public void testDupliquer() {
        IForme secteurDuplique = s.dupliquer();
        assertEquals(s.getPoint().x(), ((Secteur) secteurDuplique).getPoint().x(), 0.001);
        assertEquals(s.getPoint().y(), ((Secteur) secteurDuplique).getPoint().y(), 0.001);
        assertEquals(s.getRayon(), ((Secteur) secteurDuplique).getRayon(), 0.001);
        assertEquals(90.0, ((Secteur) secteurDuplique).getAngle(), 0.001);
        assertEquals(s.getArc(), ((Secteur) secteurDuplique).getArc(), 0.001);
    }

    @Test
    public void testDupliquer2() {
        assertEquals(false, s.equals(s.dupliquer()));
    }

    @Test
    public void testEnSVG() {
        String svgAttendu = "<path d=\"M 384.0 256.0 A 128.0 128.0 0 0 0 320.0 145.14874831559186 L 256.0 256.0 Z\"\n" +
                "\t" + "fill=\"white\"" + " stroke=\"black\" transform=\"rotate(0.0)\"/>";
        assertEquals(svgAttendu, s.enSVG());
    }

    @Test
    public void testGetAngle() {
        assertEquals(0.0, s.getAngle(), 0.001);
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
        assertEquals(128.0, s.hauteur(), 0.001);
    }

    @Test
    public void testLargeur() {
        assertEquals(127.99999999999999, s.largeur(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class) // dans le cas où les valeurs valent 0.
    public void testRedimmensioner0() {
        s.redimmensioner(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRedimmensionerNeg() {
        s.redimmensioner(-2, -3);
    }

    @Test
    public void testRedimmensioner2() {
        Secteur s2 = new Secteur(s.centre(), 128, 0, 60);
        assertEquals(false, s2.equals(s.redimmensioner(1, 8)));
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

    @Test
    public void testalignergauche() {
        IForme secteurAligne = s.aligner(Alignement.GAUCHE, 0.0);
        assertEquals(-128, secteurAligne.centre().x(), 0.001);
        assertEquals(256, secteurAligne.centre().y(), 0.001);
    }

    @Test
    public void testalignerhaut() {
        IForme secteurAligne = s.aligner(Alignement.HAUT, 3.0);
        assertEquals(256, secteurAligne.centre().x(), 0.001);
        assertEquals(131, secteurAligne.centre().y(), 0.001);
    }

    @Test
    public void testalignerdroite() {
        IForme secteurAligne = s.aligner(Alignement.DROITE, 5.8);
        assertEquals(133.8, secteurAligne.centre().x(), 0.001);
        assertEquals(256, secteurAligne.centre().y(), 0.001);
    }

    @Test
    public void testalignerbas() {
        IForme secteurAligne = s.aligner(Alignement.BAS, 17.2);
        assertEquals(256, secteurAligne.centre().x(), 0.001);
        assertEquals(-110.8, secteurAligne.centre().y(), 0.001);
    }

    @Test
    public void testaligner2() {
        assertEquals(true, s.equals(s.aligner(Alignement.BAS, 17.2)));
    }

    @Test
    public void testtourner() {
        IForme secteurTourne = s.tourner(50);
        assertEquals(256, secteurTourne.centre().x(), 0.001);
        assertEquals(256, secteurTourne.centre().y(), 0.001);
    }

    @Test
    public void testtourner2() {
        assertEquals(true, s.equals(s.tourner(40)));
    }
}
