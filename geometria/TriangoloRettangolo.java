package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application {

	TextField cCateto1 = new TextField();
	TextField cCateto2 = new TextField();
	TextField cIpotenusa = new TextField();


	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		Label eCateto1 = new Label("Cateto1");
		Label eCateto2 = new Label("Cateto2");
		Label eIpotenusa = new Label("Ipotenusa");
		Button pCalcolaCateto1 = new Button("calcola cateto 1");
		Button pCalcolaCateto2 = new Button("calcola cateto 2");
		Button pCalcolaIpotenusa = new Button("calcola ipotenusa");
		
		griglia.setGridLinesVisible(false);
		
		griglia.add(eCateto1, 0, 0);
		griglia.add(eCateto2, 0, 1);
		griglia.add(eIpotenusa, 0, 2);
		griglia.add(cCateto1, 1, 0);
		griglia.add(cCateto2, 1, 1);
		griglia.add(cIpotenusa, 1, 2);
		griglia.add(pCalcolaCateto1, 2, 0);
		griglia.add(pCalcolaCateto2, 2, 1);
		griglia.add(pCalcolaIpotenusa, 2, 2);
		
		pCalcolaCateto1.setMaxWidth(300);
		pCalcolaCateto2.setMaxWidth(300);
		pCalcolaIpotenusa.setMaxWidth(300);

	    pCalcolaCateto1.setOnAction(e -> calcolaCateto1());
	    pCalcolaCateto2.setOnAction(e -> calcolaCateto2());
	    pCalcolaIpotenusa.setOnAction(e -> calcolaIpotenusa());
	    
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("TriangoloRettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}

	public void calcolaCateto1() {
		double cateto1, cateto2, ipotenusa;
		  cateto2 = Double.parseDouble(cCateto2.getText());
		  ipotenusa = Double.parseDouble(cIpotenusa.getText());
		  cateto1 = Math.sqrt ((ipotenusa*ipotenusa)-(cateto2*cateto2));
		  cCateto1.setText(""+cateto1);
	  }
	
	public void calcolaCateto2() {
		double cateto1, cateto2, ipotenusa;
		  cateto1 = Double.parseDouble(cCateto1.getText());
		  ipotenusa = Double.parseDouble(cIpotenusa.getText());
		  cateto2 = Math.sqrt ((ipotenusa*ipotenusa)-(cateto1*cateto1));
		  cCateto2.setText(""+cateto2);
	  }
	
	public void calcolaIpotenusa() {
		double cateto1, cateto2, ipotenusa;
		  cateto1 = Double.parseDouble(cCateto1.getText());
		  cateto2 = Double.parseDouble(cCateto2.getText());
		  ipotenusa = Math.sqrt ((cateto1*cateto1)+(cateto2*cateto2));
		  cIpotenusa.setText(""+ipotenusa);
	  }

	public static void main(String[] args) {
		launch(args);
	}
}

