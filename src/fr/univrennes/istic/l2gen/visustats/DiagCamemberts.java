package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Secteur;
import fr.univrennes.istic.l2gen.geometrie.Texte;

/**
 * Cette classe représente un diagramme en camembert.
 * Elle implémente l'interface IDataVisualiseur.
 */
public class DiagCamemberts implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    double rayon = 100;
    Point centre = new Point(500,500);
    List<String> couleurs;
    Groupe donnees, legendeGroupe, legendes, diagGroupe;
    

    /**
     * Constructeur de DiagCamemberts
     * 
     * @param nom    une String représentant le nom du diagramme
     */
    public DiagCamemberts(String nom) {
        this.nom = nom;
        legendes = new Groupe();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
    }

    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int indentation) {
        return diagGroupe.description(indentation);
    }

    @Override
    public double hauteur() {
        return diagGroupe.hauteur();
    }

    @Override
    public double largeur() {
        return diagGroupe.largeur();
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        diagGroupe.deplacer(dx, dy);
        return diagGroupe;
    }

    @Override
    public IForme dupliquer() {
        return diagGroupe.dupliquer();
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        return diagGroupe.redimmensioner(h, l);
    }

    @Override
    public String enSVG() {
        return diagGroupe.enSVG();
    }

    @Override
    public IForme colorier(String... couleurs) {
        for (IForme secteur : donnees.getListFormes()) {
            secteur.colorier(couleurs);
        }

        int i = 0;
        for (IForme forme : legendeGroupe.getListFormes()) {
            if (forme instanceof Rectangle) {
                forme.colorier(couleurs[i]);
                i++;
                if (i >= couleurs.length) {
                    i = 0;
                }
            }

        }

        return this;
    }

    @Override
    public IForme tourner(int angle) {
        return diagGroupe.tourner(angle);
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        return diagGroupe.aligner(alignement, cible);
    }

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "diagCamenberts");
    }

    @Override
    public IDataVisualiseur agencer() {
        
        // Titre
        texteNom = new Texte(0, 0, 12, nom);
        double axeY = donnees.getListFormes().get(0).centre().y() * 0.01;
        double axeX = donnees.getListFormes().get(0).centre().x() * 0.01;
        texteNom.deplacer(centre.x()*1.55,
        centre.y() - donnees.hauteur() / 2 - texteNom.hauteur());
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);
        legendeGroupe.empilerElements(Alignement.GAUCHE, centre.x() *1.5 - legendeGroupe.largeur(), 10);
        legendeGroupe.alignerElements(Alignement.BAS,
                centre.y() + donnees.hauteur() / 2 + legendeGroupe.hauteur() * 2 +40);
        diagGroupe.ajouter(legendeGroupe);
        System.out.println(centre.y()-donnees.hauteur()/2);        
        legendes.empilerElements(Alignement.GAUCHE, centre.x() + 30 - legendes.largeur(), 225);
        legendes.alignerElements(Alignement.BAS,
                centre.y() + donnees.hauteur() / 2 + legendes.hauteur() * 2+10  );
        diagGroupe.ajouter(legendes);
        for (IForme forme : donnees.getListFormes()) {
            forme.deplacer(axeX, axeY);
            System.out.print(forme.description(0));
            axeX += 250;
        }

        // Echelle

        return this;
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        double somme = 0;
        for(int i = 0;i<doubles.length;i++){
            somme += doubles[i];
        }
        Camembert cam = new Camembert(centre, rayon);
        for(int i = 0;i<doubles.length;i++){
            cam.ajouterSecteur("white", doubles[i]/somme);
        }        
        legendes.ajouter(new Texte(0, 0, 10, str));
        donnees.ajouter(cam);
        return this;
    }

    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
            legendeGroupe.ajouter(new Texte(0, 0, 10, string));
        }

        return this;
    }

    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}