package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private Color curColor = Color.BLACK;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup toolGroup;

    @FXML
    void eraserMode(ActionEvent event) {
        curColor = Color.WHITE;
    }

    @FXML
    void penMode(ActionEvent event) {
        curColor = Color.BLACK;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, curColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

}

