package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import javax.swing.border.Border;

public class Departement {
    private JPanel departements = new JPanel();

    public Departement() {
        Border border2 = BorderFactory.createTitledBorder("Departement");
        this.departements.setBorder(border2);

        // Noms des départements en France
        String[] tabDepart = { "Bouches-du-Rhône", "Nord", "Pas-de-Calais", "Gironde", "Rhône", "Haute-Garonne",
                "Isère", "Bourgogne-Franche-Comté", "Loire-Atlantique", "Seine-et-Marne", "Var", "Seine-Maritime",
                "Hérault", "Finistère", "Bas-Rhin", "Ille-et-Vilaine", "Yvelines", "Morbihan", "Saône-et-Loire",
                "Alpes-Maritimes", "Gard", "Moselle", "Essonne", "Loire", "Calvados", "Côte-d'Or", "Haute-Savoie",
                "Puy-de-Dôme", "Côtes-d'Armor", "Ain", "Vendée", "Charente-Maritime", "Manche", "Oise",
                "Pyrénées-Atlantiques", "Drôme", "Haut-Rhin", "Val-d'Oise", "Somme", "Loiret", "Vaucluse", "Landes",
                "Maine-et-Loire", "Doubs", "Sarthe", "Maurthe-et-Moselle", "Eure", "Dordogne", "Indre-et-Loire",
                "Savoie", "Aisne", "Marne", "Aveyron", "Yonne", "Aude", "Seine-Saint-Denis", "Haute-Vienne", "Vosges",
                "Val-de-Marne", "Lot-et-Garonne", "Allier", "Hauts-de-Seine", "Jura", "Tarn", "Eure-et-Loir", "Vienne",
                "Pyrénées-Orientales", "Ardèche", "Deux-Sèvres", "Haute-Corse", "Aube", "Charente", "Tarn-et-Garonne",
                "Loir-et-Cher", "Cher", "Corrèze", "Nièvre", "Haute-Saône", "Orne", "Lot", "Cantal", "Corse-du-Sude",
                "Alpes-de-Haute-Provence", "Paris", "Mayenne", "Haute-Marne", "Haute-Loire", "Gers", "Hautes-Alpes",
                "Ardennes", "Hautes-Pyrénées", "Indre", "Meuse", "Lozère", "Ariège", "Creuse",
                "Territoire de Belfort" };

        ButtonGroup groupdept = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[tabDepart.length];

        for (int i = 0; i < tabDepart.length; i += 1) {
            radioButtons[i] = new JRadioButton(tabDepart[i]);
            groupdept.add(radioButtons[i]);
            this.departements.add(radioButtons[i]);
        }
    }

    public JPanel GetDept() {
        return this.departements;
    }

}
