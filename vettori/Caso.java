package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caso extends Application {
	TextField cElementi = new TextField();
	TextField cMin = new TextField();
	TextField cMax = new TextField();

	Button bGenera = new Button("Genera");
	Button bStampa = new Button("Stampa");
	Button bPari = new Button("Pari");
	Button bSomma = new Button("Somma");
	Button bDueETre = new Button("2 e 3");
	Button bRisultatoMin = new Button("Min");
	
	Label eVettore = new Label();
	Label ePari = new Label();
	Label eSomma = new Label();
	Label eDueETre = new Label();
	Label eRisultatoMin = new Label();
	
	int vettore[];
	int pos=0;

	@Override
	public void start(Stage finestra) {
		Label eElementi = new Label("Elementi");
		Label eMin = new Label("Min");
		Label eMax = new Label("Max");
		

		GridPane griglia = new GridPane();


		griglia.add(eElementi, 0, 0);
		griglia.add(cElementi, 1, 0);
		griglia.add(eMin, 0, 1);
		griglia.add(cMin, 1, 1);
		griglia.add(eMax, 0, 2);
		griglia.add(cMax, 1, 2);
		griglia.add(bGenera, 0, 3);
		griglia.add(bStampa, 1, 3);
		griglia.add(eVettore, 0, 4, 2, 1);
		griglia.add(bPari, 0, 5);
		griglia.add(ePari, 1, 5);
		griglia.add(bSomma, 0, 6);
		griglia.add(eSomma, 1, 6);
		griglia.add(bDueETre, 0, 7);
		griglia.add(eDueETre, 1, 7);
		griglia.add(bRisultatoMin, 0, 8);
		griglia.add(eRisultatoMin, 1, 8);

		eVettore.setMaxWidth(300);
		bStampa.setMaxWidth(300);
		bPari.setMaxWidth(300);
		bSomma.setMaxWidth(300);
		bDueETre.setMaxWidth(300);
		bRisultatoMin.setMaxWidth(300);
		

		bGenera.setOnAction(e -> genera());	
		bStampa.setOnAction(e -> stampa());
		bPari.setOnAction(e -> pari());
		bSomma.setOnAction(e -> somma());
		bDueETre.setOnAction(e -> dueETre());
		bRisultatoMin.setOnAction(e -> minimo());
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Caso");
		finestra.setScene(scena);
		finestra.show();
	}

	public void genera() {
		int elementi = Integer.parseInt(cElementi.getText());
		int min = Integer.parseInt(cMin.getText());
		int max = Integer.parseInt(cMax.getText());
		int numero=0;
		vettore = new int[elementi];
		for(pos=0;pos<vettore.length;pos++) {
			numero=(int)(Math.random() * (max-min)+1)+min;
			vettore[pos]= numero;
		}
		
	}

	public void stampa() {
		String lista="";
		for(pos=0;pos<vettore.length;pos++) {
			if (lista.equals("")) {
				lista += "" + vettore[pos];
			} else {
				lista += "," + vettore[pos];
			}	
		}
		eVettore.setText(""+lista);
	}

	public void pari() {
		int contatore=0;
		for(pos=0; pos < vettore.length; pos++) {
			if(vettore[pos]%2==0) {
				contatore++;
			}
		}
		ePari.setText("" + contatore);
	}
	public void somma() {
		int somma=0;
		for(pos=0; pos < vettore.length; pos++) {
			somma+=vettore[pos];
			}
		eSomma.setText("" + somma);
		}
	public void dueETre() {
		int somma=0;
		for(pos=0; pos < vettore.length; pos++) {
			if(vettore[pos]%2==0 && vettore[pos]%3==0) {
				somma+=vettore[pos];
			}
		}
		eDueETre.setText("" + somma);
	}
	public void minimo() {
		int rMin=vettore[0];
		for(pos=0; pos < vettore.length; pos++) {
			if(vettore[pos]<rMin) {
				rMin=vettore[pos];
			}
		}
		eRisultatoMin.setText("" + rMin);
	}

	public static void main(String[] args) {
		launch(args);
	}
}