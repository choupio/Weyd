package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class Diag {
    private JPanel panel;
    @SuppressWarnings("unchecked")
    private static JComboBox<String>[] choixdiagramme = new JComboBox[3];
    @SuppressWarnings("unchecked")
    private static HashMap<String, Boolean>[] isChecked = new HashMap[3];
    private static HashMap<String, Boolean> isCheckedPrixMoy;
    private static HashMap<String, Boolean> isCheckedPrixMed;
    private static HashMap<String, Boolean> isCheckedPrixMin;

    public Diag() {
        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        for (int i = 0; i < 3; i += 1) {
            String[] diagrammes;
            int index = i;
            if (i == 0) {
                diagrammes = new String[] { "Diag en camembert prix moyen", "Diag en barres prix moyen",
                        "Diag en colonne prix moyen" };
                JComboBox<String> choixdiagrammePrixMoy = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMoy = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMoy.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMoy;
                isChecked[i] = isCheckedPrixMoy;
            } else if (i == 1) {
                diagrammes = new String[] { "Diag en camembert prix médian", "Diag en barres prix médian",
                        "Diag en colonne prix médian" };
                JComboBox<String> choixdiagrammePrixMed = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMed = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMed.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMed;
                isChecked[i] = isCheckedPrixMed;
            } else {
                diagrammes = new String[] { "Diag en camembert prix minimum", "Diag en barres prix minimum",
                        "Diag en colonne prix minimum" };
                JComboBox<String> choixdiagrammePrixMin = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMin = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMin.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMin;
                isChecked[i] = isCheckedPrixMin;
            }

            // Initialisation des booléens à false
            for (String diag : diagrammes) {
                isChecked[i].put(diag, false);
            }

            // Gestion des événements
            choixdiagramme[index].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    String selectedChoice = (String) choixdiagramme[index].getSelectedItem();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        if (selectedChoice.equals(diagrammes[0])) {
                            isChecked[index].put(diagrammes[0], true);
                            isChecked[index].put(diagrammes[1], false);
                            isChecked[index].put(diagrammes[2], false);
                        } else if (selectedChoice.equals(diagrammes[1])) {
                            isChecked[index].put(diagrammes[0], false);
                            isChecked[index].put(diagrammes[1], true);
                            isChecked[index].put(diagrammes[2], false);
                        } else if (selectedChoice.equals(diagrammes[2])) {
                            isChecked[index].put(diagrammes[0], false);
                            isChecked[index].put(diagrammes[1], false);
                            isChecked[index].put(diagrammes[2], true);
                        }
                    }
                }
            });
            panel.add(choixdiagramme[i]);
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public static JComboBox<String>[] getDiag() {
        return choixdiagramme;
    }

    public static HashMap<String, Boolean>[] getIsCheckedDiag() {
        return isChecked;
    }
}
