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
    public void testAgencerVertical() {
        // Créer un groupe de formes
        Faisceau faisceau = new Faisceau("Faisceau", 10, 20, 30);
        // Ajouter des formes au groupe
        faisceau.ajouter(new Rectangle(10.0, 25.0, 18.0, 120.0));
        // Appeler la méthode agencer avec orientation verticale
        faisceau.agencer(25.0, 10.0, 20.0, 30.0, true);
        // Vérifier que les éléments ont été alignés correctement
        assertEquals(25.0, faisceau.centre().x(), 0.0001);
        assertEquals(10.0, faisceau.centre().y(), 0.0001);
    }

    @Test
    public void testAgencerHorizontal() {
        // Créer un groupe de formes
        Faisceau faisceau = new Faisceau("Faisceau", 10, 20, 30);
        // Ajouter des formes au groupe
        faisceau.ajouter(new Rectangle(10.0, 25.0, 18.0, 120.0));
        // Appeler la méthode agencer avec orientation horizontale
        faisceau.agencer(25.0, 10.0, 20.0, 30.0, false);
        // Vérifier que les éléments ont été alignés correctement
        assertEquals(25.0, faisceau.centre().x(), 0.0001);
        assertEquals(10.0, faisceau.centre().y(), 0.0001);
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

