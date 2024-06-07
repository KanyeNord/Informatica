package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Posizione extends Application {
	TextField cVettore = new TextField();
	TextField cNumero = new TextField();
	Button bPosizione = new Button("pos");
	Label eRisultato = new Label();
	int contatore=0;
	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		griglia.add(cVettore, 0, 0, 2, 1);
		griglia.add(cNumero, 0, 1);
		griglia.add(bPosizione, 1, 1);
		griglia.add(eRisultato, 0, 2, 2 ,1);
		
		bPosizione.setMaxWidth(300);
		bPosizione.setOnAction(e -> posizione());;

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Posizione");
		finestra.setScene(scena);
		finestra.show();
	}

	public void posizione() {
		int numero=Integer.parseInt(cNumero.getText());
		String t=cVettore.getText();
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		boolean presente=false;
		for(int pos = 0; pos<parti.length && !presente ;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
			if(numeri[pos]==numero) {
				presente=true;
				contatore=pos;
			}

		}
		if (presente) {
			eRisultato.setText(contatore + "");
		} else {
			eRisultato.setText("il numero non è presente");
			
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}