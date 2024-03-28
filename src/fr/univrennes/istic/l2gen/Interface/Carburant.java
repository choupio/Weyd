package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Carburant {
    private JPanel carburant=new JPanel();

    public Carburant(){
        Border border = BorderFactory.createTitledBorder("Carburant");
        this.carburant.setBorder(border);

        ArrayList<String> tabcarburant =Accueil.getRecup().getNomsCarburants();

        JCheckBox[] Checkbox = new JCheckBox[tabcarburant.size()];

         for (int i = 0; i < tabcarburant.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabcarburant.get(i));
            this.carburant.add(Checkbox[i]);
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
    public JPanel Getcarburant() {
        return this.carburant;
    }
    
    
}
