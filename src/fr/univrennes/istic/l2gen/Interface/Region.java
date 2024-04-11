package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Region {
    private JPanel region = new JPanel();
    private HashMap<String, Boolean> isChecked;

    public Region() {
        region.setLayout(new BoxLayout(region, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Régions");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.region.setBorder(border);

        JCheckBox tous=new JCheckBox("Toutes les régions");
        region.add(tous);

        ArrayList<String> tabRegion = Accueil.getRecup().getNomsRegion();

        JCheckBox[] Checkbox = new JCheckBox[tabRegion.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new HashMap<String, Boolean>(tabRegion.size());

        for (int i = 0; i < tabRegion.size(); i += 1) {
            this.isChecked.put(tabRegion.get(i), false);
            Checkbox[i] = new JCheckBox(tabRegion.get(i));
            this.region.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabRegion.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabRegion.get(index), false);
                    }
                }
            });
        }

        tous.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED){
                    for(int i=0;i<tabRegion.size();i+=1){
                        Checkbox[i].setSelected(true);
                    }
                }else if(e.getStateChange() == ItemEvent.DESELECTED){
                    for(int i=0;i<tabRegion.size();i+=1){
                        Checkbox[i].setSelected(false);
                    }
        
                }
            }
        });


    }

    public JPanel GetRegion() {
        return this.region;
    }

    public HashMap<String, Boolean> getIsCheckedReg() {
        return this.isChecked;
    }
}
