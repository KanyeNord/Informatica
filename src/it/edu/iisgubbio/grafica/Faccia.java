package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Faccia extends Application {
	
public void start(Stage finestra) throws Exception {	
	Pane pannello = new Pane();
	Circle testa = new Circle(100);
	Circle occhioSx = new Circle(30);
	Circle occhioDx = new Circle(30);
	Circle occhialeSx = new Circle(40);
	Circle occhialeDx = new Circle(40);
	Line boccaSx = new Line(60, 140, 100, 110);
	Line boccaDx = new Line(140, 140, 100, 110);
	
	testa.setFill(Color.PINK);
	testa.setCenterX(100);
	testa.setCenterY(100);
	occhioSx.setFill(Color.BLUE);
	occhioSx.setCenterX(50);
	occhioSx.setCenterY(50);
	occhioDx.setFill(Color.BLUE);
	occhialeSx.setFill(Color.BLACK);
	occhialeSx.setCenterX(50);
	occhialeSx.setCenterY(50);
	occhialeDx.setFill(Color.BLACK);
	occhialeDx.setCenterX(150);
	occhialeDx.setCenterY(
			50);
	occhioDx.setCenterX(150);
	occhioDx.setCenterY(50);
	boccaSx.setStroke(Color.RED);
	boccaSx.setStrokeWidth(3);
	boccaDx.setStroke(Color.RED);
	boccaDx.setStrokeWidth(3);
	
	pannello.getChildren().add(testa);
	pannello.getChildren().add(occhialeSx);
	pannello.getChildren().add(occhialeDx);
	pannello.getChildren().add(occhioSx);
	pannello.getChildren().add(occhioDx);
	pannello.getChildren().add(boccaSx);
	pannello.getChildren().add(boccaDx);
	
	Scene scena = new Scene (pannello, 200, 200);
	finestra.setTitle("Faccia");
	finestra.setScene(scena);
	finestra.show();
}

public static void main(String[] args) {
	launch(args);
}
}