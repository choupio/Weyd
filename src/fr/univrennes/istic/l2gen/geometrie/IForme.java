package fr.univrennes.istic.l2gen.geometrie;

/**
 * Interface représentant une forme géométrique.
 */
public interface IForme {

	/**
	 * Retourne le centre de la forme géométrique.
	 *
	 * @return Le centre de la forme géométrique.
	 * @ensures centre >= (0,0)
	 * @throws IllegalStateException si centre a son X et/ou Y plus petit que 0.
	 */
	public Point centre();

	/**
	 * Retourne une description de la forme géométrique, avec une indentation
	 * spécifiée.
	 *
	 * @param indentation Le niveau d'indentation pour la description.
	 * @requires indentation >= 0
	 * @throws IllegalArgumentException si indentation est plus petit que 0.
	 * @return Une chaîne de caractères décrivant la forme géométrique.
	 * @ensures description = identation@pre + description des éléments de la figure
	 */
	public String description(int indentation);

	/**
	 * Retourne la hauteur de la forme géométrique.
	 *
	 * @return La hauteur de la forme géométrique.
	 * @ensures hauteur >= 0.0
	 * @throws IllegalStateException si hauteur est plus petit que 0.
	 */
	public double hauteur();

	/**
	 * Retourne la largeur de la forme géométrique.
	 *
	 * @return La largeur de la forme géométrique.
	 * @ensures largeur >= 0.0
	 * @throws IllegalStateException si largeur est plus petit que 0.
	 */
	public double largeur();

	/**
	 * Déplace la forme géométrique selon les déplacements spécifiés.
	 *
	 * @param dx Le déplacement en abscisse.
	 * @param dy Le déplacement en ordonnée.
	 * @throws IllegalStateException si x ou y devient plus petit que 0.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 * @ensures la forme à été déplacée de dx, dy.
	 */
	public IForme deplacer(double dx, double dy);

	/**
	 * Duplique la forme géométrique.
	 *
	 * @return Une nouvelle instance de la forme géométrique avec les mêmes
	 *         propriétés.
	 * @ensures une copie profonde du IForme en question
	 */
	public IForme dupliquer();

	/**
	 * Redimensionne la forme géométrique selon les dimensions spécifiées.
	 *
	 * @param h La hauteur de redimensionnement.
	 * @param l La largeur de redimensionnement.
	 * @throws IllegalArgumentException si la hauteur ou la largeur valent 0 ou
	 *                                  moins.
	 * @throws IllegalStateException    si aussi si le résultat de
	 *                                  redimensionner donne une coordonnée < 0.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 * @ensure une figure de taille différente.
	 */
	public IForme redimmensioner(double h, double l);

	/**
	 * Retourne une représentation SVG de la forme géométrique.
	 *
	 * @return Une chaîne de caractères représentant la forme géométrique en format
	 *         SVG.
	 * @ensures une chaîne de caractères représentant correctement le forme
	 *          géométrique en question
	 */
	public String enSVG();

	/**
	 * Change la couleur de la forme géométrique.
	 *
	 * @param couleurs Un tableau de couleurs à appliquer à la forme géométrique.
	 * @requires couleurs.length >= 1 (sinon rien ne sera colorié)
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 * @ensures la ou les formes en question soient coloriées à partir des couleurs
	 *          en paramètres
	 */
	public IForme colorier(String... couleurs);

	/**
	 * Tourne la forme
	 * 
	 * @param angle l'angle de rotation
	 * @requires angle >= 0
	 * @throws IllegalArgumentException si l'angle est négatif.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 * @ensures la forme en question est tournée de angle degrés
	 */
	public IForme tourner(int angle);

	/***
	 * @param alignement direction HAUT, BAS, DROITE ou GAUCHE
	 * @param cible      ligne horizontale ou verticale sur laquelle doit s'aligner
	 *                   la figure
	 * @requires cible >= 0
	 * @throws IllegalArgumentException si cible < 0
	 * @throws IllegalStateException    si X ou Y deviennent négatifs.
	 * @return Une référence à l'instance de la forme géométrique, pour permettre
	 *         les opérations en chaîne.
	 * @ensures la figure doit être alignée de cible pixel selon l'alignement en
	 *          paramètre
	 */
	public IForme aligner(Alignement alignement, double cible);

	/**
	 * Crée un fichier SVG représentant la forme géométrique.
	 * Affiche un message d'erreur ou de succès selon le déroulement de la création
	 * du fichier
	 * 
	 * @ensures la création d'un fichier où l'on peut visualiser graphiquement la
	 *          figure en question
	 */
	public void createSvgFile();
}
