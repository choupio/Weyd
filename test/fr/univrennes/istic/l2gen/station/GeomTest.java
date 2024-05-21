package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class GeomTest {
    Geom geom;

    @Before
    public void SetUp() {
        geom = new Geom();
        geom.setLat(48.117266);
        geom.setLon(-1.677792);
    }

    @Test
    public void testGetLat() {
        SetUp();
        assertEquals(48.117266, geom.getLat(), 0.0001);
    }

    @Test
    public void testGetLon() {
        SetUp();
        assertEquals(-1.677792, geom.getLon(), 0.0001);
    }

    @Test
    public void testToString() {
        SetUp();
        assertEquals("Geometrie{lon=-1.677792, lat=48.117266}", geom.toString());
    }
}
