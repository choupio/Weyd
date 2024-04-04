package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Region {
    private JPanel region = new JPanel();
    private Boolean[] isChecked;

    public Region() {
        region.setLayout(new BoxLayout(region, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Régions");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.region.setBorder(border);

        ArrayList<String> tabRegion = Accueil.getRecup().getNomsRegion();

        JCheckBox[] Checkbox = new JCheckBox[tabRegion.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new Boolean[tabRegion.size()];

        for (int i = 0; i < tabRegion.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabRegion.get(i));
            this.region.add(Checkbox[i]);
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

    public JPanel GetRegion() {
        return this.region;
    }

    public Boolean[] getIsCheckedReg() {
        return this.isChecked;
    }
}
