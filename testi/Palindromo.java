package it.edu.iisgubbio.testi;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Palindromo extends Application {

	TextField cFrase = new TextField();
	Button pPalindromo = new Button("palindromo?");
	Label eRisultato = new Label();

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();

		griglia.add(cFrase, 0, 0);
		griglia.add(pPalindromo, 0, 1);
		griglia.add(eRisultato, 0, 2);

		pPalindromo.setOnAction(e -> contavocali());
		pPalindromo.setMaxWidth(300);

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Lettere");
		finestra.setScene(scena);
		finestra.show();
	}

	public void contavocali() {
		String frase=(cFrase.getText()).toLowerCase();
		char x[]=frase.toCharArray();
		boolean palindromo=true;
		for(int pos = 0 ;pos<x.length/2 && palindromo;pos++) {
			if (x[pos]!=x[x.length-1-pos]) {
				palindromo=false;
			}
		}
		if (palindromo) {
			eRisultato.setText("la parola è palindroma");
		} else {
			eRisultato.setText("la parola non è palindroma");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}