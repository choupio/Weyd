package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

/**
 * La classe Triangle représente un triangle défini par trois points.
 */
public class Triangle implements IForme {

    Point point1; // Premier point du triangle
    Point point2; // Deuxième point du triangle
    Point point3; // Troisième point du triangle
    String couleur = "white"; // Couleur du triangle en "white"
    private int angle = 0; // Angle du triangle

    /**
     * Constructeur de la classe Triangle prenant les coordonnées des sommets du
     * triangle.
     *
     * @param x1 Coordonnée x du premier sommet.
     * @param y1 Coordonnée y du premier sommet.
     * @param x2 Coordonnée x du deuxième sommet.
     * @param y2 Coordonnée y du deuxième sommet.
     * @param x3 Coordonnée x du troisième sommet.
     * @param y3 Coordonnée y du troisième sommet.
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        point1 = new Point(x1 - y1 / 2, y1 * 2);
        point2 = new Point(x2 - y2 / 2, y2);
        point3 = new Point(x3, y3);
    }

    /**
     * Constructeur de la classe Triangle prenant les objets Point comme sommets du
     * triangle.
     *
     * @param point1 Premier sommet du triangle.
     * @param point2 Deuxième sommet du triangle.
     * @param point3 Troisième sommet du triangle.
     */
    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    /**
     * Retourne le centre du triangle.
     *
     * @return Le centre du triangle.
     */
    @Override
    public Point centre() {
        double milieuXdeP1P2 = (point1.x() + point2.x()) / 2;
        double milieuYdeP1P2 = (point1.y() + point2.y()) / 2;
        double milieuXdeP2P3 = (point2.x() + point3.x()) / 2;
        double milieuYdeP2P3 = (point2.y() + point3.y()) / 2;
        double milieuXdeP3P1 = (point3.x() + point1.x()) / 2;
        double milieuYdeP3P1 = (point3.y() + point1.y()) / 2;
        double xCentre = (milieuXdeP1P2 + milieuXdeP2P3 + milieuXdeP3P1) / 3;
        double yCentre = (milieuYdeP1P2 + milieuYdeP2P3 + milieuYdeP3P1) / 3;
        Point centre = new Point(xCentre, yCentre);
        return centre;
    }

    /**
     * Retourne une description du triangle avec une indentation spécifiée.
     *
     * @param entier L'indentation pour la description.
     * @return La description du triangle.
     */
    @Override
    public String description(int entier) {
        String cran = "";
        for (int i = 0; i < entier; i += 1) {
            cran += " ";
        }
        return cran + "Triangle " + point1.x() + ", " + point1.y() + " " + point2.x() + ", " + point2.y() + " "
                + point3.x() + ", " + point3.y() + " de couleur " + couleur + " angle=" + angle;
    }

    /**
     * Retourne la hauteur du triangle.
     *
     * @return La hauteur du triangle.
     */
    @Override
    public double hauteur() {
        double minY = Math.min(point1.y(), Math.min(point2.y(), point3.y()));
        double maxY = Math.max(point1.y(), Math.max(point2.y(), point3.y()));
        return maxY - minY;
    }

    /**
     * Retourne la largeur du triangle.
     *
     * @return La largeur du triangle.
     */
    @Override
    public double largeur() {
        return cote(point2, point1);
    }

    /**
     * Calcule la longueur d'un côté du triangle.
     *
     * @param pointA Le premier point du côté.
     * @param pointB Le deuxième point du côté.
     * @return La longueur du côté.
     */
    public double cote(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointB.x() - pointA.x(), 2) + Math.pow(pointB.y() - pointA.y(), 2));
    }

    /**
     * Déplace le triangle selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance du triangle, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        point1 = new Point(dx + point1.x(), dy + point1.y());
        point2 = new Point(dx + point2.x(), dy + point2.y());
        point3 = new Point(dx + point3.x(), dy + point3.y());
        return this;
    }

    /**
     * Duplique le triangle.
     *
     * @return Une nouvelle instance du triangle avec les mêmes propriétés.
     */
    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Triangle nouvelleForme = new Triangle(point1.x(), point1.y(), point2.x(), point2.y(), point3.x(), point3.y());
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        nouvelleForme.angle = this.angle;
        return nouvelleForme;
    }

    /**
     * Redimensionne le triangle selon les nouvelles dimensions spécifiées.
     *
     * @param h La nouvelle hauteur du triangle.
     * @param l La nouvelle largeur du triangle.
     * @return Une référence à l'instance du triangle, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        Point leCentre = centre();
        double halfHeight = h / 2;
        double halfWidth = l / 2;
        double newPoint1X = leCentre.x() - halfWidth;
        double newPoint1Y = leCentre.y() - halfHeight;
        double newPoint2X = leCentre.x() + halfWidth;
        double newPoint2Y = leCentre.y() - halfHeight;
        double newPoint3X = leCentre.x();
        double newPoint3Y = leCentre.y() + halfHeight;
        point1 = new Point(newPoint1X, newPoint1Y);
        point2 = new Point(newPoint2X, newPoint2Y);
        point3 = new Point(newPoint3X, newPoint3Y);
        return this;
    }

    /**
     * Génère une représentation SVG du triangle.
     *
     * @return Une chaîne de caractères représentant le triangle en format SVG.
     */
    @Override
    public String enSVG() {
        // Génère la représentation SVG du triangle
        String aRetourner = "<polygon points=\"" + point1.x() + "," + point1.y() + " " + point2.x() + "," + point2.y()
                + " "
                + point3.x() + "," + point3.y() + "\" " +
                "fill=\"" + couleur + "\" stroke=\"black\"";
        if (angle != 0) {
            return aRetourner += " transform=\"rotate(" + angle + ")\"/>";
        } else {
            return aRetourner += "/>";
        }
    }

    /**
     * Change la couleur du triangle.
     *
     * @param couleurs Un tableau de couleurs à appliquer au triangle.
     * @return Une référence à l'instance du triangle, pour permettre les opérations
     *         en chaîne.
     */
    @Override
    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    /**
     * Créer un fichier SVG représentant le triangle.
     */
    @Override
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Triangle.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

    public IForme tourner(int angle) {
        this.angle = angle;
        return this;
    }

    public IForme aligner(Alignement alignement, double cible) {
        ArrayList<Point> lstPoints = new ArrayList<Point>();
        lstPoints.add(point1);
        lstPoints.add(point2);
        lstPoints.add(point3);

        if (alignement == Alignement.HAUT) {

			// recherche du y minimum
			double minY = lstPoints.get(0).y();
			for (Point point : lstPoints) {
				if (minY > point.y()) {
					minY = point.y();
				}
			}

			double distanceY = cible - minY;
			for (int i = 0; i < lstPoints.size(); i++) {
				Point point = lstPoints.remove(i);
				lstPoints.add(i, new Point(point.x(), point.y() + distanceY));
			}
		} else if (alignement == Alignement.BAS) {
			// recherche du y maximum
			double maxY = lstPoints.get(0).y();
			for (Point point : lstPoints) {
				if (maxY < point.y()) {
					maxY = point.y();
				}
			}

			double distanceY = cible - maxY;
			for (int i = 0; i < lstPoints.size(); i++) {
				Point point = lstPoints.remove(i);
				lstPoints.add(i, new Point(point.x(), point.y() + distanceY));
			}
		} else if (alignement == Alignement.GAUCHE) {
			// recherche du x minimum
			double minX = lstPoints.get(0).x();
			for (Point point : lstPoints) {
				if (minX > point.x()) {
					minX = point.x();
				}
			}

			double distanceX = cible - minX;
			for (int i = 0; i < lstPoints.size(); i++) {
				Point point = lstPoints.remove(i);
				lstPoints.add(i, new Point(point.x() + distanceX, point.y()));
			}
		} else if (alignement == Alignement.DROITE) {
			// recherche du x minimum
			double maxX = lstPoints.get(0).x();
			for (Point point : lstPoints) {
				if (maxX < point.x()) {
					maxX = point.x();
				}
			}

			double distanceX = cible - maxX;
			for (int i = 0; i < lstPoints.size(); i++) {
				Point point = lstPoints.remove(i);
				lstPoints.add(i, new Point(point.x() + distanceX, point.y()));
			}
		}

		return this;
    }
}
