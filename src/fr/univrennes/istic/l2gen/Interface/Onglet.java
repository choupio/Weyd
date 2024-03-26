package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Onglet {
    private JTabbedPane onglets;
    private JPanel panelOnglet=new JPanel();


    public Onglet(String titreOnglet1,String titreOnglet2,int WIDTH,int HEIGTH){
        onglets = new JTabbedPane(SwingConstants.TOP);

        String[] Granularite={"Région","Departement"};
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite);
        JButton button = new JButton("Rapport");
        JLabel jLabel = new JLabel("Granularité");

        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        onglets.addTab(titreOnglet1, onglet1);

        JPanel onglet2 = new JPanel();
        JPanel onglet21 = new JPanel();
        onglet21.setLayout(new FlowLayout(FlowLayout.LEFT));
        onglet21.setSize(onglet2.getWidth()*(25/100), onglet2.getHeight());
        onglet21.add(jLabel);
        onglet21.add(choixGranuralite);
        onglet21.add(new JSeparator(),BorderLayout.WEST);
        onglet21.add(button,BorderLayout.WEST);

        JPanel Region = new JPanel();
        if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals("Région")){
            Region.setVisible(true);
        }else Region.setVisible(false);

        

        JPanel Departement=new JPanel();
        if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals("Departement")){
            Departement.setVisible(true);
        }else Departement.setVisible(false);

        onglet2.setPreferredSize(new Dimension(WIDTH,HEIGTH));
        onglet2.add(onglet21,BorderLayout.WEST);
        onglets.addTab(titreOnglet2, onglet2);

        panelOnglet.add(onglets);
    }

    public JPanel GetPanel(){
        return panelOnglet;
    }

    

        
    
}
