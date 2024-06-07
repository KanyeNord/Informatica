package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barra extends Application{
	TextField cSimbolo = new TextField();
	TextField cMillisecondi = new TextField();
	Label eBarra = new Label();
	String testo="";
	int contatore = 0;
	boolean destra=true;










	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eSimbolo = new Label("simbolo:");
		Label eMillisecondi = new Label("millisecondi:");
		Button pVia = new Button("Via");

		griglia.add(eSimbolo, 0, 0);
		griglia.add(cSimbolo, 1, 0);
		griglia.add(eMillisecondi, 0, 1);
		griglia.add(cMillisecondi, 1, 1);
		griglia.add(pVia, 2, 0, 1, 2);
		griglia.add(eBarra, 0, 2, 3, 1);

		pVia.setOnAction(e -> avvia());







		Scene scena = new Scene (griglia);
		finestra.setTitle("Barra");
		finestra.setScene(scena);
		finestra.show();
	}

	private void avvia(){
		int millisecondi = Integer.parseInt(cMillisecondi.getText());

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.millis(millisecondi),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

	}

	private void aggiornaTimer(){
		
		if (contatore==0) {
			destra=true;

		} 
		if (contatore==30) {
			destra=false;
		}

		testo="";
		for (int n=0;n<contatore;n++) {
			testo=testo+cSimbolo.getText();
		}
		eBarra.setText(testo);

		if (destra) {
			contatore++;
		} else {
			contatore--;
		}
	}

	public static void main(String args[]){
		launch();
	}
}