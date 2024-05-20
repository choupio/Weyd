package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarburantTest {

    Carburant c1;

    @Before
    public void setUp() {
        c1 = new Carburant("Gazole", 1.5);
    }

    @Test
    public void testGetNom() {
        setUp();
        assertEquals("Gazole", c1.getNom());
    }

    @Test
    public void testGetPrix() {
        setUp();
        assertEquals(1.5, c1.getPrix(), 0.0001);
    }
}
