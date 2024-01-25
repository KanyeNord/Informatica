package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ragnatela extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();

	for (int x=0, y=0; x<=200; x=x+20, y=y+20) {
			Line linea = new Line(0, 0+y, 200-x, 0);
			linea.setStroke(Color.PURPLE);
			linea.setStrokeWidth(2);
			pannello.getChildren().add(linea);
	}
	Scene scena = new Scene (pannello, 200, 200);
	finestra.setTitle("Pallini");
	finestra.setScene(scena);
	finestra.show();
}
public static void main(String[] args) {
	launch(args);
}
}