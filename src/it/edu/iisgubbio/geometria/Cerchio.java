package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Cerchio extends Application {

	TextField cRaggio = new TextField();
	Label eArea = new Label();
	Label eCirconferenzaA= new Label();
	Label eCirconferenzaB= new Label();
	Label eCrediti= new Label("Alessio Scarabotta, Michele Ciampaglia, Lorenzo Menichetti, Francesco Ciampaglia");
	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		Button pCalcola = new Button("calcola");
		Label eRaggio = new Label("raggio");
		
		griglia.setGridLinesVisible(false);
		
		griglia.add(eRaggio, 0, 0);
		griglia.add(cRaggio, 1, 0);
		griglia.add(pCalcola, 1, 2);
		griglia.add(eArea, 0, 3);
		griglia.add(eCirconferenzaA, 0, 4);
		griglia.add(eCirconferenzaB, 0, 5);
		griglia.add(eCrediti, 0, 6);

		cRaggio.setPromptText("inserisci valore");
		
		pCalcola.setMaxWidth(300);
		eArea.setMinWidth(120);
	    pCalcola.setOnAction(e -> calcola());
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Cerchio");
		finestra.setScene(scena);
		finestra.show();
		
	}
	public void calcola() {
		  double raggio, area, circonferenza ;
		  raggio = Double.parseDouble(cRaggio.getText());
		 area=(raggio*raggio)*3.14;
		 eArea.setText("" + area);
		 circonferenza=(((2*raggio)*3.14)-2)*2;
		 eCirconferenzaA.setText("" + circonferenza);
		 eCirconferenzaB.setText("" + circonferenza);
	  }
	public static void main(String[] args) {
		launch(args);
	}
}
