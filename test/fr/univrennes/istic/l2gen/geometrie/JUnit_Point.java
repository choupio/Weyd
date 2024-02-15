package test.fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import fr.univrennes.istic.l2gen.geometrie.Point;

public class JUnit_Point {
    Point p;
    @Before
    public void setUp(){
        p=new Point(5, 6);
    }
    
    @Test
    public void testX(){
        assertEquals(5,p.x(),0.0001);
    }
    
    @Test
    public void testY(){
        assertEquals(6,p.y(),0.0001);
    }
    @Test
    public void testSetX(){
        p.setX(9);
        assertEquals(9,p.x(),0.0001);
    }
    @Test
    public void testSetY(){
        p.setY(10);
        assertEquals(10,p.y(),0.0001);
    }
    @Test
    public void testEquals(){
        
    }

}
