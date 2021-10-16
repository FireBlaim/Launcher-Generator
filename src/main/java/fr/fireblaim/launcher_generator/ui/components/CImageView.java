package fr.fireblaim.launcher_generator.ui.components;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CImageView extends ImageView {

    public CImageView(String imagePath) {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);

        setImage(new Image(CImageView.class.getResourceAsStream(imagePath)));
        setCursor(Cursor.HAND);

        setOnMouseEntered(event -> {
            setOpacity(0.7D);
        });
        setOnMouseExited(event -> {
            setOpacity(1D);
        });
    }

    public void setSize(double width, double height) {
        setFitWidth(width);
        setFitHeight(height);
    }

}
