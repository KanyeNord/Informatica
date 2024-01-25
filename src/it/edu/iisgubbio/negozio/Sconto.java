package it.edu.iisgubbio.negozio;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sconto extends Application {

	TextField cPrezzoPanino = new TextField();
	TextField cNumeroPanini = new TextField();
	TextField cSconto = new TextField();
	Label eTotale = new Label();
	CheckBox kSconto = new CheckBox();

	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label ePrezzoPanino = new Label("prezzo panino");
		Label eNumeroPanini = new Label("numero panini");
		Label eSconto= new Label("sconto(%)");
		Button pCalcolaTotale = new Button("calcola totale");

		griglia.setGridLinesVisible(false);

		griglia.add(ePrezzoPanino, 0, 0);
		griglia.add(eNumeroPanini, 0, 1);
		griglia.add(eSconto, 0, 2);
		griglia.add(cPrezzoPanino, 1, 0);
		griglia.add(cNumeroPanini, 1, 1);
		griglia.add(cSconto, 1, 2);
		griglia.add(kSconto, 0, 3, 2, 1);
		griglia.add(pCalcolaTotale, 0, 4, 2, 1);
		griglia.add(eTotale, 0, 5, 2, 1);


		pCalcolaTotale.setMaxWidth(300);
		eTotale.setMaxWidth(300);

		pCalcolaTotale.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Sconto");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcola() {
		double prezzoPanino, numeroPanini, sconto, prezzoScontato, totale;
		prezzoPanino = Double.parseDouble(cPrezzoPanino.getText());
		numeroPanini = Double.parseDouble(cNumeroPanini.getText());



		if(kSconto.isSelected()) {
			sconto = Double.parseDouble(cSconto.getText());
			prezzoScontato = prezzoPanino-((prezzoPanino/100)*sconto);
			totale = (prezzoScontato * numeroPanini);

		} else {
			totale = (prezzoPanino * numeroPanini);
		}
		eTotale.setText("totale= "+ totale + "€");
	}

	public static void main(String[] args) {
		launch(args);
	}
}