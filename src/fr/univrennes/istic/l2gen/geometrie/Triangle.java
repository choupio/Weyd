package fr.univrennes.istic.l2gen.geometrie;

import java.lang.Math;

public class Triangle implements IForme {

    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

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

    @Override
    public String description(int entier) {
        String cran = "";
        for (int i = 0; i < entier; i += 1) {
            cran += "  ";
        }
        return "Triangle" + cran + point1.x() + "," + point1.y() + cran + point2.x() + "," + point2.y() + cran
                + point3.x() + "," + point3.y();
    }

    @Override
    public double hauteur() {
        return 0; // TODO si quelqu'un a une idée qu'il se fasse plaisir
    }

    @Override
    public double largeur() {
        return cote(point2, point1);
    }

    public double cote(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow(pointB.x() - pointA.x(), 2) + Math.pow(pointB.y() - pointA.y(), 2));
    }

    @Override
    public void deplacer(double dx, double dy) {
        point1 = new Point(dx + point1.x(), dy + point1.y());
        point2 = new Point(dx + point2.x(), dy + point2.y());
        point3 = new Point(dx + point3.x(), dy + point3.y());
    }

    @Override
    public IForme dupliquer() {
        Triangle triangle = new Triangle(point1.x(), point1.y(), point2.x(), point2.y(), point3.x(), point3.y());
        return triangle;
    }

    @Override
    public void redimmensioner(double px, double py) {
        Point leCentre = centre(); // TODO finir ça

    }

    @Override
    public String enSVG() {
        // TODO a faire
        return "";
    }

    public void colorier(String... couleurs) {
    }

}
