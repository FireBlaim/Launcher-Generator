package fr.fireblaim.launcher_generator.ui.panel;

import fr.fireblaim.launcher_generator.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {

    void init(PanelManager panelManager);
    void onShow();

    GridPane getLayout();
    String getName();
    String getStylesheetPath();

}
