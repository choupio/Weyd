package fr.univrennes.istic.l2gen.visustats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.Point;

public class DiagColonnesTest {

    DiagColonnes diagColonnes;

    @Before
    public void setUp() {
        diagColonnes = new DiagColonnes("Test");
        diagColonnes.legender("Legende 1", "Legende 2");
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
    }

    @Test
    public void testAgencer() {
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        IDataVisualiseur result = diagColonnes.agencer();
        assertNotNull(result);
    }

    @Test
    public void testAjouterDonnees() {
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        IDataVisualiseur result = diagColonnes.agencer();
        assertNotNull(result);
    }

    @Test
    public void testAligner() {
    }

    @Test
    public void testCentre() {
        Point valeur1 = diagColonnes.centre();
        assertEquals(valeur1, null);
    }

    @Test
    public void testColorier() {
    }

    @Test
    public void testCreateSvgFile() {
    }

    @Test
    public void testDeplacer() {
        diagColonnes.deplacer(5, 5);
        assertEquals(null, diagColonnes.centre());
    }

    @Test
    public void testDescription() {
    }

    @Test
    public void testDupliquer() {
        DiagColonnes diagC2 = (DiagColonnes) diagColonnes.dupliquer();
        assertEquals(diagC2.centre(), diagColonnes.centre());
        assertEquals(diagC2.hauteur(), diagColonnes.hauteur(), 0.0001);
        assertEquals(diagC2.largeur(), diagColonnes.largeur(), 0.0001);
        assertEquals(diagC2.nom, diagColonnes.nom);
        assertEquals(diagC2.couleurs, diagColonnes.couleurs);
        assertEquals(diagC2.legendes, diagColonnes.legendes);
        assertEquals(diagC2.legendeGroupe, diagColonnes.legendeGroupe);
        assertEquals(diagC2.donnees, diagColonnes.donnees);
        assertEquals(diagC2.diagGroupe, diagColonnes.diagGroupe);
    }

    @Test
    public void testEnSVG() {
    }

    @Test
    public void testHauteur() {
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        double hauteur = diagColonnes.hauteur();
        assertNotNull(hauteur);
    }

    @Test
    public void testLargeur() {
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        double largeur = diagColonnes.largeur();
        assertNotNull(largeur);
    }

    @Test
    public void testLegender() {
        assertNotNull(diagColonnes.legendes);
    }

    @Test
    public void testRedimmensioner() { 
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        diagColonnes.redimmensioner(100, 100);
        assertEquals(0.0, diagColonnes.hauteur(), 0.0001);
        assertEquals(0.0, diagColonnes.largeur(), 0.0001);
    }

    @Test
    public void testSetOption() {
    }

    @Test
    public void testTourner() {
        diagColonnes.ajouterDonnees("Data 1", 10.0, 20.0, 30.0);
        diagColonnes.ajouterDonnees("Data 2", 15.0, 25.0, 35.0);
        diagColonnes.tourner(90);
        assertNotNull(diagColonnes);
    }
}
