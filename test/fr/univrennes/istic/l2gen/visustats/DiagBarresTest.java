package fr.univrennes.istic.l2gen.visustats;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class DiagBarresTest {

    DiagBarres diagBarres;

    @Before
    public void setUp() {
        diagBarres = new DiagBarres("Test");
    }

    @Test
    public void testAgencer() {
    }

    @Test
    public void testAjouterDonnees() {
        diagBarres.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagBarres.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        assertNotNull(diagBarres.donnees);
    }

    @Test
    public void testAligner() {
    }

    @Test
    public void testCentre() {

    }

    @Test
    public void testColorier() {
        diagBarres.colorier("red", "blue", "green");
        assertNotNull(diagBarres.couleurs);
    }

    @Test
    public void testCreateSvgFile() {
    }

    @Test
    public void testDeplacer() {
    }

    @Test
    public void testDescription() {
    }

    @Test
    public void testDupliquer() {

    }

    @Test
    public void testEnSVG() {

    }

    @Test
    public void testHauteur() {

    }

    @Test
    public void testLargeur() {
    }

    @Test
    public void testLegender() {
    }

    @Test
    public void testRedimmensioner() {

    }

    @Test
    public void testSetOption() {

    }

    @Test
    public void testTourner() {

    }
}
