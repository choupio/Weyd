package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Diag {
    private JPanel panel;
    private static HashMap<String, Boolean> isChecked;

    public Diag() {
        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();

        String[] diagrammes = { "camembert", "barre","colonne" };
        JComboBox<String> choixdiagramme = new JComboBox<>(diagrammes);

        panel.add(choixdiagramme);
        choixdiagramme.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedChoice = (String) choixdiagramme.getSelectedItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (selectedChoice.equals("camembert")) {
                        //TODO
                    } else if (selectedChoice.equals("barre")) {
                        //TODO
                    }else if(selectedChoice.equals("colonne")){
                        //TODO
                    }

                }
            }
        });


        /* panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Type de diagramme");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        panel.setBorder(border);

        ArrayList<String> tabDiag = new ArrayList<>();
        tabDiag.add("Créer un diagramme en camembert");
        tabDiag.add("Créer un diagramme en barre");
        tabDiag.add("Créer un diagramme en colonne");

        JCheckBox[] Checkbox = new JCheckBox[tabDiag.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabDiag.size());

        for (int i = 0; i < tabDiag.size(); i += 1) {
            isChecked.put(tabDiag.get(i), false);
            Checkbox[i] = new JCheckBox(tabDiag.get(i));
            this.panel.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabDiag.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabDiag.get(index), false);
                    }
                }
            });
        } */

    }

    public JPanel getPanel() {
        return panel;
    }

    public static HashMap<String, Boolean> getIsCheckedDiag() {
        return isChecked;
    }
}
