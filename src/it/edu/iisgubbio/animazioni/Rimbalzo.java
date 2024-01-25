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

public class Rimbalzo extends Application{
	Pane pannello = new Pane();
	Circle pallino = new Circle(10);
	int x=20;
	int y=20;
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(10),
			x -> aggiornaTimer()));
	
	boolean destra = true;
	boolean sopra = true;
	public void start(Stage finestra) throws Exception {
	
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		pallino.setFill(Color.ORANGE);
		pannello.getChildren().add(pallino);
		pallino.setCenterX(0);
		pallino.setCenterY(150);
		Scene scena = new Scene (pannello, 400, 300);
		finestra.setTitle("Rimbalzo");
		finestra.setScene(scena);
		finestra.show();
	}

	private void aggiornaTimer(){
		if (x==10) {
			destra=true;
		} 
		if (x==390) {
			destra=false;
		}

		if (y==10) {
			sopra=true;
		} 
		if (y==290) {
			sopra=false;
		}

		if (destra) {
			pallino.setCenterX(x++);
		} else {
			pallino.setCenterX(x--);
		}

		if (sopra) {
			pallino.setCenterY(y++);
		} else {
			pallino.setCenterY(y--);
		}
	}

	public static void main(String args[]){
		launch();
	}
}