package it.edu.iisgubbio.matematica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FunzioneFattoriale extends Application {

	TextField cNumero = new TextField();
	Label eFattoriale = new Label();



	public void start(Stage finestra) throws Exception {
		Button pFattoriale = new Button("!");
		GridPane griglia = new GridPane();

		griglia.setGridLinesVisible(false);

		griglia.add(cNumero, 0, 0);
		griglia.add(pFattoriale, 1, 0);
		griglia.add(eFattoriale, 2, 0);

		pFattoriale.setOnAction(e -> calcola());
		cNumero.setMinWidth(50);
		pFattoriale.setMinWidth(20);
		eFattoriale.setMinWidth(50);
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Fattoriale");
		finestra.setScene(scena);
		finestra.show();

	}
	int fattoriale(int n) {
		int risultato;
		if(n==1) {
			risultato=1;
		} else {
			risultato=n*(fattoriale(n-1));
		}
		return risultato;
	}
	public void calcola() {
		int n=Integer.parseInt(cNumero.getText());
		int risultato;
			risultato=n*(fattoriale(n));
	
		eFattoriale.setText(risultato+ "");
	}
	public static void main(String[] args) {
		launch(args);
	}
}