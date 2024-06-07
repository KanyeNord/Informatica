package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class ScarabottaAlessioRistorante extends Application {

	TextField cNumeroBistecche = new TextField();
	TextField cPrezzoBistecche = new TextField();
	TextField cNumeroBibite = new TextField();
	TextField cPrezzoBibite = new TextField();
	CheckBox kContorni = new CheckBox("contorni + 1.5€");
	CheckBox kSconto = new CheckBox("sconto 20%");
	Label eCosto = new Label("??");
	
	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label eNumeroBistecche = new Label("Numero bistecche:");
		Label ePrezzoBistecche = new Label("Prezzo bistecca");
		Label eNumeroBibite = new Label("Numero bibite:");
		Label ePrezzoBibite = new Label("Prezzo bibita");
		Button pCalcolaCosto = new Button("totale");
		Label eTotale = new Label("Totale:");

		griglia.add(eNumeroBistecche, 0, 0);
		griglia.add(cNumeroBistecche, 1, 0);
		griglia.add(ePrezzoBistecche, 0, 1);
		griglia.add(cPrezzoBistecche, 1, 1);
		griglia.add(eNumeroBibite, 0, 2);
		griglia.add(cNumeroBibite, 1, 2);
		griglia.add(ePrezzoBibite, 0, 3);
		griglia.add(cPrezzoBibite, 1, 3);
		griglia.add(pCalcolaCosto, 2, 0, 1, 4);
		griglia.add(kContorni, 1, 4);
		griglia.add(kSconto, 1, 5);
		griglia.add(eTotale, 0, 6);
		griglia.add(eCosto, 1, 6);

		pCalcolaCosto.setMaxHeight(300);
		pCalcolaCosto.setOnAction(e -> totale());
		
		griglia.setId("griglia");
		eNumeroBistecche.getStyleClass().add("numero");
		eNumeroBibite.getStyleClass().add("numero");

		Scene scena = new Scene (griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/verifica/ScarabottaAlessio.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scena);
		finestra.show();
	}
	public void totale() {
		double costoBistecca, costoBibite,totaleBistecche, totaleBibite, costoTotale=0;
		int nBistecche, nBibite;
		nBistecche = Integer.parseInt(cNumeroBistecche.getText());
		nBibite = Integer.parseInt(cNumeroBibite.getText());
		costoBistecca = Double.parseDouble(cPrezzoBistecche.getText());
		costoBibite = Double.parseDouble(cPrezzoBibite.getText());
		
		totaleBistecche= nBistecche * costoBistecca;
		totaleBibite= nBibite * costoBibite;
		costoTotale= totaleBistecche + totaleBibite;
		if (kContorni.isSelected()) {
			costoTotale= costoTotale+(nBistecche*1.5);
		}
		if (kSconto.isSelected()) {
			costoTotale = costoTotale-((costoTotale/100)*20);
		}
		eCosto.setText(costoTotale + "€");
	}
	public static void main(String[] args) {
		launch(args);
	}
}