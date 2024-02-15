package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.Polygone;

public class PolygoneTest {
    @Before
    public void setUp() {
        Polygone polygone = new Polygone(null);
    }

    @Test
    public void testAjouterSommet() {
        assertArrayEquals(Collections.emptyList(), polygone.getPoint());
    }

    @Test
    public void testAjouterSommet2() {

    }

    @Test
    public void testCentre() {

    }

    @Test
    public void testColorier() {

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
    public void testGetSommets() {

    }

    @Test
    public void testHauteur() {

    }

    @Test
    public void testLargeur() {

    }

    @Test
    public void testRedimmensioner() {

    }
}
