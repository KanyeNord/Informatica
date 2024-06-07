package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Indovina extends Application {

	TextField cNumero = new TextField();
	Label eSoluzione = new Label();
	int numeroR = (int)(Math.random()*100)+1;
	Button pProva = new Button("prova");


	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label eNumero = new Label("numero:");
		Button pGenera = new Button("genera nuovo");


		griglia.setGridLinesVisible(false);


		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pGenera, 0, 1);
		griglia.add(pProva, 1, 1);
		griglia.add(eSoluzione, 0, 2, 2, 1);

		pProva.setMaxWidth(500);

		eSoluzione.setMaxWidth(500);
		
		pGenera.setOnAction(e -> genera());
		pProva.setOnAction(e -> prova());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Indovina");
		finestra.setScene(scena);
		finestra.show();

	}
	public void genera() {
		numeroR = (int)(Math.random()*100)+1;
	}
	public void prova() {
		Image immagine = new Image(getClass().getResourceAsStream("Gato.png"));
		ImageView visualizzatoreImmagine = new ImageView(immagine);
		visualizzatoreImmagine.setFitHeight(20);
		visualizzatoreImmagine.setPreserveRatio(true);	
		pProva.setGraphic(visualizzatoreImmagine);

		int numero;
		numero = Integer.parseInt(cNumero.getText());

		if (numero>numeroR) {
			eSoluzione.setText("troppo grande");
		} else {
			if (numero<numeroR) {
				eSoluzione.setText("troppo piccolo");
			} else {
				eSoluzione.setText("BRAVO MATEOOOO");
			}
		}

	}
	public static void main(String[] args) {
		launch(args);
	}
}