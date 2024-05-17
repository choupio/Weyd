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

        String htmlTemplate = "<!DOCTYPE html>\n" + 
            "<html lang=\"en\">\n" + 
            "<head>\n"+
            "<meta charset=\"UTF-8\">\n"+
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"+
            "<title>" + htmlTitle + "</title>\n" + 
            "<style>\n" +
            "  body {\n" +
            "    background-color: #f0f0f0;\n" +
            "    font-family: Arial, sans-serif;\n" +
            "  }\n" +
            "  svg {\n" +
            "    display: block;\n" +
            "    margin: 0;\n" +
            "    width:  120%;\n" +
            "    height: 100%;\n" +
            "    background-color: white; \n" +
            "  }\n" +
            "  form {\n" +
            "    display: flex;\n" +
            "    flex-direction: column;\n" +
            "    width: 300px;\n" +
            "    margin: auto;\n" +
            "  }\n" +
            "  input, textarea {\n" +
            "    margin-bottom: 10px;\n" +
            "  }\n" +
            "</style>\n" +
            "</head>\n" + 
            "<body>\n"+
            "<svg id=\"mysvg\" viewBox=\"0 0 2000 10000\">\n"+
            svgContent +
            "\n</svg>\n"+
            "</body>\n" +
            "</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".html"))) {
            writer.write(htmlTemplate);
            System.out.println("Fichier HTML créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier HTML : " + e.getMessage());
        }
    }
}
