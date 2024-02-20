package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Polygone implements IForme {

    private List<Point> points;
    private String couleur;

    {
        couleur = "white";
    }

    public Polygone(double... d) {
        this.points = new ArrayList<>();
        for (int i = 1; i < d.length; i += 2) {
            points.add(new Point(d[i - 1], d[i]));
        }
    }

    public IForme ajouterSommet(Point point) {
        points.add(new Point(point.x(), point.y()));
        return this;
    }

    public IForme ajouterSommet(double d1, double d2) {
        points.add(new Point(d1, d2));
        return this;
    }

    @Override
    public Point centre() {
        // TODO revoir ça
        double x = 0, y = 0;
        for (Point point : points) {
            x += point.x();
            y += point.y();
        }
        return new Point(x / points.size(), y / points.size());
    }

    @Override
    public String description(int entier) {
        String cran = "";
        for (int i = 0; i < entier; i += 1) {
            cran += "  ";
        }

        String s = cran + "Polygone ";
        for (Point point : points) {
            s += point.x() + "," + point.y() + " ";
        }
        s = s.substring(0, s.length() - 1); // supprime le dernier caractere
        return s;
    }

    @Override
    public double hauteur() {
        Point mini = points.get(0), max = points.get(0);
        for (Point point : points) {
            if (point.y() < mini.y()) {
                mini = point;
            }
            if (point.y() > max.y()) {
                max = point;
            }
        }
        return max.y() - mini.y();
    }

    public List<Point> getSommets() {
        return points;
    }

    @Override
    public double largeur() {
        Point mini = points.get(0), max = points.get(0);
        for (Point point : points) {
            if (point.x() < mini.x()) {
                mini = point;
            }
            if (point.x() > max.x()) {
                max = point;
            }
        }
        return max.x() - mini.x();
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        for (int i = 0; i < points.size(); i++) {
            Point point = points.remove(i);
            points.add(i, new Point(dx + point.x(), dy + point.y()));
        }
        return this;
    }

    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Polygone nouvelleForme = new Polygone();
        for (Point point : points) {
            nouvelleForme.ajouterSommet(point);
        }
        nouvelleForme.couleur = this.couleur; // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        Point centre = this.centre();
        for (int i = 0; i < points.size(); i++) {
            Point point = points.remove(i);
            // double distance = Math.sqrt(Math.pow(centre.x() - point.x(), 2) +
            // Math.pow(centre.y() - point.y(), 2));
            double distanceX = centre.x() - point.x();
            double distanceY = centre.y() - point.y();
            points.add(i, new Point(centre.x() - distanceX * h, centre.y() - distanceY * l));
        }
        return this;
    }

    @Override
    public String enSVG() {
        String s = "<polygon points=\"";
        for (Point point : points) {
            s += point.x() + " " + point.y() + " ";
        }
        s = s.substring(0, s.length() - 1); // supprime le dernier caractere
        s += "\" fill=\"" + couleur + "\" stroke=\"black\"/>";
        return s;
    }

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Polygone.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

}
