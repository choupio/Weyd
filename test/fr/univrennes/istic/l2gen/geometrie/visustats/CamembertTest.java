package fr.univrennes.istic.l2gen.geometrie.visustats;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Secteur;

import org.junit.Test;
import static org.junit.Assert.*;

public class CamembertTest {

    @Test
    public void testAjouterSecteur() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.ajouterSecteur("Secteur 3", 0.25);
        assertEquals(3, camembert.getSecteurs().size());
    }

    @Test
    public void testDescription() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.ajouterSecteur("Secteur 3", 0.25);

        String expectedDescription = "Camembert:\n" +
                "  Centre: (0.0, 0.0)\n" +
                "  Rayon: 10.0\n" +
                "  Secteurs:\n" +
                "    Secteur: Secteur 1, Proportion: 0.25\n" +
                "    Secteur: Secteur 2, Proportion: 0.5\n" +
                "    Secteur: Secteur 3, Proportion: 0.25\n";
        assertEquals(expectedDescription, camembert.description(0));
    }

    @Test
public void testHauteur() {
    Camembert camembert = new Camembert(new Point(0, 0), 10);
    double expectedHauteur = 20.0;
    double delta = 0.0001; // Choisissez une valeur appropriée pour la marge d'erreur

    assertEquals(expectedHauteur, camembert.hauteur(), delta);
}


    @Test
    public void testLargeur() {
    Camembert camembert = new Camembert(new Point(0, 0), 10);
    double expectedLargeur = 20.0;
    double delta = 0.0001; // Choisissez une valeur appropriée pour la marge d'erreur
    assertEquals(expectedLargeur, camembert.largeur(), delta);
}

    @Test
    public void testDeplacer() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.deplacer(5, 5);
        assertEquals(new Point(5, 5), camembert.centre());
    }

    @Test
public void testColorier() {
    Camembert camembert = new Camembert(new Point(0, 0), 10);
    camembert.ajouterSecteur("Secteur 1", 0.25);
    camembert.ajouterSecteur("Secteur 2", 0.5);
    // Avant l'appel de la méthode colorier
    for (Secteur secteur : camembert.getSecteurs()) {
        System.out.println("Avant colorier : " + secteur.getCouleur());
    }
    camembert.colorier("Red", "Blue");
    // Après l'appel de la méthode colorier
    for (Secteur secteur : camembert.getSecteurs()) {
        System.out.println("Après colorier : " + secteur.getCouleur());
    }
    // Vérifiez que tous les secteurs ont été coloriés correctement
    for (int i = 0; i < camembert.getNombreSecteurs(); i++) {
        assertEquals("Red", camembert.getCouleurSecteur(i));
    }
}

    @Test
    public void testTourner() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);

        camembert.tourner(45);

        assertEquals(45, camembert.getSecteurs().get(0).getRotation());
    }

    @Test
    public void testAligner() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);

        camembert.aligner(Alignement.HAUT, 20);

        assertEquals(new Point(0, 30), camembert.centre());
    }
}
