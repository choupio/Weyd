package fr.univrennes.istic.l2gen.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

/**
 * Cette classe représente un message d'erreur.
 * Elle permet de gérer l'affichage d'un message d'erreur.
 */
public class MessageErreur {

    /**
     * Constructeur de la classe MessageErreur.
     * Ce constructeur initialise un message d'erreur.
     * Il crée une fenêtre avec un message d'erreur et un bouton pour fermer la
     * fenêtre.
     * 
     * @param messageErreur le message d'erreur à afficher
     */
    MessageErreur(String messageErreur) {
        CreationFenetre message = new CreationFenetre("Erreur");
        message.getFenetre().setSize(700, 225);
        // Calcule les coordonnées x et y pour centrer la fenêtre
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - message.getFenetre().getWidth()) / 2;
        int y = (screenSize.height - message.getFenetre().getHeight()) / 2;
        message.getFenetre().setLocation(x, y);
        // Créer un JPanel avec un BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        // Créer un autre JPanel avec FlowLayout pour centrer horizontalement le JLabel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Créer le JLabel avec du texte et utiliser HTML pour les retours à la ligne
        JLabel label = new JLabel(messageErreur, SwingConstants.CENTER);
        // Ajouter le JLabel au topPanel
        topPanel.add(label);
        // Ajouter le topPanel à la position nord du panel principal
        panel.add(topPanel, BorderLayout.NORTH);
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // bouton pour fermer la fenêtre
        JButton close = new JButton("Fermer");
        closePanel.setPreferredSize(new Dimension(200, 50));
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.getFenetre().dispose();
            }
        });
        closePanel.add(close);
        panel.add(closePanel, BorderLayout.SOUTH);

        // Ajouter le panel principal à la fenêtre
        message.getFenetre().add(panel);
    }
}
