package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Statistique {
    private JPanel panel;
    private HashMap<String, Boolean> isChecked;

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
        tabStat.add("Nombre stations proposant d'autres services");

        JCheckBox[] Checkbox = new JCheckBox[tabStat.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new HashMap<String, Boolean>(tabStat.size());

        for (int i = 0; i < tabStat.size(); i += 1) {
            this.isChecked.put(tabStat.get(i), false);
            Checkbox[i] = new JCheckBox(tabStat.get(i));
            this.panel.add(Checkbox[i]);
            int index = i;
            if (tabStat.get(index) == "Prix minimum") { // la case "Prix minimum" débloque les localisations
                Checkbox[i].addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            isChecked.put(tabStat.get(index), true);
                            Onglet.getAfficheStation().setEnabled(true);
                        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                            isChecked.put(tabStat.get(index), false);
                            Onglet.getAfficheStation().setEnabled(false);
                        }
                    }
                });
            } else { // Autres cases
                Checkbox[i].addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            isChecked.put(tabStat.get(index), true);
                        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                            isChecked.put(tabStat.get(index), false);
                        }
                    }
                });
            }

        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public HashMap<String, Boolean> getIsCheckedStat() {
        return this.isChecked;
    }
}