package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Span extends Application {
	GridPane griglia = new GridPane();
	Button pCiao = new Button("Ciao");
	Button p2Colonne = new Button("2 Colonne");
	Button pA = new Button("A");
	Button pB = new Button("B");
	public void start(Stage finestra) throws Exception {
		griglia.add(pCiao,0,0,1,2);
		griglia.add(p2Colonne,1,0,2,1);
		griglia.add(pA,1,1);
		griglia.add(pB,2,1);
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		pCiao.setMaxHeight(200);
		pA.setMinWidth(32);
		pB.setMaxWidth(200);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Span");
		finestra.setScene(scena);
		finestra.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
