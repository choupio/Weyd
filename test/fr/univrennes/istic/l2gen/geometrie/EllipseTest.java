package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class EllipseTest {

    Ellipse e;

    @Before
    public void setUp() {
        e = new Ellipse(256, 256, 128, 64);
    }

    @Test
    public void testCentre() {
        Point centre = e.centre();
        assertNotNull(centre);
        assertEquals(256, centre.x(), 0.001);
        assertEquals(256, centre.y(), 0.001);
    }

    @Test
    public void testColorier() {
        e.colorier("red");
        assertEquals("red", e.couleur);
    }

    @Test
    public void testDescription() {
        String descriptionAttendue = "EllipseCentre=" + e.centre().x() + "," + e.centre().y()
                + " L=64.0 H=128.0 de couleur white angle=0";
        assertEquals(descriptionAttendue, e.description(0));
    }

    @Test
    public void testHauteur() {
        assertEquals(128, e.hauteur(), 0.001);
    }

    @Test
    public void testLargeur() {
        assertEquals(64, e.largeur(), 0.001);
    }

    @Test
    public void testDeplacer() {
        IForme formeDeplacee = e.deplacer(5, 10);
        assertEquals(261, formeDeplacee.centre().x(), 0.001);
        assertEquals(266, formeDeplacee.centre().y(), 0.001);
    }

    @Test
    public void testRedimmensioner() {
        double largeur = 2.0;
        double hauteur = 4.0;
        IForme formeRedimensionnee = e.redimmensioner(largeur, hauteur);
        assertEquals(32 * largeur, formeRedimensionnee.largeur(), 0.001);
        assertEquals(32 * hauteur, formeRedimensionnee.hauteur(), 0.001);
    }

    @Test
    public void testAlignerHaut() {
        Ellipse e = new Ellipse(0, 0, 10, 20);
        e.aligner(Alignement.HAUT, 15.0);
        Point centreApresAlignement = e.centre();
        Point centreAttendu = new Point(0, 15.0 + 10.0 / 2);
        assertEquals(centreAttendu, centreApresAlignement);
    }

    @Test
    public void testAlignerBas() {
        Ellipse e = new Ellipse(0, 0, 10, 20);
        e.aligner(Alignement.BAS, 15.0);
        Point centreApresAlignement = e.centre();
        Point centreAttendu = new Point(0, 15.0 - 10.0 / 2);
        assertEquals(centreAttendu, centreApresAlignement);
    }

    @Test
    public void testAlignerGauche() {
        Ellipse e = new Ellipse(0, 0, 10, 20);
        e.aligner(Alignement.GAUCHE, 15.0);
        Point centreApresAlignement = e.centre();
        Point centreAttendu = new Point(5.0, 0);
        assertEquals(centreAttendu, centreApresAlignement);
    }

    @Test
    public void testAlignerDroite() {
        Ellipse e = new Ellipse(0, 0, 10, 20);
        e.aligner(Alignement.DROITE, 15.0);
        Point centreApresAlignement = e.centre();
        Point centreAttendu = new Point(5.0, 0);
        assertEquals(centreAttendu, centreApresAlignement);
    }

    @Test
    public void testTourner() {
        IForme formeTourner = e.tourner(90);
        int angleApresRotation = ((Ellipse) formeTourner).getAngle();
        assertEquals(90, angleApresRotation);
    }
}