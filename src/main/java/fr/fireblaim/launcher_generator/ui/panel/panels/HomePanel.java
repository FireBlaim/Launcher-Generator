package fr.fireblaim.launcher_generator.ui.panel.panels;

import fr.fireblaim.launcher_generator.App;
import fr.fireblaim.launcher_generator.ui.PanelManager;
import fr.fireblaim.launcher_generator.ui.components.CButton;
import fr.fireblaim.launcher_generator.ui.components.CImageView;
import fr.fireblaim.launcher_generator.ui.components.CLabel;
import fr.fireblaim.launcher_generator.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class HomePanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        CLabel title = new CLabel("Bienvenue sur Launcher Generator v" + App.VERSION + " !");
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setValignment(title, VPos.TOP);
        title.setTranslateY(10D);
        title.setFontSize(28D, true);
        layout.getChildren().add(title);

        CLabel description = new CLabel("Grâce à ce logiciel vous allez pouvoir créer facilement votre launcher sans coder !");
        GridPane.setHalignment(description, HPos.CENTER);
        GridPane.setValignment(description, VPos.CENTER);
        description.setWrapText(true);
        description.setFontSize(16D, false);
        description.setStyle(description.getStyle() + "-fx-padding: 15px;");
        layout.getChildren().add(description);

        CLabel description2 = new CLabel("Actuellement, cet outil est encore en bêta donc si vous avez des bugs : allez sur mon GitHub !");
        GridPane.setHalignment(description2, HPos.CENTER);
        GridPane.setValignment(description2, VPos.CENTER);
        description2.setWrapText(true);
        description2.setTranslateY(20D);
        description2.setFontSize(16D, false);
        description2.setStyle(description2.getStyle() + "-fx-padding: 15px;");
        layout.getChildren().add(description2);

        CImageView github = new CImageView("/images/github.png");
        GridPane.setHalignment(github, HPos.LEFT);
        GridPane.setValignment(github, VPos.TOP);
        github.setTranslateX(10);
        github.setTranslateY(10);
        github.setSize(64, 64);
        github.setOnMouseClicked(event -> {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Desktop.getDesktop().browse(new URL("https://github.com/FireBlaim/Launcher-Generator/").toURI());
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });
        layout.getChildren().add(github);

        CButton next = new CButton("Démarrer");
        GridPane.setHalignment(next, HPos.CENTER);
        GridPane.setValignment(next, VPos.BOTTOM);
        next.setTranslateY(-20D);
        next.setSize(120, 40);
        next.setFontSize(14D, false);
        next.setOnMouseClicked(event -> {
            panelManager.switchPanel(new PreparationPanel());
        });
        layout.getChildren().add(next);
    }

    @Override
    public String getName() {
        return "Home Panel";
    }
}
