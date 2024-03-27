package fr.univrennes.istic.l2gen.Interface;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class region {
    private JPanel Region = new JPanel();

    public region(){
        Border border = BorderFactory.createTitledBorder("région");
        Region.setBorder(border);

        ButtonGroup groupregion = new ButtonGroup();
        JRadioButton radioregion1 = new JRadioButton("Auvergne-Rhône-Alpes");
        JRadioButton radioregion2 = new JRadioButton("Nouvelle-Aquitaine");
        JRadioButton radioregion3 = new JRadioButton("Occitanie");
        JRadioButton radioregion4 = new JRadioButton("Île-de-France");
        JRadioButton radioregion5 = new JRadioButton("Grand Est");
        JRadioButton radioregion6 = new JRadioButton("Hauts-de-France");
        JRadioButton radioregion7 = new JRadioButton("Provence-Alpes-Côte d'Azur");
        JRadioButton radioregion8 = new JRadioButton("Bourgogne-Franche-Comté");
        JRadioButton radioregion9 = new JRadioButton("Normandie");
        JRadioButton radioregion10 = new JRadioButton("Bretagne");
        JRadioButton radioregion11 = new JRadioButton("Pays de la Loire");
        JRadioButton radioregion12 = new JRadioButton("Centre-Val de Loire");
        JRadioButton radioregion13 = new JRadioButton("Corse");

        groupregion.add(radioregion1);
        groupregion.add(radioregion2);
        groupregion.add(radioregion3);
        groupregion.add(radioregion4);
        groupregion.add(radioregion5);
        groupregion.add(radioregion6);
        groupregion.add(radioregion7);
        groupregion.add(radioregion8);
        groupregion.add(radioregion9);
        groupregion.add(radioregion10);
        groupregion.add(radioregion11);
        groupregion.add(radioregion12);
        groupregion.add(radioregion13);


        Region.add(radioregion1);
        Region.add(radioregion2);
        Region.add(radioregion3);
        Region.add(radioregion4);
        Region.add(radioregion5);
        Region.add(radioregion6);
        Region.add(radioregion7);
        Region.add(radioregion8);
        Region.add(radioregion9);
        Region.add(radioregion10);
        Region.add(radioregion11);
        Region.add(radioregion12);
        Region.add(radioregion13);

    }

    public JPanel GetRegion(){
        return Region;
    }

    
}
