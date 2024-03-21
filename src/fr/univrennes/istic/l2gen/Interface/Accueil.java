package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import java.awt.*;

public class Accueil {
    public Accueil() {
        ///////// Création de la fenêtre /////////
        CreationFenetre fenetre = new CreationFenetre("LES COURS DU CARBURANT EN FRANCE");
        //MenuSwing menu = new MenuSwing(fenetre);
        // ImageSwing photoAccueil = new ImageSwing(fenetre.getFenetre(),
        // "ImageTest.png", "Une image de test");

        ///////// Taille de la fenêtre /////////
        // On récupère la taille de l'écran
        GraphicsEnvironment tailleEcran = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // On créer le rectangle de la bonne taille
        Rectangle tailleUtilisable = tailleEcran.getMaximumWindowBounds();
        fenetre.getFenetre().setSize((int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());
    }
}
