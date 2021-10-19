package fr.fireblaim.launcher_generator.ui.components;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class CTextField extends TextField {

    public CTextField() {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);

        setStyle("-fx-padding: 8px; -fx-text-fill: black; -fx-background-color: white; -fx-border-color: white;");
    }

    public void setSize(double width, double height) {
        setPrefSize(width, height);
        setMinSize(width, height);
        setMaxSize(width, height);
    }

    public void setFontSize(double size, boolean bold) {
        if(bold)
            setFont(Font.loadFont(CLabel.class.getResourceAsStream("/fonts/Roboto-Bold.ttf"), size));
        else
            setFont(Font.loadFont(CLabel.class.getResourceAsStream("/fonts/Roboto-Medium.ttf"), size));
    }

}
