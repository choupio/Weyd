package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau contenant des cases à cocher pour les
 * statistiques.
 */
public class Statistique {

    /**
     * Panneau pour les statistiques.
     */
    private JPanel panel;

    /**
     * HashMap pour stocker l'état de sélection des statistiques.
     */
    private static HashMap<String, Boolean> isChecked;

    /**
     * Constructeur de la classe Statistique.
     * Initialise le panneau avec des cases à cocher pour les statistiques.
     */
    public Statistique() {
        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Statistiques");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        panel.setBorder(border);

        ArrayList<String> tabStat = new ArrayList<>();
        tabStat.add("Prix moyen");
        tabStat.add("Prix médian");
        tabStat.add("Prix minimum");
        tabStat.add("Nombre de stations proposant ce carburant");
        tabStat.add("Nombre de stations proposant ces services");

        JCheckBox[] Checkbox = new JCheckBox[tabStat.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabStat.size());

        for (int i = 0; i < tabStat.size(); i += 1) {
            isChecked.put(tabStat.get(i), false);
            Checkbox[i] = new JCheckBox(tabStat.get(i));
            this.panel.add(Checkbox[i]);
            int index = i;
            if (tabStat.get(index).equals("Prix minimum")) { // débloque les localisations et le choix du diag
                Checkbox[i].addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            isChecked.put(tabStat.get(index), true);
                            Onglet.getAfficheStation().setEnabled(true);
                            Diag.getDiag()[2].setEnabled(true);
                        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                            isChecked.put(tabStat.get(index), false);
                            Onglet.getAfficheStation().setEnabled(false);
                            Diag.getDiag()[2].setEnabled(false);
                        }
                    }
                });
            } else { // choix
                Checkbox[i].addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            isChecked.put(tabStat.get(index), true);
                            if (tabStat.get(index) == "Prix moyen") {
                                Diag.getDiag()[0].setEnabled(true);
                            } else if (tabStat.get(index) == "Prix médian") {
                                Diag.getDiag()[1].setEnabled(true);
                            } else if (tabStat.get(index) == "Nombre de stations proposant ce carburant") {
                                Diag.getDiag()[3].setEnabled(true);
                            } else {
                                Diag.getDiag()[4].setEnabled(true);
                                Services.getTousServices().setEnabled(true);
                                for (int i = 0; i < Services.getRadioCheck().length; i += 1) {
                                    Services.getRadioCheck()[i].setEnabled(true);
                                }
                            }
                        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                            isChecked.put(tabStat.get(index), false);
                            if (tabStat.get(index) == "Prix moyen") {
                                Diag.getDiag()[0].setEnabled(false);
                            } else if (tabStat.get(index) == "Prix médian") {
                                Diag.getDiag()[1].setEnabled(false);
                            } else if (tabStat.get(index) == "Nombre de stations proposant ce carburant") {
                                Diag.getDiag()[3].setEnabled(false);
                            } else {
                                Diag.getDiag()[4].setEnabled(false);
                                Services.getTousServices().setEnabled(false);
                                for (int i = 0; i < Services.getRadioCheck().length; i += 1) {
                                    Services.getRadioCheck()[i].setEnabled(false);
                                }
                            }
                        }
                    }
                });
            }

        }
    }

    /**
     * Méthode pour récupérer le panneau des statistiques.
     * 
     * @return Le panneau des statistiques.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Méthode pour récupérer l'état de sélection des statistiques.
     * 
     * @return L'état de sélection des statistiques.
     */
    public static HashMap<String, Boolean> getIsCheckedStat() {
        return isChecked;
    }
}