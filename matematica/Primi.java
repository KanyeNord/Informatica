package it.edu.iisgubbio.matematica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Primi extends Application {

	TextField cNumero = new TextField();
	Label ePrimi = new Label();



	public void start(Stage finestra) throws Exception {
		Label eNumero = new Label();
		Button pPrimi = new Button("calcola numeri primi");
		GridPane griglia = new GridPane();

		griglia.setGridLinesVisible(false);


		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pPrimi, 0, 2, 2, 1);
		griglia.add(ePrimi, 0, 3, 2, 1);

		pPrimi.setMaxWidth(500);
		ePrimi.setMaxWidth(500);

		pPrimi.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Divisori");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcola() {
		int numero ,conta = 0;
		numero = Integer.parseInt(cNumero.getText());
		for ( int contatore=1; contatore<=numero; contatore++) {
			if (numero%contatore==0) {
				conta = conta +1;
			}
		}
		if (conta==2) {
			ePrimi.setText(numero + " è primo");
		} else {
			ePrimi.setText(numero + " non è primo");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}