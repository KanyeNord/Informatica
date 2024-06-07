package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Parola25 extends Application {
	Label lettere[][] = new Label[5][5];

	Button pVerifica= new Button("verifica");
	TextField tTesto= new TextField();
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(pVerifica, 0, 7, 5, 1);
		griglia.add(tTesto, 0, 6, 5, 1);
		pVerifica.setPrefWidth(150);
		tTesto.setPrefWidth(150);

		for(int colonna = 0;colonna<5;colonna++) {
			for(int riga = 0;riga<5;riga++) {
				lettere[riga][colonna]= new Label();
				griglia.add(lettere[riga][colonna], riga, colonna);
				lettere[riga][colonna].setPrefHeight(30);
				lettere[riga][colonna].setPrefWidth(30);

				char letteraCasuale=(char)(Math.random()*('z'-'a'+1)+'a');
				lettere[riga][colonna].setText(letteraCasuale+"");
			}
		}
		pVerifica.setOnAction(e -> verifica());

		Scene scena = new Scene (griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/Giochi/Parola25.css");
		finestra.setTitle("Parola25"); 
		finestra.setScene(scena);
		finestra.show();
	}
	public void verifica(){
		char[] parola= tTesto.getText().toCharArray();
		int contatore=0;

		for(int colonna = 0;colonna<5;colonna++) {
			for(int riga = 0;riga<5;riga++) {
				lettere[riga][colonna].getStyleClass().remove("presente");
			}
		}
		tTesto.getStyleClass().remove("assente");
		
		for(int colonna = 0;colonna<5;colonna++) {
			for(int riga = 0;riga<5;riga++) {
				for (int i=0; i<parola.length; i++) {
					if(parola[i]==lettere[riga][colonna].getText().charAt(0)) {
						parola[i]=0;
						contatore+=1;
						lettere[riga][colonna].getStyleClass().add("presente");
						i=parola.length;
					}
				}

			}
		}
		if (contatore!=parola.length) {
			for(int colonna = 0;colonna<5;colonna++) {
				for(int riga = 0;riga<5;riga++) {
					lettere[riga][colonna].getStyleClass().remove("presente");
				}
			}
			tTesto.getStyleClass().add("assente");
			contatore=0;
		} else {
			tTesto.getStyleClass().remove("assente");
			contatore=0;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}