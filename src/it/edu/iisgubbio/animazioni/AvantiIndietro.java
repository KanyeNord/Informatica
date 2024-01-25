package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AvantiIndietro extends Application{
	Pane pannello = new Pane();
	Circle Pallino = new Circle(10);
	int n=20;
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(10),
			x -> aggiornaTimer()));
	
	boolean destra = true;
	public void start(Stage finestra) throws Exception {
	
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		Pallino.setFill(Color.GREEN);
		pannello.getChildren().add(Pallino);
		Pallino.setCenterX(n);
		Pallino.setCenterY(20);
		

		
		
		
		
		
		
		

		Scene scena = new Scene (pannello, 300, 200);
		finestra.setTitle("Avanti");
		finestra.setScene(scena);
		finestra.show();
	}

	private void aggiornaTimer(){

		

		if (n==10) {
			destra=true;
		} 
		if (n==290) {
			destra=false;
			}

	if (destra) {
			Pallino.setCenterX(n++);
		} else {
			Pallino.setCenterX(n--);
		}
	}

	public static void main(String args[]){
		launch();
	}
}