package fr.fireblaim.launcher_generator.ui;

import com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;
import fr.fireblaim.launcher_generator.App;
import fr.fireblaim.launcher_generator.ui.panel.BlankPanel;
import fr.fireblaim.launcher_generator.ui.panel.Panel;
import fr.fireblaim.launcher_generator.ui.panel.TestPanel;
import fr.fireblaim.launcher_generator.ui.panel.other.TopBar;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

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
        stage.centerOnScreen();

        TopBar topBar = new TopBar();
        BorderlessScene scene = new BorderlessScene(stage, StageStyle.UNDECORATED, layout);

        scene.setMoveControl(topBar.getLayout());
        scene.setResizable(false);
        scene.removeDefaultCSS();

        stage.setScene(scene);

        RowConstraints topPaneConstraints = new RowConstraints();
        topPaneConstraints.setValignment(VPos.TOP);
        topPaneConstraints.setMinHeight(35);
        topPaneConstraints.setMaxHeight(35);
        layout.getRowConstraints().addAll(topPaneConstraints, new RowConstraints());
        layout.add(topBar.getLayout(), 0, 0);
        topBar.init(this);

        layout.add(contentPane, 0, 1);
        GridPane.setHgrow(contentPane, Priority.ALWAYS);
        GridPane.setVgrow(contentPane, Priority.ALWAYS);

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
