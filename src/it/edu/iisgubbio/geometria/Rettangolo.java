package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rettangolo extends Application {

	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	Label eArea = new Label();
	Label ePerimetro = new Label();


	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		Button pCalcolaAP = new Button("calcola A P");
		Label eBase = new Label("base");
		Label eAltezza = new Label("altezza");
		
		griglia.setGridLinesVisible(false);
		
		griglia.add(eBase, 0, 0);
		griglia.add(cBase, 1, 0);
		griglia.add(eAltezza, 0, 1);
		griglia.add(cAltezza, 1, 1);
		griglia.add(pCalcolaAP, 0, 2, 2,1);
		griglia.add(eArea, 0, 3);
		griglia.add(ePerimetro, 1, 3);
		
		pCalcolaAP.setMaxWidth(300);
		eArea.setMinWidth(120);
	    pCalcolaAP.setOnAction(e -> calcola());
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}
	public void calcola() {
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
	public static void main(String[] args) {
		launch(args);
	}
}
