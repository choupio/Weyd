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
	/**
     * Retourne le centre du rectangle.
     *
     * @return Le centre du rectangle.
     */
	@Override
	public Point centre() {
		return new Point(x, y);
	}
	/**
     * Retourne la hauteur du rectangle.
     *
     * @return La hauteur du rectangle.
     */
	@Override
	public double hauteur() {
		return hauteur;
	}
	/**
     * Retourne la largeur du rectangle.
     *
     * @return La largeur du rectangle.
     */
	@Override
	public double largeur() {
		return largeur;
	}
	/**
     * Déplace le centre du rectangle selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @throws IllegalArgumentException si x ou y devient négatif
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
	@Override
	public IForme deplacer(double dx, double dy) {
		// Logique pour déplacer le texte
		x += dx;
		y += dy;
		return this; // Retourne la référence à la forme modifiée
	}
	/**
     * Duplique le rectangle.
     *
     * @return Une nouvelle instance du rectangle avec les mêmes propriétés.
     */
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
	
	/**
     * Retourne une description du rectangle avec une indentation spécifiée.
     *
     * @param indentation Le niveau d'indentation pour la description.
     * @throws IllegalArgumentException si l'indentation est inférieure à 0.
     * @return Une chaîne de caractères décrivant le rectangle.
     */
	@Override
	public String description(int indentation) {
		if(indentation<0){
            throw new IllegalArgumentException("L'indentation ne doit pas être inférieure à 0.");
        }
		else{// Génère une description avec un certain niveau d'indentation
			String sb = "";
			for (int i = 0; i < indentation; i++) {
				sb += "  ";
			}
			sb += "Texte centre=" + x + "," + y + " taille=" + taille + " texte=" + texte + " couleur=" + couleur + " et de rotation " + angle;
			return sb.toString();
		}
	}
	/**
     * Génère une représentation SVG du rectangle.
     *
     * @return Une chaîne de caractères représentant le rectangle en format SVG.
     */
	@Override
	public String enSVG() {
		// Génère la représentation SVG du texte avec les dimensions mises à jour
		return "<text x=\"" + x + "\" y=\"" + y + "\" font-size=\"" + taille + "\" text-anchor=\"middle\" fill=\""
				+ couleur + "\" stroke=\"black\" transform=\"rotate(" + angle + ")\">" + texte + "</text>";
	}
	/**
     * Change la couleur du rectangle.
     *
     * @param couleurs Un tableau de couleurs à appliquer au rectangle.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne.
     */
	public IForme colorier(String... couleurs) {
		couleur = couleurs[0];
		return this;
	}

	/**
     * Ré-ajuste la hauteur et la largeur du rectangle.
     *
     * @param hauteur La hauteur de redimmensionement 
     * @param largeur La largeur de redimmensionement
     * @throws IllegalArgumentException si la hauteur ou largeur de red. est égale à 0 ou moins.
     * @return Une référence à l'instance du rectangle, pour permettre les
     *         opérations en chaîne. La hauteur du rectangle va être multipliée par celle de redimmensionnement,
     *         pareil pour la largeur.
     */
	@Override
	public IForme redimmensioner(double h, double l) {
		hauteur = h;
		largeur = l;
		return this;
	}
	/**
     * Crée un fichier SVG représentant le rectangle.
     */
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
