package fr.univrennes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fr.univrennes.istic.l2gen.geometrie.IForme;

public class SVGFile {
    /**
     * 
     * @param forme     la forme a créer en svg
     * @param nomFigure le nom du fichier sans ".svg", ex : si nomFigure = "Cercle"
     *                  alors le fichier sera "Cercle.svg"
     */
    public static void createSvgFile(IForme forme, String nomFigure) {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFigure + ".svg"))) {
            writer.write(svgContent);
            writer.write(forme.enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }

    /**
     * 
     * @param forme     la forme a créer en svg
     * @param nomFigure le nom du fichier sans ".svg", ex : si nomFigure = "Cercle"
     *                  alors le fichier sera "Cercle.svg"
     */
    public static String contentSvgFile(IForme forme) {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\" ";
        svgContent += "viewBox=\"0 0 " + forme.largeur() + " " + forme.hauteur() + "\" >\n";
        svgContent += forme.enSVG();
        svgContent += "</svg>";
        return svgContent;
    }

}
