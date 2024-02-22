package fr.univrennes.istic.l2gen.geometrie;

/**
 * La classe Point représente un point dans un espace bidimensionnel.
 */
public class Point {

    private double x; // Coordonnée x du point
    private double y; // Coordonnée y du point

    /**
     * Retourne la coordonnée x du point.
     *
     * @return La coordonnée x du point.
     */
    public double x() {
        return x;
    }

    /**
     * Retourne la coordonnée y du point.
     *
     * @return La coordonnée y du point.
     */
    public double y() {
        return y;
    }

    /**
     * Définit la coordonnée x du point.
     *
     * @param x La nouvelle coordonnée x du point.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Définit la coordonnée y du point.
     *
     * @param y La nouvelle coordonnée y du point.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Initialise un nouveau point avec les coordonnées spécifiées.
     *
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compare l'objet spécifié avec ce point pour l'égalité.
     *
     * @param o L'objet à comparer à ce point.
     * @return true si l'objet est un point et a les mêmes coordonnées x et y, false sinon.
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
     * Ajoute les coordonnées du point spécifié à ce point pour créer un nouveau point.
     *
     * @param p Le point à ajouter à ce point.
     * @return Un nouveau point dont les coordonnées sont la somme des coordonnées de ce point et du point spécifié.
     */
    public Point plus(Point p) {
        setX(this.x+p.x());
        setY(this.y+p.y());
        return new Point(this.x, this.y);
    }

    /**
     * Ajoute les coordonnées spécifiées à ce point pour créer un nouveau point.
     *
     * @param x1 La coordonnée x à ajouter à ce point.
     * @param y1 La coordonnée y à ajouter à ce point.
     * @return Un nouveau point dont les coordonnées sont la somme des coordonnées de ce point et des coordonnées spécifiées.
     */
    public Point plus(double x1, double y1) {
        setX(this.x+x1);
        setY(this.y+y1);
        return new Point(this.x, this.y);
    }

    /**
     * @param p
     * @return le maximum des coordonnées x et y de ce point et du point spécifié.
     */
    public double max(Point p) {
        return Math.max(this.x, p.x()) + Math.max(this.y, p.y());
    }

    /**
     * @param p
     * @return le minimum des coordonnées x et y de ce point et du point spécifié.
     */
    public double min(Point p) {
        return Math.min(this.x, p.x()) + Math.min(this.y, p.y());
    }
    
}
