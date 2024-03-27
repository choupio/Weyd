package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Texte;

public class DiagBarres implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    List<String> legendes, couleurs;
    Groupe donnees, legendeGroupe, diagGroupe;
    double echelle_max;

    public DiagBarres(String nom) {
        this.nom = nom;
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
        echelle_max = 0;
    }

    @Override
    public Point centre() {
        return diagGroupe.centre();
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
        return diagGroupe.tourner(angle);
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        return diagGroupe.aligner(alignement, cible);
    }

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "DiagBarres");
    }

    @Override
    public IDataVisualiseur agencer() {
        // Titre
        texteNom = new Texte(0, 0, 20, nom);
        double axeY = 0;
        for (IForme donnee : donnees.getListFormes()) {
            Faisceau faisceau = (Faisceau) donnee;
            double hauteur = 0;
            for (IForme barre : faisceau.getListFormes()) {
                hauteur += barre.hauteur() * 0.01;
            }
            if (axeY < hauteur) {
                axeY = hauteur;
            }

        }
        double axeX = 50;

        for (IForme faisceau : donnees.getListFormes()) {
            Faisceau f = (Faisceau) faisceau;
            f.agencer(axeX, axeY + texteNom.hauteur() * 2, 100, 0.01, true);
            axeX += 120;
        }
        texteNom.deplacer(donnees.centre().x(),
                donnees.centre().y() - donnees.hauteur() / 2 - texteNom.hauteur());
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);

        // Groupe pour les légendes
        legendeGroupe.empilerElements(Alignement.GAUCHE, donnees.centre().x() - legendeGroupe.largeur(), 10);
        legendeGroupe.alignerElements(Alignement.BAS,
                donnees.centre().y() + donnees.hauteur() / 2 + legendeGroupe.hauteur() * 2);
        diagGroupe.ajouter(legendeGroupe);

        // Echelle
        // Barre horizontale
        diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2,
                donnees.centre().x() + donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2));
        // Barre verticale
        diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() - donnees.hauteur() / 2,
                donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2));
        // Valeurs
        int tailleTxtLegende = 10;
        for (int i = 0; i <= 5; i++) {
            diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2 - 5,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5,
                    donnees.centre().x() - donnees.largeur() / 2 + 5,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5));
            Texte valeurTxt = new Texte(0, 0, tailleTxtLegende,
                    Integer.toString((int) Math.round(echelle_max * (5 - i) / 5)));
            valeurTxt.deplacer(
                    donnees.centre().x() - donnees.largeur() / 2 - 5 - valeurTxt.largeur() / 2,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5);
            diagGroupe.ajouter(valeurTxt);
        }

        return this;
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        donnees.ajouter(new Faisceau(str, doubles));
        double d_max = doubles[0];
        for (double d : doubles) {
            if (d > d_max) {
                d_max = d;
            }
        }
        if (d_max > echelle_max) {
            echelle_max = d_max;
        }
        return this;
    }

    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
            legendeGroupe.ajouter(new Texte(0, 0, 15, string));
        }

        return this;
    }

    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}
