package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a text shape that implements the {@link IForme} interface.
 */
public class Texte implements IForme {
	private String couleur, texte;
	private double x;
	private double y;
	private double hauteur;
	private double largeur;
	private int taille;
	private int angle;

	

	// Bloc d'initialisation
	{
		couleur = "black";
		hauteur = 20.0;
		largeur = 0.0;
	}

	 /**
     * Rotates the shape by the specified angle.
     * 
     * @param agle the angle (in degrees) by which the shape should be rotated
     * @return the rotated shape
     */
    @Override
	public IForme tourner(int angle) {
		this.angle = angle;
		return this;
	}

	/**
	 * Aligns the shape based on the specified alignment and target position.
	 * 
	 * @param alignement the alignment to apply
	 * @param cible the target position
	 * @return the aligned shape
	 */
	@Override
	public IForme aligner(Alignement alignement, double cible) {
		switch (alignement) {
		case HAUT:
			y = cible + hauteur / 2;
			break;
		case BAS:
			y = cible - hauteur / 2;
			break;
		case DROITE:
			x = cible + largeur / 2;
			break;
		case GAUCHE:
			x = cible - largeur / 2;
			break;
		}
		return this;
	}

	/**
	 * @param x
	 * @param y
	 * @param taille
	 * @param texte
	 */
	public Texte(double x, double y, int taille, String texte) {
		this.x = x;
		this.y = y;
		this.taille = taille;
		this.texte = texte;
	}

	public Texte() {
		this(0, 0, 0, "");
	}

	@Override
	public Point centre() {
		return new Point(x, y);
	}

	@Override
	public double hauteur() {
		return hauteur;
	}

	@Override
	public double largeur() {
		return largeur;
	}

	@Override
	public IForme deplacer(double dx, double dy) {
		// Logique pour déplacer le texte
		x += dx;
		y += dy;
		return this; // Retourne la référence à la forme modifiée
	}

	@Override
	public IForme dupliquer() {
		// Crée une nouvelle instance de la classe avec les mêmes propriétés
		Texte nouvelleForme = new Texte();
		nouvelleForme.couleur = this.couleur;
		nouvelleForme.x = this.x;
		nouvelleForme.y = this.y;
		nouvelleForme.hauteur = this.hauteur;
		nouvelleForme.largeur = this.largeur;
		nouvelleForme.taille = this.taille;
		nouvelleForme.texte = this.texte;
		return nouvelleForme;
	}// Crée une nouvelle instance de la classe avec les mêmes propriétés

	@Override
	public String description(int indentation) {
		// Génère une description avec un certain niveau d'indentation
		String sb = "";
		for (int i = 0; i < indentation; i++) {
			sb += "  ";
		}
		sb += "Texte centre=" + x + "," + y + " taille=" + taille + " texte=" + texte + " couleur=" + couleur + " et de rotation " + angle;
		return sb.toString();
	}

	@Override
	public String enSVG() {
		// Génère la représentation SVG du texte avec les dimensions mises à jour
		return "<text x=\"" + x + "\" y=\"" + y + "\" font-size=\"" + taille + "\" text-anchor=\"middle\" fill=\""
				+ couleur + "\" stroke=\"black\" transform=\"rotate(" + angle + ")\">" + texte + "</text>";
	}

	public IForme colorier(String... couleurs) {
		couleur = couleurs[0];
		return this;
	}

	@Override
	public IForme redimmensioner(double h, double l) {
		hauteur = h;
		largeur = l;
		return this;
	}

	@Override
	public void createSvgFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.svg"))) {
			writer.write("<svg width=\"" + largeur + "\" height=\"" + hauteur + "\">\n");
			writer.write(enSVG() + "\n");
			writer.write("</svg>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
