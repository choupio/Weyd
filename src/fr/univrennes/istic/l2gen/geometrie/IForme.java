package fr.univrennes.istic.l2gen.geometrie;

/**
 * Interface représentant une forme géométrique.
 */
public interface IForme {

	/**
	 * Retourne le centre de la forme géométrique.
	 *
	 * @return Le centre de la forme géométrique.
	 */
	public Point centre();

	/**
	 * Retourne une description de la forme géométrique, avec une indentation
	 * spécifiée.
	 *
	 * @param indentation Le niveau d'indentation pour la description.
	 * @throws IllegalArgumentException si indentation est plus petit que 0.
	 * @return Une chaîne de caractères décrivant la forme géométrique.
	 */
	public String description(int indentation);

	/**
	 * Retourne la hauteur de la forme géométrique.
	 *
	 * @return La hauteur de la forme géométrique.
	 */
	public double hauteur();

	/**
	 * Retourne la largeur de la forme géométrique.
	 *
	 * @return La largeur de la forme géométrique.
	 */
	public double largeur();

	/**
	 * Déplace la forme géométrique selon les déplacements spécifiés.
	 *
	 * @param dx Le déplacement en abscisse.
	 * @param dy Le déplacement en ordonnée.
	 * @throws IllegalArgumentException si x ou y devient plus petit que 0.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 */
	public IForme deplacer(double dx, double dy);

	/**
	 * Duplique la forme géométrique.
	 *
	 * @return Une nouvelle instance de la forme géométrique avec les mêmes
	 *         propriétés.
	 */
	public IForme dupliquer();

	/**
	 * Redimensionne la forme géométrique selon les dimensions spécifiées.
	 *
	 * @param h La hauteur de redimensionnement.
	 * @param l La largeur de redimensionnement.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 */
	public IForme redimmensioner(double h, double l);

	/**
	 * Retourne une représentation SVG de la forme géométrique.
	 *
	 * @return Une chaîne de caractères représentant la forme géométrique en format
	 *         SVG.
	 */
	public String enSVG();

	/**
	 * Change la couleur de la forme géométrique.
	 *
	 * @param couleurs Un tableau de couleurs à appliquer à la forme géométrique.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 */
	public IForme colorier(String... couleurs);

	/**
	 * Tourne la forme
	 * 
	 * @param angle l'angle de rotation
	 * @throws IllegalArgumentException si l'angle est négatif.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 */
	public IForme tourner(int angle);

	/***
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 */
	public IForme aligner(Alignement alignement, double cible);

	/**
	 * Crée un fichier SVG représentant la forme géométrique.
	 */
	public void createSvgFile();
}
