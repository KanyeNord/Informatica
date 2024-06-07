package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScorriCaselle extends Application {
	Button bInserisci = new Button("inserisci");
	Button bRimuovi = new Button("Rimuovi");
	TextField cNumero = new TextField();
	TextField[] casella= new TextField[10];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		for(int i = 0;i<casella.length;i++) {
			casella[i]= new TextField(i+"");
			griglia.add(casella[i], 0, i, 2, 1);
		}
		griglia.add(bInserisci, 0, 10);
		griglia.add(bRimuovi, 1, 10);
		griglia.add(cNumero, 0, 11, 2, 1);

		bInserisci.setMaxWidth(300);
		bRimuovi.setMaxWidth(300);

		bInserisci.setOnAction(e -> inserisci());
		bRimuovi.setOnAction(e -> rimuovi());	
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Caselle");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void inserisci() {
		String numero=cNumero.getText();
		for(int i = 0;i<casella.length-1;i++) {
			casella[i].setText(casella[i+1].getText());
		}
		casella[casella.length-1].setText(numero);
	}

	public void rimuovi() {
		cNumero.setText(casella[casella.length-1].getText());
		for(int i = casella.length-1;i>0;i--) {
			casella[i].setText(casella[i-1].getText());
		}
		casella[0].setText("");
	}
	public static void main(String[] args) {
		launch(args);
	}
}