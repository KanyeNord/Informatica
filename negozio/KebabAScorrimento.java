package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

public class KebabAScorrimento extends Application {

	CheckBox kCarne = new CheckBox("carne [4.00€]");
	CheckBox kFormaggio = new CheckBox("formaggio [1.00€]");
	CheckBox kPomodoro = new CheckBox("pomodoro [1.00€]");
	CheckBox kSalsa = new CheckBox("salsa [0.50€]");
	CheckBox kCipolla = new CheckBox("cipolla [0.50€]");
	Label eTotale = new Label();
	Slider sKebab = new Slider(1,10,1);

	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Button pTotale = new Button("totale");

		griglia.setGridLinesVisible(false);
		griglia.add(sKebab,     0, 0, 2, 1);
		griglia.add(kCarne,     0, 1, 2, 1);
		griglia.add(kFormaggio, 0, 2, 2, 1);
		griglia.add(kPomodoro,  0, 3, 2, 1);
		griglia.add(kSalsa,     0, 4, 2, 1);
		griglia.add(kCipolla,   0, 5, 2, 1);
		griglia.add(pTotale,    0, 6);
		griglia.add(eTotale,    1, 6);
		
		sKebab.setShowTickMarks(true);
		sKebab.setShowTickLabels(true);
		sKebab.setMajorTickUnit(1);
		sKebab.setMinorTickCount(0);
		sKebab.setSnapToTicks(true);

		pTotale.setOnAction(e -> totale());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia, 250, 200);
		finestra.setTitle("Kebab");
		finestra.setScene(scena);
		finestra.show();

	}

	public void totale() {
		double totale = 0;
		double nKebab = sKebab.getValue();
		if(kCarne.isSelected()) {
			totale= totale+4.0;
		}
		if(kFormaggio.isSelected()) {
			totale= totale+1.0;
		}
		if(kPomodoro.isSelected()) {
			totale= totale+1.0;
		}
		if(kSalsa.isSelected()) {
			totale= totale+0.5;
		}
		if(kCipolla.isSelected()) {
			totale= totale+0.5; 
		}
		if (nKebab==1) {
		eTotale.setText(("il prezzo del tuo Kebab è " + totale*nKebab)+"€");
		} else {
		eTotale.setText("il prezzo dei tuoi Kebab è " + (totale*nKebab)+"€");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}