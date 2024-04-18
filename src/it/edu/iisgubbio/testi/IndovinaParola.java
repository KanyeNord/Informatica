package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndovinaParola extends Application {
	TextField cNome = new TextField();
	Button bVia = new Button("Via");
	Button bProva = new Button("Prova");
	TextField cLettera = new TextField();
	char nome[];
	char nomeCensurato[];

	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label eNome = new Label("nome");
		Label eLettera = new Label("lettera");

		griglia.add(eNome, 0, 0);
		griglia.add(cNome, 1, 0);
		griglia.add(eLettera, 0, 1);
		griglia.add(cLettera, 1, 1);
		griglia.add(bVia, 2, 0);
		griglia.add(bProva, 2, 1);

		bVia.setMaxWidth(300);
		bProva.setMaxWidth(300);

		bVia.setOnAction(e -> via());
		bProva.setOnAction(e -> prova());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Indovina Parola");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void via() {
		String t=cNome.getText();
		nome=t.toCharArray();
		nomeCensurato=t.toCharArray();

		for(int pos = 1 ;pos<nome.length-1;pos++) {
			nomeCensurato[pos]='-';
		}
		cNome.setText( new String(nomeCensurato));
	}

	public void prova() {
		char lettera=cLettera.getText().charAt(0);
		for(int i= 0 ;i<nomeCensurato.length;i++) {
			if (nome[i]==lettera) {
				nomeCensurato[i]=lettera;
			}
			String x=new String(nomeCensurato);
			cNome.setText(x);
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}