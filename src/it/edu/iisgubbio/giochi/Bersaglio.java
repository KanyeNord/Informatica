package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Bersaglio extends Application{
	Circle pallinoS = new Circle(9);
	Circle pallinoD = new Circle(9);
	
	@Override
	public void start(Stage finestra) throws Exception {
		Pane pannello = new Pane();
		pannello.addEventHandler(MouseEvent.MOUSE_CLICKED, e->gestore(e));
		pannello.getChildren().add(pallinoS);
		pannello.getChildren().add(pallinoD);
		
		pallinoS.setFill(Color.GREEN);
		pallinoD.setFill(Color.RED);
		
		
		Scene scena = new Scene (pannello, 300, 300);
		finestra.setTitle("Bersaglio");
		finestra.setScene(scena);
		finestra.show();
	}
	private void gestore(MouseEvent e) {
		if (e.getButton().equals(MouseButton.PRIMARY)==true) {
			pallinoS.setCenterX(e.getX());
			pallinoS.setCenterY(e.getY());
		}
		if (e.getButton().equals(MouseButton.SECONDARY)==true) {
			pallinoD.setCenterX(e.getX());
			pallinoD.setCenterY(e.getY());
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}




