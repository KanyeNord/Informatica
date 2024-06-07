package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Triangolo extends Application {
	
	Pane pannello = new Pane();
	TextField cNumero = new TextField();
	
public void start(Stage finestra) throws Exception {
	GridPane griglia = new GridPane();
	Label eNumero = new Label("numero");
	Button pVai = new Button("Vai!");
	

	griglia.setPadding( new Insets(10,10,10,10));
	griglia.setHgap(5);
	griglia.setVgap(5);
	
	griglia.add(eNumero, 0, 0);
	griglia.add(cNumero, 1, 0);
	griglia.add(pVai, 2, 0);
	griglia.add(pannello, 0, 1, 3,1);

	pannello.setPrefHeight(200);
	
	pVai.setOnAction(e -> pallini());
	
	Scene scena = new Scene (griglia);
	finestra.setTitle("Triangolo");
	finestra.setScene(scena);
	finestra.show();
}

public void pallini() {	
	pannello.getChildren().clear();
	int n = Integer.parseInt(cNumero.getText());
	int m = Integer.parseInt(cNumero.getText());
	n= n*20;
	m= m*20;
	for (int y=20; y<=n; y=y+20) {
		m = m-20;
		for (int x=20; x<=m; x=x+20) {
			Circle testa = new Circle(7);
			testa.setFill(Color.GREEN);
			testa.setCenterX(x);
			testa.setCenterY(y);
			pannello.getChildren().add(testa);
		}

	}
}

public static void main(String[] args) {
	launch(args);
}
}