package fr.univrennes.istic.l2gen.geometrie.visustats;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;

public class DiagCamemberts implements IDataVisualiseur {
    private String nom;
    private int entier;
    Groupe groupeCamembert;

    /**
     * Constructeur de DiagCamemberts
     * 
     * @param nom    une String représentant le nom du diagramme
     * @param entier
     */
    public DiagCamemberts(String nom, int entier) {
        this.nom = nom;
        this.entier = entier;
        this.groupeCamembert = new Groupe();
    }

    /**
     * Retourne le centre du groupe, calculé comme le centre moyen de toutes les
     * formes dans le diag.
     *
     * @return Le centre du diag.
     */
    @Override
    public Point centre() {
        return groupeCamembert.centre();
    }

    @Override
    public String description(int indentation) {
        return groupeCamembert.description(indentation);
    }

    @Override
    public double hauteur() {
        return groupeCamembert.hauteur();
    }

    @Override
    public double largeur() {
        return groupeCamembert.largeur();
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        groupeCamembert.deplacer(dx, dy);
        return this;
    }

    @Override
    public IForme dupliquer() {
        return groupeCamembert.dupliquer();
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        if (h < 0 || l < 0) {
            throw new IllegalArgumentException("Hauteur et Largeur doivent être positifs.");
        }
        groupeCamembert.redimmensioner(h, l);
        return this;
    }

    @Override
    public String enSVG() {
        return groupeCamembert.enSVG();
    }

    @Override
    public IForme colorier(String... couleurs) {
        groupeCamembert.colorier(couleurs);
        return this;
    }

    @Override
    public IForme tourner(int angle) {
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle doit être positif.");
        }
        groupeCamembert.tourner(angle);
        return this;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        if (cible < 0) {
            throw new IllegalArgumentException("La cible doit être positive.");
        }
        groupeCamembert.aligner(alignement, cible);
        return this;
    }

    @Override
    public void createSvgFile() {
        groupeCamembert.createSvgFile();
    }

    @Override
    public IDataVisualiseur agencer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agencer'");
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouterDonnees'");
    }

    @Override
    public IDataVisualiseur legender(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'legender'");
    }

    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}
