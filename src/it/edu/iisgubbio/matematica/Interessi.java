package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interessi extends Application {

	TextField cCapitale = new TextField();
	TextField cInteressi = new TextField();
	TextField cAnni = new TextField();
	Label eRisultato = new Label();
	public void start(Stage finestra) throws Exception {
		Label eCapitale = new Label("Capitale");
		Label eInteressi = new Label("Interessi");
		Label eAnni = new Label("Anni");
		Button pCalcola = new Button("Calcola Interessi");
		GridPane griglia = new GridPane();

		griglia.setGridLinesVisible(false);
		griglia.add(eCapitale, 0, 0);
		griglia.add(cCapitale, 1, 0);
		griglia.add(eInteressi, 0, 1);
		griglia.add(cInteressi, 1, 1);
		griglia.add(eAnni, 0, 2);
		griglia.add(cAnni, 1, 2);
		griglia.add(pCalcola, 0, 3, 2, 1);
		griglia.add(eRisultato, 0, 4, 2, 1);

		pCalcola.setMaxWidth(300);
		pCalcola.setOnAction(e -> calcola());
		
		griglia.setId("griglia");
		griglia.getStylesheets().add("it/edu/iisgubbio/matematica/Interessi.css");
		Scene scena = new Scene (griglia);
		finestra.setTitle("Tabellina");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcola() {
		double interessi, capitale;
		int contatore, anni;
		capitale = Double.parseDouble(cCapitale.getText());
		interessi = Double.parseDouble(cInteressi.getText());	
		anni = Integer.parseInt(cAnni.getText());

		for ( contatore=1; contatore<=anni; contatore++) {
			capitale = capitale +((capitale/100)*interessi);
		}
		eRisultato.setText(capitale + "");
	}
	public static void main(String[] args) {
		launch(args);
	}
}

