package it.edu.iisgubbio.verifica;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScarabottaAlessioMCD extends Application {

	TextField cNumero1 = new TextField();
	TextField cNumero2 = new TextField();
	Label eRisultato = new Label("risultato");

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eNumero1 = new Label("primo numero:");
		Label eNumero2 = new Label("secondo numero:");
		Button pCalcola = new Button("Calcola");

		griglia.add(eNumero1, 0, 0);
		griglia.add(cNumero1, 1, 0);
		griglia.add(eNumero2, 0, 1);
		griglia.add(cNumero2, 1, 1);
		griglia.add(pCalcola, 0, 3);
		griglia.add(eRisultato, 1, 3);

		pCalcola.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Massimo Comune Divisore");
		finestra.setScene(scena);
		finestra.show();
	}

	public void calcola() {
		int numero1, numero2;
		numero1 = Integer.parseInt(cNumero1.getText());
		numero2 = Integer.parseInt(cNumero2.getText());
		for ( int contatore=1; contatore<=numero1 && contatore<=numero2; contatore++) {
			if (numero1%contatore==0 && numero2%contatore==0) {
				eRisultato.setText(contatore + "");
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}