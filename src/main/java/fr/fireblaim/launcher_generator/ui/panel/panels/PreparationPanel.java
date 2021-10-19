package fr.fireblaim.launcher_generator.ui.panel.panels;

import fr.fireblaim.launcher_generator.ui.PanelManager;
import fr.fireblaim.launcher_generator.ui.components.CButton;
import fr.fireblaim.launcher_generator.ui.components.CLabel;
import fr.fireblaim.launcher_generator.ui.components.CTextField;
import fr.fireblaim.launcher_generator.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;

public class PreparationPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        CLabel title = new CLabel("Préparation");
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setValignment(title, VPos.TOP);
        title.setTranslateY(10D);
        title.setFontSize(28D, true);
        layout.getChildren().add(title);

        CLabel description = new CLabel("Toutes les informations des formulaires sont à remplir ! Vous devez créer un répertoire pour le création du launcher.");
        GridPane.setHalignment(description, HPos.CENTER);
        GridPane.setValignment(description, VPos.TOP);
        description.setTranslateY(50D);
        description.setFontSize(16D, false);
        layout.getChildren().add(description);

        CTextField launcherDirField = new CTextField();
        GridPane.setHalignment(launcherDirField, HPos.CENTER);
        GridPane.setValignment(launcherDirField, VPos.CENTER);
        launcherDirField.setTranslateX(-50D);
        launcherDirField.setTranslateY(-20D);
        launcherDirField.setSize(300, 40);
        launcherDirField.setFontSize(14D, false);
        layout.getChildren().add(launcherDirField);

        CLabel launcherDirLabel = new CLabel("Répertoire de travail pour le launcher");
        GridPane.setHalignment(launcherDirLabel, HPos.CENTER);
        GridPane.setValignment(launcherDirLabel, VPos.CENTER);
        launcherDirLabel.setLabelFor(launcherDirField);
        launcherDirLabel.setTranslateX(-70D);
        launcherDirLabel.setTranslateY(-50D);
        launcherDirLabel.setFontSize(16D, false);
        layout.getChildren().add(launcherDirLabel);

        CButton launcherDirChooser = new CButton("...");
        GridPane.setHalignment(launcherDirChooser, HPos.CENTER);
        GridPane.setValignment(launcherDirChooser, VPos.CENTER);
        launcherDirChooser.setTranslateX(130D);
        launcherDirChooser.setTranslateY(-20D);
        launcherDirChooser.setOnMouseClicked(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedFolder = directoryChooser.showDialog(panelManager.getStage());

            if(selectedFolder != null) {
                launcherDirField.setText(selectedFolder.getAbsolutePath() + "/");
            }
        });
        layout.getChildren().add(launcherDirChooser);

        CTextField launcherNameField = new CTextField();
        GridPane.setHalignment(launcherNameField, HPos.CENTER);
        GridPane.setValignment(launcherNameField, VPos.CENTER);
        launcherNameField.setTranslateX(-28D);
        launcherNameField.setTranslateY(70D);
        launcherNameField.setSize(350, 40);
        launcherNameField.setFontSize(14D, false);
        layout.getChildren().add(launcherNameField);

        CLabel launcherNameLabel = new CLabel("Nom du launcher");
        GridPane.setHalignment(launcherNameLabel, HPos.CENTER);
        GridPane.setValignment(launcherNameLabel, VPos.CENTER);
        launcherNameLabel.setLabelFor(launcherNameField);
        launcherNameLabel.setTranslateX(-145D);
        launcherNameLabel.setTranslateY(40D);
        launcherNameLabel.setFontSize(16D, false);
        layout.getChildren().add(launcherNameLabel);

        CButton next = new CButton("Démarrer");
        GridPane.setHalignment(next, HPos.CENTER);
        GridPane.setValignment(next, VPos.BOTTOM);
        next.setTranslateY(-20D);
        next.setSize(120, 40);
        next.setFontSize(14D, false);
        next.setOnMouseClicked(event -> {
            try {
                app.getFileManager().createFolder(launcherDirField.getText(), launcherNameField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        layout.getChildren().add(next);
    }

    @Override
    public String getName() {
        return "Preparation Panel";
    }
}
