package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rombo extends Application {

	TextField cDiagonaleMag = new TextField();
	TextField cDiagonaleMin = new TextField();
	Label eArea = new Label();
	Label ePerimetro = new Label();

	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		Button pCalcolaA = new Button("calcola area");
		Label eDiagonaleMag = new Label("diagonale maggiore");
		Label eDiagonaleMin = new Label("diagonale minore");
		
		griglia.setGridLinesVisible(false);
		
		griglia.add(eDiagonaleMag, 0, 0);
		griglia.add(cDiagonaleMag, 1, 0);
		griglia.add(eDiagonaleMin, 0, 1);
		griglia.add(cDiagonaleMin, 1, 1);
		griglia.add(pCalcolaA, 0, 2, 2,1);
		griglia.add(eArea, 0, 3);
		griglia.add(ePerimetro, 1, 3);
		cDiagonaleMag.setPromptText("inserisci valore");
		cDiagonaleMin.setPromptText("inserisci valore");		
		
		pCalcolaA.setMaxWidth(300);
		eArea.setMinWidth(120);
	    pCalcolaA.setOnAction(e -> calcola());
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Rombo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	public void calcola() {
		  double dMag, dMin, lato, area, perimetro;
		  dMag = Double.parseDouble(cDiagonaleMag.getText());
		  dMin = Double.parseDouble(cDiagonaleMin.getText());
		  area = (dMag * dMin)/2;
		  dMag = dMag/2;
		  dMin = dMin/2;
		  lato = Math.sqrt ((dMag*dMag)+(dMin*dMin));
		  perimetro = lato*4;
		  eArea.setText("area= " + area + "m²");
		  ePerimetro.setText("perimetro= " + perimetro + "m");
	  }
	public static void main(String[] args) {
		launch(args);
	}
}
