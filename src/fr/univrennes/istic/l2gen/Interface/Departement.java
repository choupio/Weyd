package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Departement {
    private JPanel departements = new JPanel();
    private Boolean[] isChecked;

    public Departement() {
        departements.setLayout(new BoxLayout(departements, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Départements");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.departements.setBorder(border2);

        // Noms des départements en France
        ArrayList<String> tabDepart = Accueil.getRecup().getNomsDepartement();

        JCheckBox[] radioCheck = new JCheckBox[tabDepart.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new Boolean[tabDepart.size()];

        for (int i = 0; i < tabDepart.size(); i += 1) {
            radioCheck[i] = new JCheckBox(tabDepart.get(i));
            this.departements.add(radioCheck[i]);
            int index = i;
            radioCheck[i].addItemListener(new ItemListener() {
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

        this.departements.setSize(departements.getMinimumSize().width, departements.getMinimumSize().width);

    }

    public JPanel GetDept() {
        return this.departements;
    }

    public Boolean[] getIsCheckedDept() {
        return this.isChecked;
    }
}
