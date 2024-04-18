package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Polari extends Application {
	//TODO nfunzia
	public void start(Stage finestra) throws Exception {	
		Pane pannello = new Pane();
		Circle palla = new Circle(9);
		Circle palleAttorno = new Circle();
		palla.setLayoutX(200);
		palla.setLayoutY(200);
		pannello.getChildren().add(palla);
		int angolo=60;
		int x=(int) (palla.getLayoutX()+100+(angolo*Math.PI)/180);
		int y=(int) (palla.getLayoutY()+100+(angolo*Math.PI)/180);
		palleAttorno.setLayoutX(x);
		palleAttorno.setLayoutY(y);
		pannello.getChildren().add(palleAttorno);

		Scene scena = new Scene (pannello, 400, 400);
		finestra.setTitle("Polari");
		finestra.setScene(scena);
		finestra.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}