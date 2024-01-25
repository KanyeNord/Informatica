package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tabellina extends Application{
	Label eRisultato = new Label();
	TextField cNum = new TextField();
	public void start(Stage finestra) throws Exception {
		Label eNum = new Label("numero");
		Button pTabellina = new Button("tabellina");
		GridPane griglia = new GridPane();

		griglia.setGridLinesVisible(false);
		griglia.add(eNum, 0, 0);
		griglia.add(cNum, 1, 0);
		griglia.add(pTabellina, 0, 1, 2, 1);
		griglia.add(eRisultato, 0, 2, 2, 1);

		pTabellina.setMaxWidth(300);
		pTabellina.setOnAction(e -> tabellina());

		griglia.setId("griglia");
		griglia.getStylesheets().add("it/edu/iisgubbio/matematica/Tabellina.css");
		Scene scena = new Scene (griglia);
		finestra.setTitle("Tabellina");
		finestra.setScene(scena);
		finestra.show();

	}

	public void tabellina() {
		int numero, contatore, sequenza=0;
		String tabellina = "0";
		numero = Integer.parseInt(cNum.getText());


		for ( contatore=1; contatore<=10; contatore++) {
			sequenza = (contatore*numero);
			tabellina += ", " + (sequenza);

		}
		eRisultato.setText(tabellina);
	}
	public static void main(String[] args) {
		launch(args);
	}
}