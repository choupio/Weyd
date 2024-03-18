package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Texte;

public class DiagBarres implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    List<String> legendes, couleurs;
    Groupe donnees, legendeGroupe, diagGroupe;

    public DiagBarres(String nom) {
        this.nom = nom;
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
    }

    @Override
    public Point centre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'centre'");
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
        return diagGroupe.enSVG();
    }

    @Override
    public IForme colorier(String... couleurs) {
        for (IForme faisceau : donnees.getListFormes()) {
            faisceau.colorier(couleurs);
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
        SVGFile.createSvgFile(this, "diagColonnes");
    }

    @Override
    public IDataVisualiseur agencer() {
        // Titre
        texteNom = new Texte(0, 0, 20, nom);

        double axeY = donnees.getListFormes().get(0).hauteur();
        for (IForme forme : donnees.getListFormes()) {
            if (axeY > forme.hauteur()) {
                axeY = forme.hauteur();
            }
        }
        double axeX = 20;
        for (IForme faisceau : donnees.getListFormes()) {
            Faisceau f = (Faisceau) faisceau;
            f.agencer(axeX, axeY * 0.01, 100, 0.01, true); // TODO il faut modifier axeX et lergeur
            axeX += 120;
        }

        texteNom.deplacer(donnees.centre().x(), donnees.centre().y() - donnees.hauteur() / 4 + 20);
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);

        // Groupe pour les légendes
        System.out.println(donnees.hauteur());
        legendeGroupe.empilerElements(Alignement.GAUCHE, donnees.centre().x() - legendeGroupe.largeur(), 10);
        legendeGroupe.alignerElements(Alignement.BAS, donnees.centre().y() + donnees.hauteur() / 4);
        diagGroupe.ajouter(legendeGroupe);

        return this;
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        donnees.ajouter(new Faisceau(str, doubles));
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
