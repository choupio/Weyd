package fr.univrennes.istic.l2gen.visustats;

import java.util.List;
import java.util.ArrayList;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;

public class Faisceau extends Groupe {
    private String nom;
    private String couleur = "red";
    private Point axes = new Point(0, 0);
    private double largeur = 1;

    /**
     * Retourne la couleur du faisceau.
     *
     * @return La couleur du faisceau.
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Retourne le nom du faisceau.
     *
     * @return Le nom du faisceau.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la liste des rectangles du faisceau.
     *
     * @return La liste des rectangles du faisceau.
     */
    public List<IForme> getListFormes() {
        return listFormes;
    }

    /**
     * Constructeur de la classe Faisceau.
     *
     * @param nom Le nom du faisceau.
     * @param h   Un tableau de hauteurs pour créer les rectangles du faisceau.
     */
    public Faisceau(String nom, double... h) {
        this.nom = nom;
        this.listFormes = new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            Rectangle r = new Rectangle(axes.x(), axes.y(), largeur, h[i]);
            this.listFormes.add(r);
        }
    }

    /**
     * Constructeur de copie de la classe Faisceau.
     *
     * @param faisceau Le faisceau à copier.
     */
    public Faisceau(Faisceau faisceau) {
        this.nom = faisceau.nom;
        this.listFormes = new ArrayList<>();
        for (IForme rect : faisceau.listFormes) {
            this.listFormes.add(rect); // Réutilise le même objet Rectangle sans créer une nouvelle copie
        }
    }

    /**
     * Agence les rectangles du faisceau en fonction des paramètres spécifiés.
     *
     * @param axeX          La coordonnée x du point de départ.
     * @param axeY          La coordonnée y du point de départ.
     * @param largeur       La largeur totale du faisceau
     * @param hauteur       La hauteur des rectangles.
     * @param verticalement Indique si les rectangles doivent être alignés
     *                      verticalement (true) ou horizontalement (false).
     */
    public void agencer(double axeX, double axeY, double largeur, double echelle, boolean verticalement) {
        axes.setX(axeX);
        axes.setY(axeY);
        this.largeur = largeur;
        if (largeur <= 0 || echelle <= 0 || axeX < 0 || axeY < 0) {
            throw new IllegalArgumentException("Les coordonée, l'echelle et la largeur ne peuvent pas être négatif.");
        } else if (verticalement) {
            for (IForme rect : listFormes) {
                rect.redimmensioner(echelle, largeur);
            }
            this.empilerElements(Alignement.BAS, axeY, 0);
            this.alignerElements(Alignement.GAUCHE, axeX);
        } else {
            for (IForme rect : listFormes) {
                rect.redimmensioner(echelle, (largeur - 10.0 * listFormes.size()) / listFormes.size());
            }
            this.empilerElements(Alignement.GAUCHE, axeX, 10); // pas sur de si il faut 10
            this.alignerElements(Alignement.BAS, axeY);
        }
    }

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "Faisceau");
    }

    /**
     * Duplique le faisceau.
     *
     * @return Un nouveau faisceau contenant des copies des rectangles du faisceau
     *         actuel.
     */
    @Override
    public IForme dupliquer() {
        Faisceau faisceau = new Faisceau(this);
        return faisceau;
    }

}