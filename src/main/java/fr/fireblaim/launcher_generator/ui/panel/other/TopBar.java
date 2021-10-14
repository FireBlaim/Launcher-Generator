package fr.fireblaim.launcher_generator.ui.panel.other;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fr.fireblaim.launcher_generator.ui.PanelManager;
import fr.fireblaim.launcher_generator.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopBar extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        layout.setStyle("-fx-background-color: rgb(35, 40, 40);");

        Label title = new Label(panelManager.getStage().getTitle());
        title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18f));
        title.setStyle("-fx-text-fill: white;");
        title.setTranslateX(-300);
        GridPane.setVgrow(title, Priority.ALWAYS);
        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setHalignment(title, HPos.CENTER);
        this.layout.getChildren().add(title);

        GridPane topBarButton = new GridPane();
        topBarButton.setMinWidth(100d);
        topBarButton.setMaxWidth(100d);
        topBarButton.setTranslateX(750);
        GridPane.setVgrow(topBarButton, Priority.ALWAYS);
        GridPane.setHgrow(topBarButton, Priority.ALWAYS);
        GridPane.setHalignment(title, HPos.RIGHT);
        this.layout.getChildren().add(topBarButton);

        FontAwesomeIconView closeBtn = new FontAwesomeIconView(FontAwesomeIcon.WINDOW_CLOSE);
        FontAwesomeIconView minimizeBtn = new FontAwesomeIconView(FontAwesomeIcon.WINDOW_MINIMIZE);
        GridPane.setVgrow(closeBtn, Priority.ALWAYS);
        GridPane.setHgrow(closeBtn, Priority.ALWAYS);
        GridPane.setVgrow(minimizeBtn, Priority.ALWAYS);
        GridPane.setHgrow(minimizeBtn, Priority.ALWAYS);

        closeBtn.setFill(Color.WHITE);
        closeBtn.setOpacity(0.7f);
        closeBtn.setSize("18px");
        closeBtn.setOnMouseEntered(e -> closeBtn.setOpacity(1.f));
        closeBtn.setOnMouseExited(e -> closeBtn.setOpacity(0.7f));
        closeBtn.setOnMouseClicked(e -> System.exit(0));
        closeBtn.setTranslateX(70f);

        minimizeBtn.setFill(Color.WHITE);
        minimizeBtn.setOpacity(0.70f);
        minimizeBtn.setSize("18px");
        minimizeBtn.setOnMouseEntered(e -> minimizeBtn.setOpacity(1.0f));
        minimizeBtn.setOnMouseExited(e -> minimizeBtn.setOpacity(0.7f));
        minimizeBtn.setOnMouseClicked(e -> this.panelManager.getStage().setIconified(true));
        minimizeBtn.setTranslateX(28.0d);

        topBarButton.getChildren().addAll(closeBtn, minimizeBtn);
    }

    @Override
    public String getName() {
        return "Top Bar";
    }
}
