package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RagnatelaDoppia extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();
	for (int x=0; x<=200; x=x+20) {
		int r = (int)(Math.random()*255)+1;
		int g = (int)(Math.random()*255)+1;
		int b = (int)(Math.random()*255)+1;
		
		Line linea1 = new Line(0, 0+x, 200-x, 0);
		linea1.setStroke(Color.rgb(r,g,b));
		linea1.setStrokeWidth(2);
		pannello.getChildren().add(linea1);

		Line linea2 = new Line(200, 200-x, 0+x, 200);
		linea2.setStroke(Color.rgb(r,g,b));
		linea2.setStrokeWidth(2);
		pannello.getChildren().add(linea2);
			
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