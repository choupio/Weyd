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
        JRadioButton[] radioButtons = new JRadioButton[tabRegion.size()];

        for (int i = 0; i < tabRegion.size(); i += 1) {
            radioButtons[i] = new JRadioButton(tabRegion.get(i));
            groupregion.add(radioButtons[i]);
            this.region.add(radioButtons[i]);
        }

    }

    public JPanel GetRegion() {
        return this.region;
    }

}
