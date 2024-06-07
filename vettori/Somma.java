package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application {
	TextField cElementi = new TextField();
	Button bSomma = new Button("somma");
	Button bCrescente = new Button("verifica");
	Label eRisultato = new Label();

	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		griglia.add(cElementi, 0, 0);
		griglia.add(bSomma, 0, 1);
		griglia.add(bCrescente, 0, 2);
		griglia.add(eRisultato, 0, 3);

		bSomma.setMaxWidth(300);
		bCrescente.setMaxWidth(300);

		bSomma.setOnAction(e -> somma());
		bCrescente.setOnAction(e -> crescente());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Somma, crescente e decrescente");
		finestra.setScene(scena);
		finestra.show();
	}

	public void somma() {
		String t=cElementi.getText();
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		int somma=0;
		for(int pos = 0;pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
			somma+=numeri[pos];
		}
		eRisultato.setText(""+somma);

	}
	public void crescente() {
		String t=cElementi.getText();
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		int verificaC=0;

		boolean crescente=true,decrescente=true;
		for(int pos = 0;pos<parti.length;pos++) {

			numeri[pos]=Integer.parseInt(parti[pos]);
			if(numeri[pos]<=verificaC) {
				crescente=false;
			}
			verificaC=numeri[pos];
		}

		int verificaD=numeri[0]+1;

		for(int pos = 0;pos<parti.length;pos++) {
			if(numeri[pos]>verificaD) {
				decrescente=false;
			}
			verificaD=numeri[pos];
		}

		if (crescente==true) {
			eRisultato.setText("è crescente");
		} else {
			if (decrescente==true) {
				eRisultato.setText("è decrescente");
			} else {
				eRisultato.setText("non è ne crescente ne decrescente");
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}