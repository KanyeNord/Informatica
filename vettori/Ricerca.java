package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ricerca extends Application {
	TextField cElementi = new TextField();
	TextField cNumero = new TextField();
	Button bRicerca = new Button("Ricerca");
	Button bDiFila = new Button("ripetizioni");
	Label eRisultato = new Label();
	Label eDiFila = new Label();
	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label eElementi = new Label("lista");
		Label eNumero = new Label("numero");

		griglia.add(eElementi, 0, 0);
		griglia.add(eNumero, 0, 1);
		griglia.add(cElementi, 1, 0);
		griglia.add(cNumero, 1, 1);
		griglia.add(bRicerca, 0, 2, 2, 1);
		griglia.add(bDiFila, 0, 3, 2, 1);
		griglia.add(eRisultato, 0, 4, 2 ,1);
		griglia.add(eDiFila, 0, 5, 2 ,1);
		
		bRicerca.setMaxWidth(300);
		bDiFila.setMaxWidth(300);
		bDiFila.setVisible(false);
		
		bRicerca.setOnAction(e -> ricerca());
		bDiFila.setOnAction(e -> diFila());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Ricerca");
		finestra.setScene(scena);
		finestra.show();
	}

	public void ricerca() {
		String t=cElementi.getText();
		int numero=Integer.parseInt(cNumero.getText());
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		boolean presente=false;
		int contatore=0;
		for(int pos = 0;pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
			if(numeri[pos]==numero) {
				presente=true;
				contatore++;
				bDiFila.setVisible(true);
			}
		}
		if (presente) {
			if (contatore==1) {
				eRisultato.setText(numero + " è presente nella lista " + contatore + " volta");
			} else {
				eRisultato.setText(numero + " è presente nella lista " + contatore + " volte");
			}
		} else {
			eRisultato.setText(numero + " non è presente nella lista");
		}
	}
	public void diFila() {
		String t=cElementi.getText();
		int numero=Integer.parseInt(cNumero.getText());
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		boolean inFila=false;
		numeri[0]=Integer.parseInt(parti[0]);
		for(int pos = 1;pos<=parti.length-1;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
			if(numeri[pos]==numeri[pos-1] && numeri[pos]==numero) {
				inFila=true;
			}
		}
		if (inFila) {
			eDiFila.setText(numero + " è presente più volte di fila");
		}else {
			eDiFila.setText(numero + " non è presente più volte di fila");
		}	
	}

	public static void main(String[] args) {
		launch(args);
	}
}