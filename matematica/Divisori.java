package it.edu.iisgubbio.matematica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application {

	TextField cNumero = new TextField();
	Label eDivisori = new Label();



	public void start(Stage finestra) throws Exception {
		Label eNumero = new Label("numero");
		Button pDivisori = new Button("calcola soluzioni");
		GridPane griglia = new GridPane();

		griglia.setGridLinesVisible(false);


		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pDivisori, 0, 2, 2, 1);
		griglia.add(eDivisori, 0, 3, 2, 1);

		pDivisori.setMaxWidth(500);

		eDivisori.setMaxWidth(500);

		pDivisori.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Divisori");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcola() {
		int numero;
		String divisori = "";
		numero = Integer.parseInt(cNumero.getText());
		for ( int contatore=2; contatore<=numero; contatore++) {
			if (numero%contatore==0) {
				if (contatore==numero) {
					divisori += contatore;
				} else {
					divisori +=contatore +  ", ";
				}
			}
			eDivisori.setText(divisori);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}