package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Avanti extends Application{
	Pane pannello = new Pane();
	Circle Pallino = new Circle(7);
	int n=20;
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(1),
			x -> aggiornaTimer()));
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Button pVia = new Button("Via");

		griglia.add(pVia, 0, 0);
		griglia.add(pannello, 0, 1);
		
		pVia.setOnAction(e -> avvia());
		
		Pallino.setFill(Color.GREEN);
		pannello.getChildren().add(Pallino);
		Pallino.setCenterX(n);
		Pallino.setCenterY(20);
		
		pannello.setPrefHeight(200);
		pannello.setPrefWidth(300);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Avanti");
		finestra.setScene(scena);
		finestra.show();
	}

	private void avvia(){
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
	
	private void aggiornaTimer(){

		Pallino.setCenterX(n++);

	}

	public static void main(String args[]){
		launch();
	}
}