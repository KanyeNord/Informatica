package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer extends Application{
	Label eTimer = new Label();
	int n=100;
	
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.seconds(1),
			x -> aggiornaTimer()));
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Button pStart = new Button("Start");
		Button pStop = new Button("Stop");

		griglia.add(pStart, 0, 0);
		griglia.add(pStop, 2, 0);
		griglia.add(eTimer, 1, 1);
		pStart.setOnAction(e -> avvia());
		pStop.setOnAction(e -> ferma());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		eTimer.setMinWidth(50);
		eTimer.setMaxWidth(100);
		
		eTimer.setAlignment(Pos.CENTER);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Timer");
		finestra.setScene(scena);
		finestra.show();
	}

	private void avvia(){
	
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	private void ferma(){
		timeline.stop();
	}
	private void aggiornaTimer(){
		eTimer.setText(""+ (n--));
	}

	public static void main(String args[]){
		launch();
	}
}