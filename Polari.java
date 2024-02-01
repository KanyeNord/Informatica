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
	pannello.getChildren().add(palleAttorno);
	int angolo=60;
	int x=(int) (palla.getLayoutX()+100+(angolo*Math.PI)/180);
	
	Scene scena = new Scene (pannello, 400, 400);
	finestra.setTitle("Polari");
	finestra.setScene(scena);
	finestra.show();
}
public static void main(String[] args) {
	launch(args);
}
}