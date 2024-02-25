package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Polygone représente un polygone défini par une série de sommets.
 */
public class Polygone implements IForme {


	public List<Point> getSommets() {
		return points;
	}

	private List<Point> points; // Liste des sommets du polygone
	private String couleur = "white"; // Couleur du polygone en "white"
	private int angle = 0;

	/**
	 * Constructeur de la classe Polygone prenant en paramètre les coordonnées des
	 * sommets du polygone.
	 *
	 * @param d Les coordonnées des sommets du polygone. Chaque paire de valeurs
	 *          consécutives représente les coordonnées x et y d'un sommet.
	 */
	public Polygone(double... d) {
		this.points = new ArrayList<>();
		for (int i = 1; i < d.length; i += 2) {
			points.add(new Point(d[i - 1], d[i]));
		}
	}

	/**
	 * Ajoute un sommet au polygone.
	 *
	 * @param point Le sommet à ajouter au polygone.
	 * @return Une référence à l'instance actuelle du polygone, pour permettre les
	 *         opérations en chaîne.
	 */
	public IForme ajouterSommet(Point point) {
		points.add(new Point(point.x(), point.y()));
		return this;
	}

	/**
	 * Ajoute un sommet au polygone en spécifiant ses coordonnées.
	 *
	 * @param d1 La coordonnée x du sommet à ajouter.
	 * @param d2 La coordonnée y du sommet à ajouter.
	 * @return Une référence à l'instance actuelle du polygone, pour permettre les
	 *         opérations en chaîne.
	 */
	public IForme ajouterSommet(double d1, double d2) {
		points.add(new Point(d1, d2));
		return this;
	}

	/**
	 * Retourne le centre du polygone, calculé comme la moyenne des coordonnées de
	 * ses sommets.
	 *
	 * @return Le centre du polygone.
	 */
	@Override
	public Point centre() {
		// TODO Il faut refaire car le calcul est mauvais
		double x = 0, y = 0;
		for (Point point : points) {
			x += point.x();
			y += point.y();
		}
		if(x<0 || y<0){throw new IllegalArgumentException("Le centre a un x ou y inférieur à 0");}
		return new Point(x / points.size(), y / points.size());
	}

	/**
	 * Retourne une description du polygone avec une indentation spécifiée.
	 *
	 * @param indentation Le niveau d'indentation pour la description.
	 * @return Une chaîne de caractères décrivant le polygone.
	 */
	@Override
	public String description(int indentation) {
		if(indentation < 0){throw new IllegalArgumentException("L'indentation doit être supérieur ou égal à 0");}
		
		String cran = "";
		for (int i = 0; i < indentation; i += 1) {
			cran += "  ";
		}

		String s = cran + "Polygone ";
		for (Point point : points) {
			s += point.x() + "," + point.y() + " ";
		}
		s = s.substring(0, s.length() - 1); // supprime le dernier caractere
		s += " couleur=" + couleur;
		if (angle != 0) {
			s += " angle=" + angle;
		}
		return s;
	}

	/**
	 * Retourne la hauteur du polygone, calculée comme la différence entre la
	 * coordonnée y maximale et la coordonnée y minimale parmi tous les sommets.
	 *
	 * @return La hauteur du polygone.
	 */
	@Override
	public double hauteur() {

		Point mini = points.get(0), max = points.get(0);
		for (Point point : points) {
			if (point.y() < mini.y()) {
				mini = point;
			}
			if (point.y() > max.y()) {
				max = point;
			}
		}
		return max.y() - mini.y();
	}

	/**
	 * Retourne la largeur du polygone, calculée comme la différence entre la
	 * coordonnée x maximale et la coordonnée x minimale parmi tous les sommets.
	 *
	 * @return La largeur du polygone.
	 */
	@Override
	public double largeur() {
		Point mini = points.get(0), max = points.get(0);
		for (Point point : points) {
			if (point.x() < mini.x()) {
				mini = point;
			}
			if (point.x() > max.x()) {
				max = point;
			}
		}
		return max.x() - mini.x();
	}

	/**
	 * Déplace le polygone selon les déplacements spécifiés.
	 *
	 * @param dx Le déplacement en abscisse.
	 * @param dy Le déplacement en ordonnée.
	 * @return Une référence à l'instance du polygone, pour permettre les opérations
	 *         en chaîne.
	 */
	@Override
	public IForme deplacer(double dx, double dy) {
		for (int i = 0; i < points.size(); i++) {
			Point point = points.remove(i);
			points.add(i, new Point(dx + point.x(), dy + point.y()));
		}
		return this;
	}

	/**
	 * Duplique le polygone.
	 *
	 * @return Une nouvelle instance du polygone avec les mêmes propriétés.
	 */
	@Override
	public IForme dupliquer() {
		// Crée une nouvelle instance de la classe avec les mêmes propriétés
		Polygone nouvelleForme = new Polygone();
		for (Point point : points) {
			nouvelleForme.ajouterSommet(point);
		}
		nouvelleForme.angle = this.angle;
		nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
		return nouvelleForme;
	}

	/**
	 * Redimensionne le polygone selon les dimensions spécifiées.
	 *
	 * @param h La hauteur de redimensionnement.
	 * @param l La largeur de redimensionnement.
	 * @return Une référence à l'instance du polygone, pour permettre les opérations
	 *         en chaîne.
	 */
	@Override
	public IForme redimmensioner(double h, double l) {
		Point centre = this.centre();
		for (int i = 0; i < points.size(); i++) {
			Point point = points.remove(i);
			double distanceX = centre.x() - point.x();
			double distanceY = centre.y() - point.y();
			points.add(i, new Point(centre.x() - distanceX * h, centre.y() - distanceY * l));
		}
		return this;
	}

	/**
	 * Génère une représentation SVG du polygone.
	 *
	 * @return Une chaîne de caractères représentant le polygone en format SVG.
	 */
	@Override
	public String enSVG() {
		String s = "<polygon points=\"";
		for (Point point : points) {
			s += point.x() + " " + point.y() + " ";
		}
		s = s.substring(0, s.length() - 1); // supprime le dernier caractere
		if (angle != 0) {
			s += "\" fill=\"" + couleur + "\" stroke=\"black\" transform=\"rotate(" + angle + ")\"/>";
		} else {
			s += "\" fill=\"" + couleur + "\" stroke=\"black\"/>";
		}

		return s;
	}

	/**
	 * Change la couleur du polygone.
	 *
	 * @param couleurs Un tableau de couleurs à appliquer au polygone.
	 * @return Une référence à l'instance du polygone, pour permettre les opérations
	 *         en chaîne.
	 */
	@Override
	public IForme colorier(String... couleurs) {
		this.couleur = couleurs[0];
		return this;
	}

	/**
	 * Crée un fichier SVG représentant le polygone.
	 */
	public void createSvgFile() {
		String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("Polygone.svg"))) {
			writer.write(svgContent);
			writer.write(enSVG());
			writer.write("</svg>");
			System.out.println("Fichier créé avec succès !");
		} catch (IOException e) {
			System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
		}
	}

	@Override
	public IForme tourner(int angle) {
		this.angle = angle;
		return this;
	}

	@Override
	public IForme aligner(Alignement alignement, double cible) {
		if (alignement == Alignement.HAUT) {

			// recherche du y minimum
			double minY = points.get(0).y();
			for (Point point : points) {
				if (minY > point.y()) {
					minY = point.y();
				}
			}

			double distanceY = cible - minY;
			for (int i = 0; i < points.size(); i++) {
				Point point = points.remove(i);
				points.add(i, new Point(point.x(), point.y() + distanceY));
			}
		} else if (alignement == Alignement.BAS) {
			// recherche du y maximum
			double maxY = points.get(0).y();
			for (Point point : points) {
				if (maxY < point.y()) {
					maxY = point.y();
				}
			}

			double distanceY = cible - maxY;
			for (int i = 0; i < points.size(); i++) {
				Point point = points.remove(i);
				points.add(i, new Point(point.x(), point.y() + distanceY));
			}
		} else if (alignement == Alignement.GAUCHE) {
			// recherche du x minimum
			double minX = points.get(0).x();
			for (Point point : points) {
				if (minX > point.x()) {
					minX = point.x();
				}
			}

			double distanceX = cible - minX;
			for (int i = 0; i < points.size(); i++) {
				Point point = points.remove(i);
				points.add(i, new Point(point.x() + distanceX, point.y()));
			}
		} else if (alignement == Alignement.DROITE) {
			// recherche du x maximum
			double maxX = points.get(0).x();
			for (Point point : points) {
				if (maxX < point.x()) {
					maxX = point.x();
				}
			}

			double distanceX = cible - maxX;
			for (int i = 0; i < points.size(); i++) {
				Point point = points.remove(i);
				points.add(i, new Point(point.x() + distanceX, point.y()));
			}
		}

		return this;
	}

}
