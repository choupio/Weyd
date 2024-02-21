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
        String descriptionAttendue = "Ellipse avec centre en " + e.centre() + ", hauteur 128.0, largeur 64.0. C'est une ellipse standard.";
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
    public void testAligner() {
        e.aligner(Alignement.HAUT, 10.0); // Alignement du HAUT à l'axe y=10.0
        assertEquals("Ellipse alignée en haut à l'axe y=10.0", e.description());
    }

    @Test
    public void testTourner() {
        e.tourner(90); // Rotation de 90 degrés
        assertEquals("Ellipse tourne de 90 degrés", e.description());
    }
}