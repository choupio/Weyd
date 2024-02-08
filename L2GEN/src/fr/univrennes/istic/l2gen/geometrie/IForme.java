package fr.univrennes.istic.l2gen.geometrie;

public interface IForme {

    public Point centre();

    public String description(int indentation);

    public double hauteur();

    public double largeur();

    public void deplacer(double dx, double dy);

    public IForme dupliquer();

    public void redimmensioner(double h, double l);

    public String enSVG();
}
