package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Region {
    private JPanel region = new JPanel();
    

    public Region() {
        region.setLayout(new BoxLayout(region, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createTitledBorder("région");
        this.region.setBorder(border);

        ArrayList<String> tabRegion = Accueil.getRecup().getNomsRegion();

        JCheckBox[] Checkbox = new JCheckBox[tabRegion.size()];

        for (int i = 0; i < tabRegion.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabRegion.get(i));
            this.region.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println("CheckBox" + index + "checked");
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        System.out.println("CheckBox" + index + " unchecked");
                    }
                }
            });
        }

    }

    public JPanel GetRegion() {
        return this.region;
    }

}
