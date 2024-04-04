package fr.univrennes.istic.l2gen.rapport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Fonction {
    /**
     * Crée un fichier HTML contenant le contenu HTML et SVG spécifiés.
     * 
     * @param htmlContent   Le contenu HTML à inclure dans le fichier.
     * @param svgContent    Le contenu SVG à inclure dans le fichier.
     * @param htmlTitle     Le titre de la page HTML.
     * @param fileName      Le nom du fichier HTML à créer.
     */
    public static void createHTMLFile(String htmlContent, String svgContent, String htmlTitle, String fileName) {
        String htmlTemplate = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n"
                + "<meta charset=\"UTF-8\">\n" + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "<title>" + htmlTitle + "</title>\n" + "</head>\n" + "<body>\n" + htmlContent + "\n" + svgContent + "\n"
                + "</body>\n" + "</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".html"))) {
            writer.write(htmlTemplate);
            System.out.println("Fichier HTML créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier HTML : " + e.getMessage());
        }
    }
}
