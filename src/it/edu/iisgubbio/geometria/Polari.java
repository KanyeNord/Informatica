package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Polari extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();
	Circle palla = new Circle();
	Circle palleAttorno = new Circle();
	pannello.getChildren().add(palla);
	
	
	
	Scene scena = new Scene (pannello, 400, 400);
	finestra.setTitle("Pallini");
	finestra.setScene(scena);
	finestra.show();
}
public static void main(String[] args) {
	launch(args);
}
}