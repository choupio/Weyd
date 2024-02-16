package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PointTest {
    Point p;
    @Before
    public void setUp(){
        p=new Point(5, 6);
    }

    @Test
    public void testEquals() {
        Point p2=new Point(5,6);
        assertEquals(true, p.equals(p2));
    }

    @Test
    public void testPlus() {
        Point p2=new Point(4,3);
        Point p3=p.plus(p2);
        assertEquals(9, p3.x(),0.0001);
        assertEquals(9, p3.y(),0.0001);

    }

    @Test
    public void testPlus2() {
        setUp();
        Point p2=p.plus(4,3);
        assertEquals(9, p2.x(),0.0001);
        assertEquals(9, p2.x(),0.0001);
    }

    @Test
    public void testSetX() {
        p.setX(9);
        assertEquals(9,p.x(),0.0001);
    }

    @Test
    public void testSetY() {
        p.setY(10);
        assertEquals(10,p.y(),0.0001);
    }

    @Test
    public void testX() {
        assertEquals(5,p.x(),0.0001);
    }

    @Test
    public void testY() {
        assertEquals(6,p.y(),0.0001);
    }
}
