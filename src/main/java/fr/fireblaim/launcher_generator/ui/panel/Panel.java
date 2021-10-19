package fr.fireblaim.launcher_generator.ui.panel;

import fr.fireblaim.launcher_generator.App;
import fr.fireblaim.launcher_generator.ui.PanelManager;
import fr.fireblaim.launcher_generator.utils.Logger;
import javafx.animation.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

public abstract class Panel implements IPanel {

    protected App app;
    protected Logger logger;
    protected PanelManager panelManager;

    protected GridPane layout;

    public Panel() {
        this.app = App.getInstance();
        this.logger = app.getLogger();

        this.layout = new GridPane();
    }

    @Override
    public void init(PanelManager panelManager) {
        this.panelManager = panelManager;

        GridPane.setHgrow(layout, Priority.ALWAYS);
        GridPane.setVgrow(layout, Priority.ALWAYS);
    }

    @Override
    public void onShow() {

    }

    @Override
    public GridPane getLayout() {
        return layout;
    }

    @Override
    public abstract String getName();

    @Override
    public String getStylesheetPath() {
        return null;
    }
}
