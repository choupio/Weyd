package fr.univrennes.istic.l2gen.geometrie;

public class Point {

    private double x;
    private double y;

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Prend un objet et le compare avec le point.
     * 
     * @return false si l'objet n'est pas un point ou si ses x et y ne sont pas
     *         égaux à celui du point, et true si ses x et y sont égaux à celui du
     *         point.
     */
    public boolean equals(Object o) {
        if (o instanceof Point) {
            if (((Point) o).x() == this.x() && ((Point) o).y() == this.y()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Prend un point p et l'additionne au point actuel, créeant un nouveau point.
     * 
     * @param p
     * @return
     */
    public Point plus(Point p) {
        return new Point(this.x() + p.x(), this.y() + p.y());
    }

    /**
     * Prend des coordonnées x1 et y1, et les additionne au point pour en créer un
     * nouveau.
     * 
     * @param x1
     * @param y1
     * @return
     */
    public Point plus(double x1, double y1) {
        return new Point(this.x() + x1, this.y() + y1);
    }
}
