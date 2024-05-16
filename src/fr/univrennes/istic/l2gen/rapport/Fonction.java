package fr.univrennes.istic.l2gen.rapport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Fonction {
    /**
     * Crée un fichier HTML contenant le contenu SVG spécifié.
     * 
     * @param svgFilePath Le chemin vers le fichier SVG à inclure dans le fichier
     *                    HTML.
     * @param htmlTitle   Le titre de la page HTML.
     * @param fileName    Le nom du fichier HTML à créer.
     */
    public static void createHTMLFile(String svgFilePath, String htmlTitle, String fileName) {
        String svgContent = "";

        try {
            // Lecture du contenu du fichier SVG
            svgContent = new String(Files.readAllBytes(Paths.get(svgFilePath)));
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier SVG : " + e.getMessage());
        }

        String htmlTemplate = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "<title>" + htmlTitle + "</title>\n" + "</head>\n" + "<body style=\"margin: 0;\">\n"
                + "<svg style=\"width: 90%; height: 90%;\" viewBox=\"0 0 2000 10000\">\n"
                + svgContent + "\n</svg>\n</body>\n" + "</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".html"))) {
            writer.write(htmlTemplate);
            System.out.println("Fichier HTML créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier HTML : " + e.getMessage());
        }
    }
}
