package fr.univrennes.istic.l2gen.geometrie.visustats;

import java.util.List;
import org.junit.Test;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class FaisceauTest {

    @Test
    public void testCreationFaisceau() {
        Faisceau faisceau = new Faisceau("MonFaisceau", 10, 20, 30);
        assertEquals("MonFaisceau", faisceau.getNom());
        assertEquals(3, faisceau.getBarres().size());
    }

    @Test
    public void testAgencementVertical() {
        Faisceau faisceau = new Faisceau("VerticalFaisceau", 10, 20, 30);
        faisceau.agencer(0, 0, 1, 1, true);
        assertEquals(10.0, faisceau.getBarres().get(0).centre().y(), 0.001);
        assertEquals(35.0, faisceau.getBarres().get(1).centre().y(), 0.001);
        assertEquals(70.0, faisceau.getBarres().get(2).centre().y(), 0.001);
    }

    @Test
    public void testAgencementHorizontal() {
        Faisceau faisceau = new Faisceau("HorizontalFaisceau", 10, 20, 30);
        faisceau.agencer(0, 0, 1, 1, false);
        faisceau.agencer(0, 0, 10, 5, false);
        // Vérifiez si la liste de rectangles contient le bon nombre de rectangles
        assertEquals(1, faisceau.getBarres().size());
        assertEquals(10.0, faisceau.getBarres().get(0).centre().x(), 0.001);
        assertEquals(15.0, faisceau.getBarres().get(1).centre().x(), 0.001);
        assertEquals(25.0, faisceau.getBarres().get(2).centre().x(), 0.001);
    }

    @Test
    public void testAgencementAvecTaillesDifferents() {
        Faisceau faisceau = new Faisceau("FaisceauTaillesDifferentes", 10, 20, 30);
        faisceau.agencer(0, 0, 2, 2, true);
        assertEquals(10.0, faisceau.getBarres().get(0).centre().y(), 0.001);
        assertEquals(35.0, faisceau.getBarres().get(1).centre().y(), 0.001);
        assertEquals(80.0, faisceau.getBarres().get(2).centre().y(), 0.001);
    }


    @Test
    public void testColorier() {
        Faisceau faisceau = new Faisceau("ColorFaisceau", 10, 20, 30);
        faisceau.colorier("red", "green", "blue");
        List<Rectangle> barres = faisceau.getBarres();
        assertEquals("red", barres.get(0).getCouleur());
        assertEquals("green", barres.get(1).getCouleur());
        assertEquals("blue", barres.get(2).getCouleur());
    }

    @Test
    public void testDupliquer() {
        Faisceau original = new Faisceau("OriginalFaisceau", 10, 20, 30);
        Faisceau copie = (Faisceau) original.dupliquer();

        assertEquals(original.getNom(), copie.getNom());
        assertEquals(original.getBarres().size(), copie.getBarres().size());

        // Assurez-vous que les rectangles ne sont pas les mêmes objets dans la mémoire
        assertNotSame(original.getBarres().get(0), copie.getBarres().get(0));
    }
}

