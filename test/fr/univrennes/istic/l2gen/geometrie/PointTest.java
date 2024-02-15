package test.fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.Point;

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
        Point p4=new Point(p.x()+4, p.y()+3);
        assertEquals(true, p3.equals(p4));

    }

    @Test
    public void testPlus2() {
        Point p2=p.plus(4,3);
        Point p3=new Point(p.x()+4, p.y()+3);
        assertEquals(true, p2.equals(p3));


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
