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
    public void testRedimmensioner() {
        IForme formeRedimensionnee = e.redimmensioner(e.largeur(),e.hauteur());
        assertEquals(e.largeur() * e.hauteur(), formeRedimensionnee.hauteur() * formeRedimensionnee.largeur(), 0.001);
    }
    
    @Test
    public void testDeplacer() {
        IForme formeDeplacee = e.deplacer(5, 10);
        assertEquals(5, formeDeplacee.centre().x(), 0.001);
        assertEquals(10, formeDeplacee.centre().y(), 0.001);
    }

}
