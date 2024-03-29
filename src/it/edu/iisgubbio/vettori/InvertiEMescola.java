package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvertiEMescola extends Application {
	TextField cVettori = new TextField();
	Button bInverti = new Button("Inverti");
	Button bMescola = new Button("Mestolo");
	Label eInverti = new Label();
	Label eMescola = new Label();
	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		griglia.add(cVettori, 0, 0, 2, 1);
		griglia.add(bInverti, 0, 1);
		griglia.add(bMescola, 1, 1);
		griglia.add(eInverti, 0, 2, 2 ,1);
		griglia.add(eMescola, 0, 3, 2 ,1);

		bInverti.setMaxWidth(300);
		bMescola.setMaxWidth(300);

		bInverti.setOnAction(e -> inverti());
		bMescola.setOnAction(e -> mescola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Inverti e Mescola");
		finestra.setScene(scena);
		finestra.show();
	}

	public void inverti() {
		String t=cVettori.getText();
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		String stampa="";
		int scambia;

		for(int pos = 0;pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
		}
		for(int pos = 0 ;pos<parti.length/2;pos++) {
			scambia=numeri[parti.length-1-pos];
			numeri[parti.length-1-pos]=numeri[pos];
			numeri[pos]=scambia;

		}
		for(int pos = 0;pos<parti.length;pos++) {
			stampa+=numeri[pos] + " ";
		}
		eInverti.setText(stampa);
	}
	public void mescola() {
		String t=cVettori.getText();
		String[] parti=t.split(" ");
		int numeri[]= new int[parti.length];
		String stampa="";
		int scambia;
		
		for(int pos = 0;pos<parti.length;pos++) {
			numeri[pos]=Integer.parseInt(parti[pos]);
		}

		for(int pos = 0 ;pos<parti.length/2;pos++) {
			int randomPos1 = (int) (Math.random()*parti.length);		
			scambia=numeri[randomPos1];
			numeri[randomPos1]=numeri[pos];
			numeri[pos]=scambia;
		}
		for(int pos = 0;pos<parti.length;pos++) {
			stampa+=numeri[pos] + " ";
		}
		eMescola.setText(stampa);
	}
	public static void main(String[] args) {
		launch(args);
	}
}