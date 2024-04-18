package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvertiMescolaEDuplica extends Application {
	TextField cVettori = new TextField();
	Button bInverti = new Button("Inverti");
	Button bMescola = new Button("Mestolo");
	Button bDuplica = new Button("Duplica");
	Label eInverti = new Label();
	Label eMescola = new Label();
	Label eDuplica = new Label();
	Label eDuplicaRimosso = new Label();
	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		griglia.add(cVettori, 0, 0, 2, 1);
		griglia.add(bInverti, 0, 1);
		griglia.add(bMescola, 1, 1);
		griglia.add(eInverti, 0, 2);
		griglia.add(eMescola, 1, 2);
		griglia.add(bDuplica, 0, 3, 2, 1);
		griglia.add(eDuplica, 0, 4);
		griglia.add(eDuplicaRimosso, 1, 4);

		bInverti.setMaxWidth(300);
		bMescola.setMaxWidth(300);
		bDuplica.setMaxWidth(300);

		bInverti.setOnAction(e -> inverti());
		bMescola.setOnAction(e -> mescola());
		bDuplica.setOnAction(e -> duplica());
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Inverti e Mescola");
		finestra.setScene(scena);
		finestra.show();
	}

	int[] testoVettore(String testo) {
		String[] parti=testo.split(" ");
		int n[]= new int[parti.length];
		for(int pos = 0;pos<n.length;pos++) {
			n[pos]=Integer.parseInt(parti[pos]);
		}
		return n;
	}
	
	String daVettoreATesto(int[] numeriDaStampare) {
		String stampa="";
		for(int pos = 0;pos<numeriDaStampare.length;pos++) {
			stampa+=numeriDaStampare[pos] + " ";
		}
		return stampa;
	}
	public void inverti() {
		String t=cVettori.getText();
		int scambia;
		int numeri[];
		
		numeri=testoVettore(t);
		for(int pos = 0 ;pos<numeri.length/2;pos++) {
			scambia=numeri[numeri.length-1-pos];
			numeri[numeri.length-1-pos]=numeri[pos];
			numeri[pos]=scambia;
		}
		eInverti.setText(daVettoreATesto(numeri));
	}
	public void mescola() {
		String t=cVettori.getText();
		int scambia;
		int numeri[];
		
		numeri=testoVettore(t);
		for(int pos = 0 ;pos<numeri.length/2;pos++) {
			int randomPos1 = (int) (Math.random()*numeri.length);		
			scambia=numeri[randomPos1];
			numeri[randomPos1]=numeri[pos];
			numeri[pos]=scambia;
		}
		eMescola.setText(daVettoreATesto(numeri));
	}

	public void duplica() {
		String t=cVettori.getText();
		boolean duplicati=false;
		int contatoreDuplicati=0;
		int numeri[];
		int corto[];
		
		numeri=testoVettore(t);
		
		for(int pos = 0 ;pos<numeri.length;pos++) {
			for(int i = pos+1 ;i<numeri.length;i++) {
				if (numeri[pos]==numeri[i]) {
					duplicati=true;
				}
			}
			if (duplicati) {
				contatoreDuplicati++;
				duplicati=false;
			}
		}
		corto=new int[numeri.length-contatoreDuplicati];
		
		for(int pos = 0, n=0 ;pos<numeri.length;pos++) {
			for(int i=pos+1 ;i<numeri.length;i++) {
				if (numeri[pos]==numeri[i]) {
					duplicati=true;
				}
			}
			if (duplicati==false) {
				corto[n]=numeri[pos];
				n++;
			} else {
				duplicati=false;
			}
		}
		eDuplica.setText(contatoreDuplicati+"");
		eDuplicaRimosso.setText(daVettoreATesto(corto));
	}
	public static void main(String[] args) {
		launch(args);
	}
}