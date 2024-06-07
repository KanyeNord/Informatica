package it.edu.iisgubbio.testi;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lettere extends Application {

	TextField cFrase = new TextField();
	Button pContaVocali = new Button("conta vocali");
	Button pNascondi = new Button("nascondi vocali");
	Label eRisultato = new Label();

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eFrase = new Label("frase");
		Label eVocali = new Label("vocali:");

		griglia.add(eFrase, 0, 0);
		griglia.add(cFrase, 1, 0);
		griglia.add(pContaVocali, 0, 1, 2, 1);
		griglia.add(eVocali, 0, 2);
		griglia.add(eRisultato, 1, 2);
		griglia.add(pNascondi, 0, 3, 2, 1);

		pContaVocali.setOnAction(e -> contavocali());
		pNascondi.setOnAction(e -> nascondi());
		pContaVocali.setMaxWidth(300);
		pNascondi.setMaxWidth(300);
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Lettere");
		finestra.setScene(scena);
		finestra.show();
	}

	public void contavocali() {
		int vocali=0;
		String frase=(cFrase.getText()).toLowerCase();
		char x[]=frase.toCharArray();
		for ( int pos=0; pos<=x.length; pos++) {
			switch (x[pos]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				vocali++;
			}
			eRisultato.setText(vocali + "");
		}
	}
	public void nascondi() {
		char x[]=(cFrase.getText()).toCharArray();
		for ( int pos=0; pos<=x.length; pos++) {
			switch (x[pos]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				x[pos]='-';
			}
			String testo= new String(x);
			eRisultato.setText(testo + "");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}