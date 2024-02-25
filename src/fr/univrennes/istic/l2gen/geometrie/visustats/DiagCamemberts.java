package fr.univrennes.istic.l2gen.geometrie.visustats;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;

public class DiagCamemberts implements IDataVisualiseur {
    private String nom;
    private int entier;
    private Groupe groupeCamembert;

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
     * formes dans le groupe.
     *
     * @return Le centre du groupe.
     */
    @Override
    public Point centre() {
        return groupeCamembert.centre();
    }

    @Override
    public String description(int indentation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'description'");
    }

    @Override
    public double hauteur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hauteur'");
    }

    @Override
    public double largeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'largeur'");
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deplacer'");
    }

    @Override
    public IForme dupliquer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dupliquer'");
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimmensioner'");
    }

    @Override
    public String enSVG() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enSVG'");
    }

    @Override
    public IForme colorier(String... couleurs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorier'");
    }

    @Override
    public IForme tourner(int angle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tourner'");
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aligner'");
    }

    @Override
    public void createSvgFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSvgFile'");
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
