package fr.univrennes.istic.l2gen.geometrie;

/**
 * Cette classe représente un secteur de cercle.
 */
public class Secteur implements IForme {

    private double arc; 
    private double angle;
    private Point centre;
    private double rayon;

    /**
     * Calcule la hauteur du secteur.
     * @return La hauteur du secteur.
     */
    @Override
    public double hauteur() {
        return hauteur();
    }

    /**
     * Calcule la largeur du secteur.
     * @return La largeur du secteur.
     */
    @Override
    public double largeur() {
        return largeur();
    }

    /**
     * Redimensionne le secteur.
     * @param largeur La nouvelle largeur.
     * @param hauteur La nouvelle hauteur.
     */
    public void redimmensioner(double largeur, double hauteur) {
        this.rayon = rayon * largeur;
    }

    /**
     * Retourne le point central du secteur.
     * @return Le point central du secteur.
     */
    public Point getPoint(){
        return centre;
    }

    /**
     * Retourne l'arc du secteur.
     * @return L'arc du secteur.
     */
    public double getArc(){
        return arc;
    } 

    /**
     * Définit l'arc du secteur.
     * @param arc Le nouvel arc.
     */
    public void setArc(double arc){
        this.arc = arc;
    }

    /**
     * Retourne l'angle du secteur.
     * @return L'angle du secteur.
     */
    public double getAngle(){
        return angle;
    }

    /**
     * Retourne le rayon du secteur.
     * @return Le rayon du secteur.
     */
    public double getRayon(){
        return rayon;
    }

    /**
     * Définit l'angle du secteur.
     * @param angle Le nouvel angle.
     */
    public void setAngle(double angle){
        this.angle = angle;
    }

    /**
     * Retourne le centre du secteur.
     * @return Le centre du secteur.
     */
    public Point centre(){
        return centre;
    }

    /**
     * Constructeur de la classe Secteur prenant les coordonnées x et y du centre, le rayon, l'angle et l'arc du secteur.
     * @param x La coordonnée x du centre.
     * @param y La coordonnée y du centre.
     * @param rayon Le rayon du secteur.
     * @param angle L'angle du secteur.
     * @param arc L'arc du secteur.
     */
    public Secteur (double x, double y, double rayon, double angle, double arc){
        this.centre = new Point(x, y);
        this.rayon = rayon;
        this.angle = angle;
        this.arc = arc;
    }

    /**
     * Constructeur de la classe Secteur prenant un Point comme centre, le rayon, l'angle et l'arc du secteur.
     * @param f Le point central du secteur.
     * @param rayon Le rayon du secteur.
     * @param angle L'angle du secteur.
     * @param arc L'arc du secteur.
     */
    public Secteur(Point f, double rayon, double angle, double arc) {
        this.centre = f;
        this.rayon = rayon;
        this.angle = angle;
        this.arc = arc;
    }

    /**
     * Génère une description du secteur.
     * @param indentation L'indentation pour la description.
     * @return Une chaîne de caractères décrivant le secteur.
     */
    @Override
    public String description(int indentation) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            indent.append("  ");
        }
        return "Secteur " + indent.toString() + "centre=" + centre.x() + "," + centre.y() +" Angle=" + getAngle() + " Arc=" + getArc();
    }

    /**
     * Déplace le secteur selon les coordonnées spécifiées.
     * @param dx Le déplacement horizontal.
     * @param dy Le déplacement vertical.
     */
    public void deplacer(double dx, double dy) {
        this.centre = this.centre.plus(dx, dy);
    }

    /**
     * Duplique le secteur.
     * @return Une copie du secteur.
     */
    public IForme dupliquer() {
        return new Secteur(centre, rayon, angle, arc);
    }

    /**
     * Génère la représentation SVG du secteur.
     * @return La représentation SVG du secteur.
     */
    public String enSVG() {
        double startAngle = Math.toRadians(getAngle());
        double endAngle = Math.toRadians(getAngle() + getArc());

        double startX = centre.x() + getRayon() * Math.cos(startAngle);
        double startY = centre.y() - getRayon() * Math.sin(startAngle);

        double endX = centre.x() + getRayon() * Math.cos(endAngle);
        double endY = centre.y() - getRayon() * Math.sin(endAngle);

        int largeArcFlag = (getArc() > 180) ? 1 : 0;

        return "<path d=\"M " + startX + " " + startY + " A " + getRayon() + " " + getRayon() 
        + " 0 " + largeArcFlag + " 0 " + endX + " " + endY + " L " + centre.x() + " " + centre.y() + " Z\"\n"
                + "\t" + "fill=\"white\"" + " stroke=\"black\"/>";  
    }

} 
