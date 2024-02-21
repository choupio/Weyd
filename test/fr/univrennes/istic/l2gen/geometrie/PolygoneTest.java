package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PolygoneTest {
	private Polygone polygone, polygone2;

	@Before
	public void setUp() {
		polygone = new Polygone();

		polygone2 = new Polygone();
		polygone2.ajouterSommet(128, 128);
		polygone2.ajouterSommet(128, 256);
		polygone2.ajouterSommet(256, 128);
		polygone2.ajouterSommet(256, 256);
	}

	@Test
	public void testAjouterSommet() {
		assertEquals(Collections.emptyList(), polygone.getSommets());
		double d1, d2;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			d1 = random.nextInt(200);
			d2 = random.nextInt(200);
			polygone.ajouterSommet(d1, d2);
			assertEquals(i + 1, polygone.getSommets().size());
			assertTrue(polygone.getSommets().get(i).equals(new Point(d1, d2)));
		}
	}

	@Test
	public void testAjouterSommet2() {
		assertEquals(Collections.emptyList(), polygone.getSommets());
		double d1, d2;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			d1 = random.nextInt(200);
			d2 = random.nextInt(200);
			polygone.ajouterSommet(new Point(d1, d2));
			assertEquals(i + 1, polygone.getSommets().size());
			assertTrue(polygone.getSommets().get(i).equals(new Point(d1, d2)));
		}
	}

	@Test
	public void testCentre() {
		assertTrue(polygone2.centre().equals(new Point(192, 192)));
	}

	@Test
	public void testDeplacer() {
		Polygone polygoneTest = new Polygone(138, 138, 138, 266, 266, 138, 266, 266);
		polygone2.deplacer(10, 10);

		for (int i = 0; i < polygoneTest.getSommets().size(); i++) {
			assertTrue(polygoneTest.getSommets().get(i).equals(polygone2.getSommets().get(i)));
		}
	}

	@Test
	public void testDescription() {
		assertEquals("  Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white",
				polygone2.description(1));
	}

	@Test
	public void testDupliquer() {
		Polygone polygoneTest = (Polygone) polygone2.dupliquer();
		for (int i = 0; i < polygoneTest.getSommets().size(); i++) {
			assertTrue(polygoneTest.getSommets().get(i).equals(polygone2.getSommets().get(i)));
		}
	}

	@Test
	public void testEnSVG() {
		assertEquals(
				"<polygon points=\"128.0 128.0 128.0 256.0 256.0 128.0 256.0 256.0\" fill=\"white\" stroke=\"black\"/>",
				polygone2.enSVG());
	}

	@Test
	public void testGetSommets() {
		assertEquals(Collections.emptyList(), polygone.getSommets());
		double d1, d2;
		Random random = new Random();
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			d1 = random.nextInt(200);
			d2 = random.nextInt(200);
			points.add(new Point(d1, d2));
			polygone.ajouterSommet(new Point(d1, d2));
		}

		for (int i = 0; i < points.size(); i++) {
			assertTrue(points.get(i).equals(polygone.getSommets().get(i)));
		}
	}

	@Test
	public void testHauteur() {
		polygone.ajouterSommet(0, 0);
		polygone.ajouterSommet(0, 56);
		assertEquals(56.0, polygone.hauteur(), 0.00001);
	}

	@Test
	public void testHauteur2() {
		polygone.ajouterSommet(10, 32);
		polygone.ajouterSommet(12, 56);
		assertEquals(24, polygone.hauteur(), 0.00001);
	}

	@Test
	public void testLargeur() {
		polygone.ajouterSommet(0, 0);
		polygone.ajouterSommet(0, 56);
		assertEquals(0, polygone.largeur(), 0.00001);
	}

	@Test
	public void testLargeur2() {
		polygone.ajouterSommet(10, 32);
		polygone.ajouterSommet(12, 56);
		assertEquals(2, polygone.largeur(), 0.00001);
	}

	@Test
	public void testRedimmensioner() {
		Polygone polygoneRef = new Polygone(160, 160, 160, 224, 224, 160, 224, 224);

		Point centreDebut = polygone2.centre();
		polygone2.redimmensioner(0.5, 0.5);
		assertTrue(centreDebut.equals(polygone2.centre()));
		for (int i = 0; i < polygoneRef.getSommets().size(); i++) {
			assertEquals(polygoneRef.getSommets().get(i).x(), polygone2.getSommets().get(i).x(), 0.00001);
			assertEquals(polygoneRef.getSommets().get(i).y(), polygone2.getSommets().get(i).y(), 0.00001);
		}

	}

	@Test
	public void testRedimmensioner2() {
		Polygone polygoneRef = new Polygone(184, 184, 184, 200, 200, 184, 200, 200);

		Point centreDebut = polygone2.centre();
		polygone2.redimmensioner(0.5, 0.5);
		polygone2.redimmensioner(0.25, 0.25);
		assertTrue(centreDebut.equals(polygone2.centre()));
		for (int i = 0; i < polygoneRef.getSommets().size(); i++) {
			assertEquals(polygoneRef.getSommets().get(i).x(), polygone2.getSommets().get(i).x(), 0.00001);
			assertEquals(polygoneRef.getSommets().get(i).y(), polygone2.getSommets().get(i).y(), 0.00001);
		}
	}

	@Test
	public void testTourner() { // en modifiant l'angle
		polygone2.tourner(38);
		assertEquals("  Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white angle=38",
				polygone2.description(1));
	}

	@Test
	public void testAligner() { // test HAUT
		polygone2.aligner(Alignement.HAUT, 100);
		Polygone polygoneTest = new Polygone(128, 100, 128, 228, 256, 100, 256, 228);
		for (int i = 0; i < polygone2.getSommets().size(); i++) {
			assertTrue(polygone2.getSommets().get(i).equals(polygoneTest.getSommets().get(i)));
		}
	}

	@Test
	public void testAligner2() { // test BAS
		polygone2.aligner(Alignement.BAS, 200);
		Polygone polygoneTest = new Polygone(128, 72, 128, 200, 256, 72, 256, 200);
		for (int i = 0; i < polygone2.getSommets().size(); i++) {
			assertTrue(polygone2.getSommets().get(i).equals(polygoneTest.getSommets().get(i)));
		}
	}

	@Test
	public void testAligner3() { // test GAUCHE
		polygone2.aligner(Alignement.GAUCHE, 100);
		Polygone polygoneTest = new Polygone(100, 128, 100, 256, 228, 128, 228, 256);
		for (int i = 0; i < polygone2.getSommets().size(); i++) {
			assertTrue(polygone2.getSommets().get(i).equals(polygoneTest.getSommets().get(i)));
		}
	}

	@Test
	public void testAligner4() { // test DROITE
		polygone2.aligner(Alignement.DROITE, 200);
		Polygone polygoneTest = new Polygone(72, 128, 72, 256, 200, 128, 200, 256);
		for (int i = 0; i < polygone2.getSommets().size(); i++) {
			assertTrue(polygone2.getSommets().get(i).equals(polygoneTest.getSommets().get(i)));
		}
	}
}
