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
        "  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');\n" +
        "  body {\n" +
        "    background-color: #f0f0f0;\n" +
        "    font-family: 'Roboto', sans-serif;\n" +
        "    display: flex;\n" +
        "    justify-content: center;\n" +
        "    align-items: center;\n" +
        "    height: 100vh;\n" +
        "    margin: 0;\n" +
        "    padding: 0;\n" +
        "  }\n" +
        "  .container {\n" +
        "    text-align: center;\n" +
        "  }\n" +
        "  svg {\n" +
        "    display: block;\n" +
        "    margin: auto;\n" +
        "    width: 90%;\n" +
        "    height: 90%;\n" +
        "    border: 1px solid #ccc;\n" +
        "    opacity: 0;\n" +
        "    animation: fadeIn 2s ease-in forwards;\n" +
        "  }\n" +
        "  @keyframes fadeIn {\n" +
        "    to {\n" +
        "      opacity: 1;\n" +
        "    }\n" +
        "  }\n" +
        "</style>\n" +
        "</head>\n" + 
        "<body>\n"+
        "<div class=\"container\">\n"+
        "<svg viewBox=\"0 0 2000 10000\">\n"+
        svgContent +
        "\n</svg>\n</div>\n</body>\n" +
        "</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".html"))) {
            writer.write(htmlTemplate);
            System.out.println("Fichier HTML créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier HTML : " + e.getMessage());
        }
    }
}
