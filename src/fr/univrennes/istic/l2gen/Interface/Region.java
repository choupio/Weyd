package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import fr.univrennes.istic.l2gen.station.StationAPI;

public class Region {
    private JPanel region = new JPanel();

    public Region() {
        Border border = BorderFactory.createTitledBorder("région");
        this.region.setBorder(border);

        StationAPI recup = new StationAPI();

        ArrayList<String> tabRegion = recup.getNomsRegion();

        ButtonGroup groupregion = new ButtonGroup();
        JCheckBox[] Checkbox = new JCheckBox[tabRegion.length];

        for (int i = 0; i < tabRegion.length; i += 1) {
            Checkbox[i] = new JCheckBox(tabRegion[i]);
            groupregion.add(Checkbox[i]);
            this.region.add(Checkbox[i]);
        }

    }

    public JPanel GetRegion() {
        return this.region;
    }

}
