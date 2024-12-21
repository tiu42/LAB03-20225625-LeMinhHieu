package hust.soict.dsai.javafx;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	
	@FXML
    private RadioButton penRadioButton;
	
	@FXML
    private RadioButton eraserRadioButton;
	
	@FXML
	private ToggleGroup radioGroup;
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
		drawingAreaPane.getChildren().add(newCircle);
	}
}
