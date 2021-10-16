package fr.fireblaim.launcher_generator.ui;

import fr.fireblaim.launcher_generator.App;
import fr.fireblaim.launcher_generator.ui.panel.Panel;
import fr.fireblaim.launcher_generator.ui.panel.other.TopBar;
import fr.fireblaim.launcher_generator.ui.panel.panels.HomePanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class PanelManager {

    private final Point dragDelta = new Point();

    private final App app;
    private final Stage stage;

    private GridPane layout;
    private GridPane contentPane;

    public PanelManager(App app, Stage stage) {
        this.app = app;
        this.stage = stage;
    }

    public void init() {
        layout = new GridPane();
        contentPane = new GridPane();

        stage.setTitle("Launcher Generator v" + App.VERSION);
        stage.setWidth(854);
        stage.setHeight(480);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();

        TopBar topBar = new TopBar();
        topBar.init(this);

        Scene scene = new Scene(layout);

        scene.setOnMousePressed(event -> {
            if(topBar.getLayout().isPressed()) {
                dragDelta.x = (int) (stage.getX() - event.getScreenX());
                dragDelta.y = (int) (stage.getY() - event.getScreenY());
            }
        });
        scene.setOnMouseDragged(event -> {
            if(topBar.getLayout().isPressed()) {
                stage.setX(event.getScreenX() + dragDelta.x);
                stage.setY(event.getScreenY() + dragDelta.y);
            }
        });

        stage.setScene(scene);

        RowConstraints topPaneConstraints = new RowConstraints();
        topPaneConstraints.setValignment(VPos.TOP);
        topPaneConstraints.setMinHeight(35);
        topPaneConstraints.setMaxHeight(35);

        GridPane.setHgrow(contentPane, Priority.ALWAYS);
        GridPane.setVgrow(contentPane, Priority.ALWAYS);
        contentPane.setStyle("-fx-background-color: gray");

        layout.getRowConstraints().addAll(topPaneConstraints, new RowConstraints());
        layout.add(topBar.getLayout(), 0, 0);
        layout.add(contentPane, 0, 1);

        switchPanel(new HomePanel());

        stage.show();
    }

    public void switchPanel(Panel panel) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(panel.getLayout());

        if(panel.getStylesheetPath() != null) {
            stage.getScene().getStylesheets().clear();
            stage.getScene().getStylesheets().add(panel.getStylesheetPath());
        }

        panel.init(this);
        panel.onShow();
    }

    public App getApp() {
        return app;
    }

    public Stage getStage() {
        return stage;
    }
}
