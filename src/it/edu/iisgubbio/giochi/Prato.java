package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Prato extends Application {
	boolean bombe[][] = new boolean[8][8];
	boolean controllato[][] = new boolean[8][8];
	int contatore[] = new int[64];
	Button p;
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		//crea bombe in posizione casuale
		for(int i = 0;i<20; i++) {
			int rigaBomba=(int)(Math.random()*8);
			int colonnaBomba=(int)(Math.random()*8);
			bombe[colonnaBomba][rigaBomba]=true;
		}		

		for(int riga = 0;riga<8;riga++) {
			for(int colonna = 0;colonna<8;colonna++) {
				p= new Button("!");
				griglia.add(p, colonna, riga);
				p.setOnAction(e -> bombe(e));
				p.setPrefHeight(30);
				p.setPrefWidth(30);

				//fare il generatore di bombe
				//colora di rosso e verde tutte le caselle
				if(bombe[colonna][riga]==true) {
					p.getStyleClass().add("bomba");
				} else {
					p.getStyleClass().add("prato");
				}
			}
		}

		for(int riga = 0;riga<8;riga++) {
			for(int colonna = 0;colonna<8;colonna++) {
				if (bombe[colonna][riga]==true) {

				}
			}
		}
		/*
		for

		int scambia;
		for(int pos = 0 ;pos<contatore.length-1;pos++) {
			contatore[pos]=pos+1;		
		}

		for(int pos = 0 ;pos<contatore.length/2;pos++) {
			int randomPos1 = (int) (Math.random()*contatore.length);		
			scambia=contatore[randomPos1];
			contatore[randomPos1]=contatore[pos];
			contatore[pos]=scambia;
		}
		for(int i = 0;i<20; i++) {
			int rigaBomba=(int)(Math.random()*64);
			bombe[rigaBomba][colonnaBomba]=true;
		}*/






		Scene scena = new Scene (griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/Giochi/Prato.css");
		finestra.setTitle("Prato"); 
		finestra.setScene(scena);
		finestra.show();
	}
	public void bombe(Event e){
		Button a=(Button)e.getSource();
		int contaBombe=0;
		int riga=GridPane.getRowIndex(a);
		int colonna=GridPane.getColumnIndex(a);

		//destra
		if(colonna!=7 && bombe[colonna+1][riga]) {
			contaBombe+=1;
		}
		//alto destra
		if(colonna!=7 && riga!=0 && bombe[colonna+1][riga-1]) {
			contaBombe+=1;
		}
		//alto
		if(riga!=0 && bombe[colonna][riga-1]) {
			contaBombe+=1;
		}
		//alto sinistra
		if(colonna!=0 && riga!=0 && bombe[colonna-1][riga-1]) {
			contaBombe+=1;
		}
		//sinistra
		if(colonna!=0 && bombe[colonna-1][riga]) {
			contaBombe+=1;
		}
		//basso sinistra
		if(colonna!=0 && riga!=7 && bombe[colonna-1][riga+1]) {
			contaBombe+=1;
		}
		//basso
		if(riga!=7 && bombe[colonna][riga+1]) {
			contaBombe+=1;
		}
		//basso destra
		if(colonna!=7 && riga!=7 && bombe[colonna+1][riga+1]) {
			contaBombe+=1;
		}
		//scopri automaticamente le caselle con 0
		if(contaBombe==0) {
			noBombe(colonna+1, riga);
			noBombe(colonna+1, riga-1);
			noBombe(colonna, riga-1);
			noBombe(colonna-1, riga-1);
			noBombe(colonna-1, riga);
			noBombe(colonna-1, riga+1);
			noBombe(colonna, riga+1);
			noBombe(colonna+1, riga+1);
			
		}




		if(bombe[colonna][riga]==true) {
			a.setText("X");
		} else {
			a.setText(contaBombe+"");
		}	
	}

	int noBombe(int colonna, int riga) {
		int contaBombe=0;
		//destra
		if(colonna!=7 && bombe[colonna+1][riga]) {
			contaBombe+=1;
		}
		//alto destra
		if(colonna!=7 && riga!=0 && bombe[colonna+1][riga-1]) {
			contaBombe+=1;
		}
		//alto
		if(riga!=0 && bombe[colonna][riga-1]) {
			contaBombe+=1;
		}
		//alto sinistra
		if(colonna!=0 && riga!=0 && bombe[colonna-1][riga-1]) {
			contaBombe+=1;
		}
		//sinistra
		if(colonna!=0 && bombe[colonna-1][riga]) {
			contaBombe+=1;
		}
		//basso sinistra
		if(colonna!=0 && riga!=7 && bombe[colonna-1][riga+1]) {
			contaBombe+=1;
		}
		//basso
		if(riga!=7 && bombe[colonna][riga+1]) {
			contaBombe+=1;
		}
		//basso destra
		if(colonna!=7 && riga!=7 && bombe[colonna+1][riga+1]) {
			contaBombe+=1;
		}
		
		if(contaBombe==0) {
			noBombe(colonna+1, riga);
			noBombe(colonna+1, riga-1);
			noBombe(colonna, riga-1);
			noBombe(colonna-1, riga-1);
			noBombe(colonna-1, riga);
			noBombe(colonna-1, riga+1);
			noBombe(colonna, riga+1);
			noBombe(colonna+1, riga+1);
			
		}
		return contaBombe;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
//卐