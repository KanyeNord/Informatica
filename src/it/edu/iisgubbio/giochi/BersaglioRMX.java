package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BersaglioRMX extends Application{
	Circle pallino = new Circle(9);
	Label ePunti = new Label();
	@Override
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Pane pannello = new Pane();
		
		griglia.setGridLinesVisible(true);
		
		ePunti.setPrefHeight(20);
		ePunti.setPrefWidth(300);
		
		griglia.add(ePunti, 1,0);
		griglia.add(pannello, 0,1,3,1);
		
		pannello.addEventHandler(MouseEvent.MOUSE_CLICKED, e->gestore(e));
		pannello.getChildren().add(pallino);
		
		pallino.setFill(Color.GREEN);
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(1),
				x -> aggiornatimer()));
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		Scene scena = new Scene (griglia, 300, 300);
		finestra.setTitle("Bersaglio");
		finestra.setScene(scena);
		finestra.show();
	}
	private void gestore(MouseEvent e) {
		if (pallino.getY==e.getY) {

			pallino.setCenterX(e.getX());
			pallino.setCenterY(e.getY());
		}
	}
		private void aggiornatimer() {
			int xR=(int)(Math.random()*300)+1;
			int yR=(int)(Math.random()*300)+1;
			pallino.setCenterX(xR);
			pallino.setCenterY(yR);
	}

	public static void main(String[] args) {
		launch(args);
	}
}




