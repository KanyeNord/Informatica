package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Kebab2 extends Application {
	ComboBox<String> comboCarne = new ComboBox<String>();
	ComboBox<String> comboContorni = new ComboBox<String>();
	ComboBox<String> comboSalse = new ComboBox<String>();

	Label eTotale = new Label();
	Label eCarnePrezzo = new Label();
	Label eContorniPrezzo = new Label();
	Label eSalsePrezzo = new Label();


	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eCarne = new Label("Carne");
		Label eContorni = new Label("contorno");
		Label eSalse = new Label("Salse");
		Button pTotale = new Button("totale");

		comboCarne.getItems().add("pollo");
		comboCarne.getItems().add("maiale");
		comboCarne.getItems().add("vitello");
		comboCarne.getItems().add("tofu");

		comboContorni.getItems().add("insalata");
		comboContorni.getItems().add("cipolla");
		comboContorni.getItems().add("pomodoro");
		comboContorni.getItems().add("carota");

		comboSalse.getItems().add("mayonese");
		comboSalse.getItems().add("piccante");
		comboSalse.getItems().add("yogurt");
		comboSalse.getItems().add("tzatziki");

		comboCarne.getSelectionModel().select(0);
		comboContorni.getSelectionModel().select(0);
		comboSalse.getSelectionModel().select(2);

		comboCarne.setOnAction(e -> pCarne());
		comboCarne.setOnAction(e -> pContorni());
		comboCarne.setOnAction(e -> pSalse());

		griglia.add(eCarne, 0, 0);
		griglia.add(eCarnePrezzo, 1, 1);
		griglia.add(comboCarne, 0, 1);
		griglia.add(eContorni, 0, 2);
		griglia.add(eContorniPrezzo, 1, 3);
		griglia.add(comboContorni, 0, 3);
		griglia.add(eSalse, 0, 4);
		griglia.add(eSalsePrezzo, 1, 5);
		griglia.add(comboSalse, 0, 5);
		griglia.add(pTotale, 0, 6);
		griglia.add(eTotale, 0, 7);

		comboCarne.setMaxWidth(300);
		comboContorni.setMaxWidth(300);
		comboSalse.setMaxWidth(300);
		pTotale.setMaxWidth(300);


		pTotale.setOnAction(e -> totale());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Kebab");
		finestra.setScene(scena);
		finestra.show();

	}
	public void pCarne() {
		String carne = comboCarne.getValue();

		switch (carne) {
		case "pollo":
			eCarnePrezzo.setText("3.0 €");
		case "maiale":
			eCarnePrezzo.setText("2.5 €");
		case "vitello":
			eCarnePrezzo.setText("4.0 €");
		default :
			eCarnePrezzo.setText("3.0 €");
		}
	}
	public void pContorni() {
		String contorni = comboContorni.getValue();

		switch (contorni) {
		case "insalata":
			eContorniPrezzo.setText("0.5 €");
		case "cipolla":
			eContorniPrezzo.setText("0.5 €");
		case "pomodoro":
			eContorniPrezzo.setText("1.0 €");
		default :
			eContorniPrezzo.setText("1.0 €");
		}
	}
	public void pSalse() {
		String salse = comboSalse.getValue();
		switch (salse) {
		case "mayonese":
			eSalsePrezzo.setText("0.5 €");
		case "piccante":
			eSalsePrezzo.setText("1.0 €");
		case "yougurt":
			eSalsePrezzo.setText("0.5 €");
		default :
			eSalsePrezzo.setText("0.5 €");
		}
	}

	public void totale() {
		double totale = 0;
		String carne = comboCarne.getValue();
		String contorni = comboContorni.getValue();
		String salse = comboSalse.getValue();
		switch (carne) {
		case "pollo":
			totale= totale+3;
			break;
		case "maiale":
			totale= totale+2.5;
			break;
		case "vitello":
			totale= totale+4;
			break;
		default :
			totale= totale+3;
		}
		switch (contorni) {
		case "insalata":
			totale= totale+0.5;
			break;
		case "cipolla":
			totale= totale+0.5;
			break;
		case "pomodoro":
			totale= totale+1;
			break;
		default :
			totale= totale+1;
		}
		switch (salse) {
		
		case "mayonese":
			totale= totale+0.5;
			break;
		case "piccante":
			totale= totale+1;
			break;
		case "yougurt":
			totale= totale+0.5;
			break;
		default :
			totale= totale+0.5;
		}
		eTotale.setText(1+totale+"€");
	}

	public static void main(String[] args) {
		launch(args);
	}
}