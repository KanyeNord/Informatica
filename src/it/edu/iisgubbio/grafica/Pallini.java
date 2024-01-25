package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pallini extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();

	for (int n=20 ; n<=280 ; n=n+20) {
		Circle testa = new Circle(7);
		testa.setFill(Color.GREEN);
		testa.setCenterX(n);
		testa.setCenterY(20);
		pannello.getChildren().add(testa);
	}

	Scene scena = new Scene (pannello, 300, 50);
	finestra.setTitle("Pallini");
	finestra.setScene(scena);
	finestra.show();
}

public static void main(String[] args) {
	launch(args);
}
}