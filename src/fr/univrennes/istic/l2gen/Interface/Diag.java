package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Diag {
    private JPanel panel;
    private Boolean[] isChecked;

    public Diag() {
        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Type de diagramme");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        panel.setBorder(border);

        ArrayList<String> tabDiag = new ArrayList<>();
        tabDiag.add("Créer un diagramme en camembert");
        tabDiag.add("Créer un diagramme en barre");
        tabDiag.add("Créer un diagramme en colonne");

        JCheckBox[] Checkbox = new JCheckBox[tabDiag.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new Boolean[tabDiag.size()];

        for (int i = 0; i < tabDiag.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabDiag.get(i));
            this.panel.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked[index] = true;
                        System.out.println("isChecked[" + index + "] = " + isChecked[index]); // TODO verif à enlever
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked[index] = false;
                        System.out.println("isUnchecked[" + index + "] = " + isChecked[index]); // TODO verif à enlever
                    }
                }
            });
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public Boolean[] getIsCheckedDiag() {
        return this.isChecked;
    }
}
