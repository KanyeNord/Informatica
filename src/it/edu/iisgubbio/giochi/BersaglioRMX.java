package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BersaglioRMX extends Application{
	int raggio=10, punti = 0;
	Circle pallino = new Circle(raggio);
	Label ePunti = new Label("punteggio: ");
	@Override
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Pane pannello = new Pane();
		
		griglia.setGridLinesVisible(false);
		
		ePunti.setPrefHeight(20);
		ePunti.setPrefWidth(300);
		
		griglia.add(ePunti, 0, 0);
		griglia.add(pannello, 0, 1, 3, 1);
		
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

		double distanza, x2, y2;
			x2=(e.getX()-pallino.getCenterX())*(e.getX()-pallino.getCenterX());
			y2=(e.getY()-pallino.getCenterY())*(e.getY()-pallino.getCenterY());
			distanza=Math.sqrt(x2-y2);
			if (distanza<raggio) {
				punti++;
			}
			ePunti.setText("punteggio: "+punti+"");
	}
		private void aggiornatimer() {
			int xR=(int)(Math.random()*270)+31;
			int yR=(int)(Math.random()*270)+31;
			pallino.setCenterX(xR);
			pallino.setCenterY(yR);
	}

	public static void main(String[] args) {
		launch(args);
	}
}




