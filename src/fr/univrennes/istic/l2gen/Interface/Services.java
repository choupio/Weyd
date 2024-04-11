package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Services {
    private JPanel services = new JPanel();
    private static HashMap<String, Boolean> isChecked;

    public Services() {
        services.setLayout(new BoxLayout(services, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Services proposés");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.services.setBorder(border2);

        JCheckBox tousServices=new JCheckBox("Tout les services");
        services.add(tousServices);

        // Noms des départements en France
        ArrayList<String> tabServ = Accueil.getRecup().getNomsServices();

        JCheckBox[] radioCheck = new JCheckBox[tabServ.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabServ.size());

        for (int i = 0; i < tabServ.size(); i += 1) {
            isChecked.put(tabServ.get(i), false);
            radioCheck[i] = new JCheckBox(tabServ.get(i));
            this.services.add(radioCheck[i]);
            int index = i;
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabServ.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabServ.get(index), false);
                    }
                }
            });
        }

        tousServices.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    for(int i=0;i<tabServ.size();i++){
                        radioCheck[i].setSelected(true);
                    }
                }else if (e.getStateChange()==ItemEvent.DESELECTED) {
                    for(int i=0;i<tabServ.size();i++){
                        radioCheck[i].setSelected(false);
                    }
                }
            }
        });

        this.services.setSize(services.getMinimumSize().width, services.getMinimumSize().width);

    }

    public JPanel getPanel() {
        return this.services;
    }

    public static HashMap<String, Boolean> getIsCheckedServ() {
        return isChecked;
    }
}
