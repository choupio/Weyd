package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Onglet {
    private JTabbedPane onglets;
    private JPanel panelOnglet = new JPanel();

    public Onglet(String titreOnglet1, String titreOnglet2, int WIDTH, int HEIGTH) {
        onglets = new JTabbedPane(SwingConstants.TOP);
        
        String[] Granularite = { "Région", "Département" };
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite);
        JButton button = new JButton("Rapport");
        JLabel jLabel = new JLabel("Granularité");

        choixGranuralite.setSize(choixGranuralite.getWidth(), choixGranuralite.getMinimumSize().height);

        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        onglets.addTab(titreOnglet1, onglet1);

        JPanel onglet2 = new JPanel();

        onglet2.setLayout(new BoxLayout(onglet2, BoxLayout.Y_AXIS));
        JPanel onglet21=new JPanel();

        onglet21.setSize(onglet21.getWidth(),choixGranuralite.getMinimumSize().height);

        JCheckBox prix_moyen=new JCheckBox("prix moyen");
        JCheckBox prix_Median=new JCheckBox("Prix médian");
        JCheckBox prix_min=new JCheckBox("Prix minimal");
        JCheckBox nombre_station_carburant=new JCheckBox("Nombre Station carburant");
        JCheckBox nombre_station_services=new JCheckBox("Nombre Station services");

        onglet21.add(jLabel);
        onglet21.add(choixGranuralite);
        onglet21.add(button);

        onglet2.add(onglet21);

        Region Region = new Region();
        JPanel region = Region.GetRegion();
        Departement Departement = new Departement();
        JPanel dept = Departement.GetDept();
        Carburant carb=new Carburant();
        JPanel carburant = carb.Getcarburant();

        choixGranuralite.addItemListener(new ItemListener(){
            boolean panelVisible = false;
            public void itemStateChanged(ItemEvent e) {
                String selectedChoice = (String) choixGranuralite.getSelectedItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (selectedChoice.equals("Département")) {
                        dept.setVisible(!panelVisible);
                        panelVisible = !panelVisible;
                    }
                }
            }
        });
        /*else{
            dept.setVisible(false);
            region.setVisible(false);
        }*/
         
        
        onglet2.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        // onglet2.add(onglet21,BorderLayout.WEST);
        onglets.addTab(titreOnglet2, onglet2);
        onglet2.add(carburant);
        onglet2.add(region);
        
        
        onglet2.add(dept);

        panelOnglet.add(onglets);

    }

    public JPanel GetPanel() {
        return panelOnglet;
    }

}
