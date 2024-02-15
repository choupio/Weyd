package fr.univrennes.istic.l2gen.geometrie;

import java.util.ArrayList;
import java.util.List;

public class Polygone implements IForme {

    private List<Point> points;
    private String couleur;

    {
        couleur = "black";
    }

    public Polygone(double... d) {
        this.points = new ArrayList<>();
        for (int i = 1; i < d.length; i += 2) {
            points.add(new Point(d[i], d[i - 1]));
        }
    }

    public void ajouterSommet(Point point) {
        points.add(new Point(point.x(), point.y()));
    }

    public void ajouterSommet(double d1, double d2) {
        points.add(new Point(d1, d2));
    }

    @Override
    public Point centre() {
        // TODO revoir ça
        double x = 0, y = 0;
        for (Point point : points) {
            x += point.x();
            y += point.y();
        }
        return new Point(x / points.size(), y / points.size());
    }

    @Override
    public String description(int entier) {
        String cran = "";
        for (int i = 0; i < entier; i += 1) {
            cran += "  ";
        }

        String s = "Polygone";
        for (Point point : points) {
            s += cran + point.x() + "," + point.y();
        }
        return s;
    }

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

    public List<Point> getSommets() {
        return points;
    }

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

    @Override
    public void deplacer(double dx, double dy) {
        for (Point point : points) {
            point = new Point(dx + point.x(), dy + point.y());
        }
    }

    @Override
    public IForme dupliquer() {
        Polygone polygone = new Polygone();
        for (Point point : points) {
            polygone.ajouterSommet(point);
        }
        return polygone;
    }

    @Override
    public void redimmensioner(double h, double l) {
        for (Point point : points) {
            Point centre = this.centre();
            double distance = Math.sqrt(Math.pow(centre.x() - point.x(), 2) + Math.pow(centre.y(), point.y()));
            point = new Point(point.x() + distance * (1 - h), point.y() + distance * (1 - l));
        }
    }

    @Override
    public String enSVG() {
        String s = "<polygon points=\"";
        for (Point point : points) {
            s += point.x() + " " + point.y() + " ";
        }

        s += "\" fille=\"white\" stroke=\"" + couleur + "\"/>";
        return s;
    }

    public void colorier(String... couleurs) {

    }

}
