package fr.univrennes.istic.l2gen.visustats;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Texte;

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
        groupeCamembert = new Groupe();
    }

    /**
     * Retourne le centre du groupe, calculé comme le centre moyen de toutes les
     * formes dans le diag.
     *
     * @return Le centre du diag.
     */
    @Override
    public Point centre() {
        return this.groupeCamembert.centre();
    }

    @Override
    public String description(int indentation) {
      return groupeCamembert.description(indentation);
    }  

    @Override
    public double hauteur() {
        return this.groupeCamembert.hauteur();
    }

    @Override
    public double largeur() {
        return this.groupeCamembert.largeur();
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        return this.groupeCamembert.deplacer(dx, dy);
    }

    @Override
    public IForme dupliquer() {
        return this.groupeCamembert.dupliquer();
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
        for (IForme forme : groupeCamembert.getListFormes()) {
            if (forme instanceof Camembert) {
                Camembert camembert = (Camembert) forme;
                for (int i = 0; i < camembert.getSecteurs().size(); i++) {
                    camembert.getSecteurs().get(i).setCouleur(couleurs[i % couleurs.length]);
                }
            }
        }
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

        double total = 0;
        for (double value : doubles) {
            total += value;
        }

        for (int i = 0; i < 3; i++) {
            Camembert camembert = new Camembert(new Point(256 + i * 250, 256), 100); 

            double sum = 0;
            for (double value : doubles) {
                sum += value / total;
            }

            for (int j = 0; j < 5; j++) {
                double proportion = (doubles[j % doubles.length] / total) / sum;
                
                camembert.ajouterSecteur(str + j, proportion);
            }
            groupeCamembert.ajouter(camembert);
        }

        return this;   
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
