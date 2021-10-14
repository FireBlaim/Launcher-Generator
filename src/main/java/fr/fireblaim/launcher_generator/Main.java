package fr.fireblaim.launcher_generator;

import javafx.application.Application;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("javafx.application.Application");
            Application.launch(App.class, args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Erreur : JavaFX n'est pas présent sur votre PC. Veuillez télécharger Java 11 sur le site d'Oracle.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}
