package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PalliniRMX extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();

	for (int x=20; x<=120; x=x+20) {
		for (int y=20; y<=100; y=y+20) {
			Circle testa = new Circle(7);
			testa.setFill(Color.GREEN);
			testa.setCenterX(x);
			testa.setCenterY(y);
			pannello.getChildren().add(testa);
			}
	}
	Scene scena = new Scene (pannello, 140, 130);
	finestra.setTitle("Pallini");
	finestra.setScene(scena);
	finestra.show();
}
public static void main(String[] args) {
	launch(args);
}
}