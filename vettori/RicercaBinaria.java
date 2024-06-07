package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RicercaBinaria extends Application {
	TextField cElementi = new TextField();
	TextField cNumero = new TextField();
	Button bRicerca = new Button("Ricerca");
	Label eRisultato = new Label();
	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label eRisultato = new Label();
		Label eOrdine = new Label("metti in ordine");

		griglia.add(eOrdine, 0, 0);
		griglia.add(cElementi, 0, 1, 2 ,1);
		griglia.add(cNumero, 0, 2);
		griglia.add(bRicerca, 1, 2);
		griglia.add(eRisultato, 0, 3, 2 ,1);
		
		bRicerca.setOnAction(e -> ricerca());
		
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
		int cercato = Integer.parseInt(cNumero.getText());
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		boolean presente=false;
		for(int pos = 0;pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
		}
		int  metà,inizio=numeri[0],fine=numeri.length-1;
		while(inizio<fine) {
			metà=(fine+inizio)/2;
			if (numeri[metà]==cercato) {
				presente=true;
				break;
			} else {
				if (numeri[metà]<cercato) {
					inizio=metà+1;
				} else {
					fine=metà-1;
				}
			}
		}

		if (presente) {
				eRisultato.setText(cercato + " è presente nella lista");
		} else {
			eRisultato.setText(cercato + " non è presente nella lista");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}