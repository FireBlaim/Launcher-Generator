package fr.fireblaim.launcher_generator.ui.components;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Cursor;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class CButton extends JFXButton {

    public CButton(String text) {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);

        setText(text);
        setStyle("-fx-padding: 0.7em 0.57em; -fx-text-fill: white; -fx-border-color: white;");
        setCursor(Cursor.HAND);
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
