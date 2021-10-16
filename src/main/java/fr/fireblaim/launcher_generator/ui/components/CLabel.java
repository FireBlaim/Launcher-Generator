package fr.fireblaim.launcher_generator.ui.components;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class CLabel extends Label {

    public CLabel(String text) {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);

        setText(text);
        setStyle("-fx-text-fill: white;");
    }

    public void setFontSize(double size, boolean bold) {
        if(bold)
            setFont(Font.loadFont(CLabel.class.getResourceAsStream("/fonts/Roboto-Bold.ttf"), size));
        else
            setFont(Font.loadFont(CLabel.class.getResourceAsStream("/fonts/Roboto-Regular.ttf"), size));
    }

}
