package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class AgenziaViaggi extends Application {

	TextField cPersoneAutobus = new TextField();
	TextField cPartecipanti = new TextField();
	TextField cCostoAutobus = new TextField();
	Label eCostoBiglietto = new Label("costo biglietto");
	Label eCosto = new Label();
	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label ePersoneAutobus = new Label("persone per autobus");
		Label ePartecipanti = new Label("partecipanti");
		Label eCostoAutobus = new Label("costo autobus");
		Button pCalcolaBiglietto = new Button("calcola biglietto");

		griglia.setGridLinesVisible(false);
		griglia.add(ePersoneAutobus, 0, 0);
		griglia.add(cPersoneAutobus, 1, 0);
		griglia.add(ePartecipanti, 0, 1);
		griglia.add(cPartecipanti, 1, 1);
		griglia.add(eCostoAutobus, 0, 2);
		griglia.add(cCostoAutobus, 1, 2);
		griglia.add(pCalcolaBiglietto, 0, 3, 2, 1);
		griglia.add(eCostoBiglietto, 0, 4);
		griglia.add(eCosto, 1, 4);

		pCalcolaBiglietto.setMaxWidth(300);
		pCalcolaBiglietto.setOnAction(e -> biglietto());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Kebab");
		finestra.setScene(scena);
		finestra.show();

	}
	public void biglietto() {
		double costoAutobus, costoTotale, costoBiglietto;
		int nAutobus, personeAutobus, partecipanti;
		personeAutobus = Integer.parseInt(cPersoneAutobus.getText());
		partecipanti = Integer.parseInt(cPartecipanti.getText());
		costoAutobus = Double.parseDouble(cCostoAutobus.getText());
		if (partecipanti%personeAutobus==0) {
			nAutobus = (partecipanti/personeAutobus);
		} else {
			nAutobus = (partecipanti/personeAutobus)+1;
		}
		costoTotale = (nAutobus*costoAutobus);
		costoBiglietto = costoTotale/partecipanti;
		eCosto.setText(costoBiglietto + "€");
	}
	public static void main(String[] args) {
		launch(args);
	}
}