package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RettangoloCss extends Application {

	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	Label eArea = new Label();
	Label ePerimetro = new Label();


	public void start(Stage finestra) {
	
		GridPane griglia = new GridPane();
		Label eBase = new Label("base");
		Label eAltezza = new Label("altezza");
		ePerimetro.getStyleClass().add("blu");
		griglia.setGridLinesVisible(false);
		
		griglia.add(eBase, 0, 0);
		griglia.add(cBase, 1, 0);
		griglia.add(eAltezza, 0, 1);
		griglia.add(cAltezza, 1, 1);
		griglia.add(eArea, 0, 2);
		griglia.add(ePerimetro, 1, 2);
		
		eArea.setMinWidth(120);
		griglia.setId("griglia");
		
		cBase.setOnAction(e -> calcola());
		cAltezza.setOnAction(e -> calcola());
		
		
		Scene scena = new Scene (griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/prove/Stile.css");
		finestra.setTitle("Rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	public void calcola() {
		if (cBase.getText()=="" || cAltezza.getText()=="") {
			eArea.setText("mancano dati!");
			ePerimetro.setText("");
		} else {	
		  String baseStringa, altezzaStringa;
		  int base, altezza, area, perimetro;
		  baseStringa = cBase.getText();
		  altezzaStringa = cAltezza.getText();
		  base = Integer.parseInt(baseStringa);
		  altezza = Integer.parseInt(altezzaStringa);
		  area = base * altezza;
		  perimetro= (base + altezza) * 2;
		  eArea.setText("area= "+area);
		  ePerimetro.setText("perimetro= "+perimetro);
	  }
	}
	public static void main(String[] args) {
		launch(args);
	}
}
